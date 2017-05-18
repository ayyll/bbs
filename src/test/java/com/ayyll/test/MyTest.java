package com.ayyll.test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ayyll.service.ArticleService;
import com.ayyll.service.CommentService;
import com.ayyll.service.impl.ArticleServiceImpl;
import com.ayyll.util.FileUtils;
import com.ayyll.util.PythonUtils;

public class MyTest extends AbstractJUnit{
	
	@Autowired
	private CommentService cs;
	
	@Autowired
	private ArticleService as;
	
	@Test
	public void testAll() throws Exception {
		
	}
}
