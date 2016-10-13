package com.cancun.repository;

import com.cancun.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("develop")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleRepositoryTest {
	@Autowired
	private ArticleRepository articleRepository;

	@Test
	public void testRead() {
		articleRepository.findAll();
	}
}