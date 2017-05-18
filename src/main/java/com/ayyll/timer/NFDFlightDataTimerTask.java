package com.ayyll.timer;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import com.ayyll.service.ArticleService;
import com.ayyll.service.CommentService;
import com.ayyll.util.FileUtils;

public class NFDFlightDataTimerTask extends TimerTask{

	@Autowired
	private CommentService cs;
	
	@Autowired
	private ArticleService as;
	
	//每日执行的任务
	@Override
	public void run() {
		List<String> list = new ArrayList<String>();
		File file = new File("save.txt");
		if(file.exists())file.delete();
		try {
			System.out.println("开始爬取糗事百科...");
			Process proc = Runtime.getRuntime().exec("python qsbk.py");    
			proc.waitFor();
			System.out.println("爬取完成...");
		} catch (Exception e) {
			System.out.println("爬取失败");
		}
		if(file.exists()) {
			list = FileUtils.readByLine("save.txt");
		}
			
		//System.out.println(list.size());
		String title = "糗事百科--每日更新~";
		String content = "糗事百科热门段子~每天更新";
		Timestamp ts = new Timestamp(new Date().getTime());
		Integer uid = 21;
		as.addArticle(title, content, ts, uid, "内涵段子");
		int aid = as.getLastId();
		if(list.size() > 0){
			for (String str : list) {
				cs.addComment(str, aid, uid, ts);
			}
		}
			
		System.out.println("更新完成");
	}

}
