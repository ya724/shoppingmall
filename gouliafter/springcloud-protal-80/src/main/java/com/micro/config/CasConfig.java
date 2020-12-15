package com.micro.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "cas")
public class CasConfig {

    private String casServerUrlPrefix;
    private String casServerLoginUrl;
    private String casServerLogoutUrl;
    private String localServerUrlPrefix;
    private String casFilterUrlPattern;
    private String localServerLoginUrl;

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getCasServerLogoutUrl() {
        return casServerLogoutUrl;
    }

    public void setCasServerLogoutUrl(String casServerLogoutUrl) {
        this.casServerLogoutUrl = casServerLogoutUrl;
    }

    public String getLocalServerUrlPrefix() {
        return localServerUrlPrefix;
    }

    public void setLocalServerUrlPrefix(String localServerUrlPrefix) {
        this.localServerUrlPrefix = localServerUrlPrefix;
    }

    public String getCasFilterUrlPattern() {
        return casFilterUrlPattern;
    }

    public void setCasFilterUrlPattern(String casFilterUrlPattern) {
        this.casFilterUrlPattern = casFilterUrlPattern;
    }

    public String getLocalServerLoginUrl() {
        return localServerLoginUrl;
    }

    public void setLocalServerLoginUrl(String localServerLoginUrl) {
        this.localServerLoginUrl = localServerLoginUrl;
    }

    public String getCasService() {
        return localServerUrlPrefix + casFilterUrlPattern;
    }

    @Override
    public String toString() {
        return "CasConfig{" +
                "casServerUrlPrefix='" + casServerUrlPrefix + '\'' +
                ", casServerLoginUrl='" + casServerLoginUrl + '\'' +
                ", casServerLogoutUrl='" + casServerLogoutUrl + '\'' +
                ", localServerUrlPrefix='" + localServerUrlPrefix + '\'' +
                ", casFilterUrlPattern='" + casFilterUrlPattern + '\'' +
                ", localServerLoginUrl='" + localServerLoginUrl + '\'' +
                '}';
    }
}
