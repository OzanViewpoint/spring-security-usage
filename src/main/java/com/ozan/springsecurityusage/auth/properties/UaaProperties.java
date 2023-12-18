package com.ozan.springsecurityusage.auth.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "uaa.auth")
public class UaaProperties {

    private String secret;
    private String headerName;
    private String userParamName = "username";
    private String pwdParamName = "password";
    private List<String> ignoreUrls;
    private List<ClientInfo> clientInfos = new ArrayList<>();
    @Value("${uaa.service-env.single:false}")
    private boolean single;
    @Value("${uaa.auth.token.timeout:18000}")
    private int tokenTimeout;
    @Value("${uaa.auth.refresh-token.timeout:21000}")
    private int refreshTokenTimeout;
    @Value("${yusp.user.password-encrypt-type:Bcrypt}")
    private String encryptType;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getUserParamName() {
        return userParamName;
    }

    public void setUserParamName(String userParamName) {
        this.userParamName = userParamName;
    }

    public String getPwdParamName() {
        return pwdParamName;
    }

    public void setPwdParamName(String pwdParamName) {
        this.pwdParamName = pwdParamName;
    }

    public List<String> getIgnoreUrls() {
        return ignoreUrls;
    }

    public void setIgnoreUrls(List<String> ignoreUrls) {
        this.ignoreUrls = ignoreUrls;
    }

    public int getTokenTimeout() {
        return tokenTimeout;
    }

    public void setTokenTimeout(int tokenTimeout) {
        this.tokenTimeout = tokenTimeout;
    }

    public int getRefreshTokenTimeout() {
        if (refreshTokenTimeout <= this.tokenTimeout) {
            this.refreshTokenTimeout = this.tokenTimeout + 600;
        }
        return refreshTokenTimeout;
    }

    public void setRefreshTokenTimeout(int refreshTokenTimeout) {
        this.refreshTokenTimeout = refreshTokenTimeout;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public List<ClientInfo> getClientInfos() {
        return clientInfos;
    }

    public void setClientInfos(List<ClientInfo> clientInfos) {
        this.clientInfos = clientInfos;
    }

    public static class ClientInfo {
        private String clientId;
        private String password;
        private boolean verifyCode;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(boolean verifyCode) {
            this.verifyCode = verifyCode;
        }
    }
}
