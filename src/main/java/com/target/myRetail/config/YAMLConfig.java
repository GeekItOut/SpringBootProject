package com.target.myRetail.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class YAMLConfig {
//TODO:For external API
//	@Value("${url}:")
	String datasourceURL;
//	@Value("${username}:")
	String userName;
//	@Value("${password}:")
	String password;
	
}
