package com.cancun.config.handlebars;

import com.cancun.config.ResourcesHandler;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class ResourcesHelper implements Helper<String> {
	@Override
	public Object apply(String context, Options options) throws IOException {
		return "/resources-" + ResourcesHandler.getVersion() + "/" + context;
	}
}
