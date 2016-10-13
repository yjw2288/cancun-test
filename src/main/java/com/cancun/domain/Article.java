package com.cancun.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Article {
	@Id
	private Long id;
	@Column(name = "content", columnDefinition = "text")
	private String content;
}
