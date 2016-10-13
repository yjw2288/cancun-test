package com.cancun.config.handlebars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateHelper implements Helper<Date> {
	@Override
	public Object apply(Date context, Options options) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat(options.param(0, "yyyy-MM-dd"));
		return sdf.format(context);
	}
}
