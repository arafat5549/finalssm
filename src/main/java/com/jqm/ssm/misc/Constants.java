package com.jqm.ssm.misc;

import com.jqm.ssm.util.SessionUtil;

/**
 * Created by wangyaoyao on 2018/8/14.
 */
public class Constants {
    public static boolean Debug(){return true;}
    public static final String SYS_DATABASE = "mysql";
    public static final int DEFALUT_LIMIT = 50; //默认每页显示50条

    public static final String HEADER_CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

   // public static final String KEY_LOGIN = "S_LOGIN_USER";

    /**   完整的redis缓存的key   **/
    public static final String CACHE_KEY_CURRENT_LOGINUSER = SessionUtil.SessionSystemLoginUserName;  //当前登录用户
    public static final String CACHE_KEY_ROLE_LIST          = "rolelist";
    public static final String CACHE_KEY_PERMISSION_LIST   = "permissionlist";

    /**   拼接的redis缓存的key   **/
    public static final String CACHE_KEY_LOGINNAME_ = "logname#";

    public static final String CACHE_KEY_LISTBYMAP_ALL_ = "all";
//    /**
//     * 获取缓存key
//     */
//    public static String getCachekey(String value){
//        return CACHE_KEY_LOGINNAME + value;
//    }
}
