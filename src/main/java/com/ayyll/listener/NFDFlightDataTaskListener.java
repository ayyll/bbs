package com.ayyll.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ayyll.timer.TimerManager;

public class NFDFlightDataTaskListener implements ServletContextListener {
	//销毁时执行
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	//服务器启动时候执行
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		new TimerManager();  
	}

}
