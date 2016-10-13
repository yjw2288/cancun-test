package com.cancun.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yjw2288 on 16. 9. 28.
 */
@Configuration
public class ResourcesHandler extends WebMvcConfigurerAdapter {

	@Value("${static.resource.location}")
	private String staticResourceLocation;

	@Getter
	public static String version = createVersion();

	private static String createVersion() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources-" + version +  "/**").addResourceLocations("/WEB-INF/resources/");
	}
}
