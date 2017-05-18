package com.ayyll.timer;

import java.util.Date;
import java.util.Timer;

public class TimerManager {
	private static final long PERIOD_DAY =120L * 1000L; // 每隔一天执行一次

	public TimerManager() {
		Timer timer = new Timer(); // 定时器实例化
		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask(); // 要执行的任务
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task, new Date(), PERIOD_DAY);
	}
}
