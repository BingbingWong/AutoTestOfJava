package com.course.cases;

import com.course.config.TextConfig;
import com.course.model.InerfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TextConfig.getUserInfoUrl= ConfigFile.getUrl(InerfaceName.GETUSERINFO);
        TextConfig.getUserListUrl= ConfigFile.getUrl(InerfaceName.GETUSERLIST);
        TextConfig.addUserUrl=ConfigFile.getUrl(InerfaceName.ADDUSERINFO);
        TextConfig.updateUserInfoUrl=ConfigFile.getUrl(InerfaceName.UPDATEUSERINFO);
        TextConfig.LoginUrl=ConfigFile.getUrl(InerfaceName.LOGIN);

        TextConfig.defaultHttpClient=new DefaultHttpClient();

    }

    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase logincase=session.selectOne("loginCase",1);
        System.out.println(logincase.toString());
        System.out.println(TextConfig.LoginUrl);
        //第一步发请求
        String result=getResult(logincase);
        //验证结果
        Assert.assertEquals(logincase.getExpected(),result);

    }

    private String getResult(LoginCase logincase) throws IOException {
        HttpPost post=new HttpPost(TextConfig.LoginUrl);
        JSONObject param =new JSONObject();
        param.put("userName",logincase.getUserName());
        param.put("password",logincase.getPassword());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response = TextConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        TextConfig.cookieStore=TextConfig.defaultHttpClient.getCookieStore();

        return result;
    }

    @Test(groups="loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase logincase=session.selectOne("loginCase",2);
        System.out.println(logincase.toString());
        System.out.println(TextConfig.LoginUrl);
    }

}
