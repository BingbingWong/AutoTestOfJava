package com.course.utils;
import com.course.model.InerfaceName;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);
    private static  String getUrl(InerfaceName name){
        String address=bundle.getString("test.url");
        String uri="";
        //最终测试地址
        String testUrl;
        if(name==InerfaceName.GETUSERLIST){
            uri=bundle.getString("getUserList.uri");
        }
        if(name==InerfaceName.LOGIN){
            uri=bundle.getString("login.uri");
        }
        if(name==InerfaceName.UPDATEUSERINFO){
            uri=bundle.getString("updateUserInfo.uri");
        }
        if(name==InerfaceName.GETUSERINFO){
            uri=bundle.getString("getUserInfo.uri");
        }
        if(name==InerfaceName.ADDUSERINFO){
            uri=bundle.getString("addUser.uri");
        }
        testUrl=address+uri;
        return null;
    }
}
