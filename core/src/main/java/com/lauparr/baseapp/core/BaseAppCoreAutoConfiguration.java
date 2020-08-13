package com.lauparr.baseapp.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(BaseAppCoreProperties.class)
public class BaseAppCoreAutoConfiguration {

	@Value("${baseapp.prefix}")
	private String prefix;

	@PostConstruct
	public void init() {
		System.out.println("BaseAppCoreModule.init : prefix=" + this.prefix);
	}

}
