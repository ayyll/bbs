package com.ayyll.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ayyll.entity.PageBean;
import com.ayyll.service.ArticleService;
import com.ayyll.service.CommentService;

public class MyTest extends AbstractJUnit{
	
	@Autowired
	private CommentService cs;
	
	@Test
	public void testAll() {
		cs.addFloorComment(78, 33, 18, " ÷∂Ø");
	}
}
