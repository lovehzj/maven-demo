package com.github.shoothzj.demo.http;

import com.github.shoothzj.javatool.util.CommonUtil;
import com.github.shoothzj.javatool.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @author hezhangjian
 */
@Slf4j
public class HttpClientKeepAliveTest {

    @Test
    public void keepAliveTest() throws Exception {
        LogUtil.configureLog();
        HttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(poolingConnManager).build();

        {
            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
            final HttpGet httpGet = new HttpGet(uri);
            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            log.debug("status code is {}", statusCode);
        }
        {
            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
            final HttpGet httpGet = new HttpGet(uri);
            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            log.debug("status code is {}", statusCode);
        }
        {
            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
            final HttpGet httpGet = new HttpGet(uri);
            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            log.debug("status code is {}", statusCode);
        }
        {
            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
            final HttpGet httpGet = new HttpGet(uri);
            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            log.debug("status code is {}", statusCode);
        }
    }

    @Test
    public void keepAliveServerMaxRequest() throws Exception {
        LogUtil.configureLog();
        HttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(poolingConnManager).build();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        {
                            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                            final HttpGet httpGet = new HttpGet(uri);
                            final CloseableHttpResponse closeableHttpResponse;
                            closeableHttpResponse = httpclient.execute(httpGet);
                            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                            log.debug("status code is {}", statusCode);
                        }
                        {
                            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                            final HttpGet httpGet = new HttpGet(uri);
                            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                            log.debug("status code is {}", statusCode);
                        }
                        {
                            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                            final HttpGet httpGet = new HttpGet(uri);
                            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                            log.debug("status code is {}", statusCode);
                        }
                        {
                            final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                            final HttpGet httpGet = new HttpGet(uri);
                            final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                            final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                            log.debug("status code is {}", statusCode);
                        }
                    } catch (Exception e) {

                    }
                }
            }).start();
        }
        while (true) {
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.debug("status code is {}", statusCode);
            }
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.debug("status code is {}", statusCode);
            }
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.debug("status code is {}", statusCode);
            }
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.debug("status code is {}", statusCode);
            }
        }
    }

    @Test
    public void keepAliveButServerClose() throws Exception {
        LogUtil.configureLog();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    test();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }).start();
        }
        test();
    }

    private static void test() throws Exception {
        HttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(poolingConnManager).build();
        while (true) {
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.info("status code is {}", statusCode);
            }
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.info("status code is {}", statusCode);
            }
            CommonUtil.sleep(TimeUnit.SECONDS, 5);
            {
                final URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(30000).setPath("/liveness").build();
                final HttpGet httpGet = new HttpGet(uri);
                final CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                final int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                log.info("status code is {}", statusCode);
            }
        }
    }

}
