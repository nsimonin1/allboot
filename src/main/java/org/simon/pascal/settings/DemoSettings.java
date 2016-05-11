package org.simon.pascal.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="demo")
public class DemoSettings {
	@Getter@Setter
	private String appName;
	@Getter@Setter
	private String version;
	@Getter@Setter
	private String author;
	@Getter@Setter
	private String lastestUpdate;

}
