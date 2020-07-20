package com.more.demo.utils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class HttpUtils {
    public static String getResponse(String url, Map<String,String> params){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        try{
            URIBuilder builder=new URIBuilder(url);
            if(params!=null){
                for (String key:params.keySet()){
                    builder.addParameter(key,params.get(key));
                }
            }
            URI uri=builder.build();
            HttpGet httpGet=new HttpGet(uri);
            CloseableHttpResponse response=httpClient.execute(httpGet);//接受get请求的response
            if (response.getStatusLine().getStatusCode()==200){
                return EntityUtils.toString(response.getEntity());//将返回的对象转换成字符串
            }

        }catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return "";
        }
    }
}
