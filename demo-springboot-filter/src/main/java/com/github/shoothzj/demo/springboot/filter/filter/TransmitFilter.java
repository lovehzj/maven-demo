package com.github.shoothzj.demo.springboot.filter.filter;

import com.github.shoothzj.demo.springboot.filter.service.HttpService;
import com.github.shoothzj.javatool.util.IoUtil;
import com.github.shoothzj.javatool.util.StreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class TransmitFilter implements Filter {

    @Autowired
    private HttpService httpService;

    private Pattern[] filterPatterns = new Pattern[]{Pattern.compile("/v1/example")};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String requestURI = request.getRequestURI();
        if (!needFilter(requestURI)) {
            return;
        }

        Map<String, String> headerMap = new HashMap<>();
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String name = headerNames.nextElement();
            headerMap.put(name, request.getHeader(name));
        }
        String uri = requestURI + "?" + request.getQueryString();
        try {
            final HttpResponse httpResponse = httpService.sendReq("", 8080, request.getMethod(), uri, headerMap, request.getInputStream());
            response.setStatus(httpResponse.getStatusLine().getStatusCode());
            for (Header header : httpResponse.getAllHeaders()) {
                response.addHeader(header.getName(), header.getValue());
            }
            final HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity == null) {
                // this req has no entity
                return;
            }
            final InputStream inputStream = httpEntity.getContent();
            final ServletOutputStream outputStream = servletResponse.getOutputStream();
            IoUtil.copy(inputStream, outputStream);
            StreamUtil.close(inputStream);
            StreamUtil.close(outputStream);
        } catch (Exception e) {
            log.error("forward request failed ", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
    }

    private boolean needFilter(String uri) {
        for (Pattern filterPattern : filterPatterns) {
            if (filterPattern.matcher(uri).matches()) {
                return true;
            }
        }
        return false;
    }

}
