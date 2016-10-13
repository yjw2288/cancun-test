package com.cancun.config.handlebars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PagenationHelper implements Helper<Page<?>> {
	@Override
	public Object apply(Page<?> context, Options options) throws IOException {
		int page = context.getNumber() + 1;
		int start = (page / 10) + getReminderPage(page);
		int end = start + 4;

		Map<String, Object> paginationModel = new HashMap<>();
		paginationModel.put("start", start);
		paginationModel.put("end", end);
		paginationModel.put("currentPage", context.getNumber() + 1);

		return options.fn(paginationModel);
	}

	private int getReminderPage(int page) {
		int x = page % 10;
		return (x <= 5)? 1 : 6;
	}
}
