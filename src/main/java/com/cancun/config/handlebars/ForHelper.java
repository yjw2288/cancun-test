package com.cancun.config.handlebars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class ForHelper implements Helper<Integer> {
	@Override
	public Object apply(Integer context, Options options) throws IOException {
		StringBuilder content = new StringBuilder();
		int end = options.get("end", 0);
		for (int i = context; i <= end; i++) {
			content.append(options.fn(i));
		}
		return content.toString();
	}
}
