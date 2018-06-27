package com.tuean.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * http链接工具类
 * @author yifei.xush
 * @create 2017-10-23 下午5:07
 */
// TLS协议
public class HttpUtil1 {

    private static SSLContext sslContext;
    private static X509TrustManager tm;
    private static SSLConnectionSocketFactory socketFactory;

    private static Logger log = LoggerFactory.getLogger(HttpUtil1.class.getName());
    // https请求
    private static HttpClient httpClient;

    static {
        try {
            sslContext = SSLContext.getInstance("TLS");
            tm = new PacketsX509TrustManager();
            sslContext.init(null, new TrustManager[]{tm},null);

            socketFactory =new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            RequestConfig defaultRequestConfig= RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
            org.apache.http.config.Registry<ConnectionSocketFactory> socketFactoryRegistry= RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", socketFactory).build();
            PoolingHttpClientConnectionManager connectionManager=new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            httpClient = HttpClients.custom()
                    .setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(defaultRequestConfig).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String getJSON(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
        HttpResponse resp = null;
        // 转化为键值对
        String newUrl=appendUrlByMap(url,params);
        HttpGet get = new HttpGet(newUrl);
        addHeadersByMap(get,headers);
        resp = httpClient.execute(get);
        String buf = IOUtils.toString(resp.getEntity().getContent(),
                Consts.UTF_8);
        return buf;

    }

    public static String postJSON(String url,Map<String, String> headers, String data) {
        HttpResponse resp = null;
        String buf = null;
        HttpPost postRequest = new HttpPost(url);
        if(headers!=null&&headers.size()>0){
            addHeadersByMap(postRequest,headers);
        }
        postRequest.setHeader(HttpHeaders.ACCEPT_CHARSET,"utf-8");
        postRequest.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
        StringEntity input = new StringEntity(data, "utf-8");
        postRequest.setEntity(input);
        try {
            resp = httpClient.execute(postRequest);
            buf = IOUtils.toString(resp.getEntity().getContent(),
                    Consts.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }


    public static String appendUrlByMap(String url, Map<String, String> params) throws IOException {
        StringBuffer stringBuffer=new StringBuffer(url);

        if(CollectionUtils.isEmpty(params)){
            return stringBuffer.toString();
        }

        List<NameValuePair> paramMaps = map2NameValuePairList(params);
        String str = null;
        str = EntityUtils.toString(new UrlEncodedFormEntity(paramMaps, Consts.UTF_8));

        int urlParamsStartIndex=url.indexOf("?");
        if(urlParamsStartIndex<0){
            stringBuffer.append("?");
        }else{
            if(urlParamsStartIndex!=url.length()-1){
                stringBuffer.append("&");
            }
        }
        stringBuffer.append(str);

        return stringBuffer.toString();
    }

    private static List<NameValuePair> map2NameValuePairList(Map<String, String> params){
        List<NameValuePair> paramMaps = new ArrayList<>();
        if(params!=null){
            for (Map.Entry<String, String> param : params.entrySet()) {
                paramMaps.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
        }
        return paramMaps;
    }

    private static void addHeadersByMap(HttpMessage httpMessage, Map<String, String> headers){
        if(headers!=null){
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpMessage.setHeader(header.getKey(), header.getValue());

            }
        }
    }

    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
    public static final void input2byte(InputStream inStream,HttpServletResponse response)
            throws IOException {
         byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            response.getOutputStream().write(buff, 0, rc);
        }
     }
    public static final void input2byte(InputStream inStream,OutputStream outputStream)
            throws IOException {
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            outputStream.write(buff, 0, rc);
        }
    }






}