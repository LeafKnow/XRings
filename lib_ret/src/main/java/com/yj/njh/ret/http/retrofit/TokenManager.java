package com.yj.njh.ret.http.retrofit;

import com.blankj.utilcode.util.SPUtils;


/**
 *Token 管理类
 */
public class TokenManager {
    private String mToken;

    public static final String SP_TOKEN = "token";


    private static TokenManager sUserInfoManager = new TokenManager();

    private TokenManager() {
    }

    public static TokenManager getInstance() {
        return sUserInfoManager;
    }

    public void initOnApplicationCreate() {
        mToken = (String) SPUtils.getInstance().getString(SP_TOKEN,"");
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
        SPUtils.getInstance().put(SP_TOKEN, token);
    }

    public void clearToken() {
        mToken = "";
        SPUtils.getInstance().remove(SP_TOKEN);
    }
}
