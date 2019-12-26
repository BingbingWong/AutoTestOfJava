package com.course.httpclient.demo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test() throws IOException {
        //用来存放我们的结果
        String result;
        HttpGet get=new HttpGet("https://www.baidu.com");
        //用来执行get方法
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        //获取响应内容,用实体转换字符串输出
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
