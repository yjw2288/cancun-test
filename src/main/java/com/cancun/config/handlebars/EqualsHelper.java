package com.cancun.config.handlebars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class EqualsHelper implements Helper<Object> {
	@Override public Object apply(Object context, Options options) throws IOException {
		if(context.equals(options.param(0))) {
			return options.fn();
		}
		return options.inverse();
	}
}
