package com.egnyte.recruitment.task.config;


import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacebookClient {

    @Value("${oauth.appId}")
    private String appId;

    @Value("${oauth.appSecret}")
    private String appSecret;

    @Value("${oauth.accessToken}")
    private String accessToken;

    @Value("${oauth.permissions}")
    private String permissions;

    public Facebook facebook() throws FacebookException {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(appId, appSecret);
        facebook.setOAuthPermissions(permissions);
        facebook.setOAuthAccessToken(new AccessToken(accessToken, null));

        return facebook;
    }
}
