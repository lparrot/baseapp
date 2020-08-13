package com.lauparr.baseapp.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "baseapp.core")
public class BaseAppCoreProperties {
	/**
	 * Prefixe par défaut de tous les webservices de l'application (default: /api)
	 */
	private String prefix = "/api";
}
