package com.example.maggui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    private Boolean enable;
    private String applicationName;
    private String applicationVersion;
    private String applicationDescription;
    private String tryHost;

    public Boolean getEnable() {
	return enable;
    }

    public void setEnable(Boolean enable) {
	this.enable = enable;
    }

    public String getApplicationName() {
	return applicationName;
    }

    public void setApplicationName(String applicationName) {
	this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
	return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
	this.applicationVersion = applicationVersion;
    }

    public String getApplicationDescription() {
	return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
	this.applicationDescription = applicationDescription;
    }

    public String getTryHost() {
	return tryHost;
    }

    public void setTryHost(String tryHost) {
	this.tryHost = tryHost;
    }
}
