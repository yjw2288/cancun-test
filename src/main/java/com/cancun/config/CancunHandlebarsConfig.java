package com.cancun.config;

import com.cancun.config.handlebars.*;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancunHandlebarsConfig {
	public static final String HANDLEBARS_VIEW_BASE_PATH = "/WEB-INF/views/";
	public static final String HANDLEBARS_VIEW_SUFFIX = ".hbs";
	public static final boolean FAIL_ON_MISSING_FILE = false;

	public static final int ORDER = 1;

	@Value("${viewresolver.cache}")
	private Boolean viewResolverCache;

	@Bean
	public HandlebarsViewResolver handlebarsViewResolver() {
		HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
		viewResolver.setOrder(ORDER);
		viewResolver.setFailOnMissingFile(FAIL_ON_MISSING_FILE);
		viewResolver.setCache(viewResolverCache);
		viewResolver.setPrefix(HANDLEBARS_VIEW_BASE_PATH);
		viewResolver.setSuffix(HANDLEBARS_VIEW_SUFFIX);

		viewResolver.registerHelper("resources", new ResourcesHelper());
		viewResolver.registerHelper("formatDate", new FormatDateHelper());
		viewResolver.registerHelper("pagination", new PagenationHelper());
		viewResolver.registerHelper("for", new ForHelper());
		viewResolver.registerHelper("equals", new EqualsHelper());

		return viewResolver;
	}
}
