package com.github.shoothzj.demo.springboot.filter.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;

import java.io.InputStream;
import java.util.Map;

/**
 * @author hezhangjian
 */
@Slf4j
public class HttpService {

    public HttpResponse sendReq(String ip, int port, String method, String uri, Map<String, String> headers, InputStream inputStream) {

        return null;
    }

}
