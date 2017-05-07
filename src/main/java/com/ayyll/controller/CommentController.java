package com.ayyll.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayyll.entity.User;
import com.ayyll.service.CommentService;
import com.ayyll.service.UserService;
import com.ayyll.util.LogUtils;
import com.ayyll.util.RankUtils;

/**
 * @author LJC
 * 帖子评论Controller
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 发表评论
	 * @param content
	 * @param aid
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addComment(
			HttpServletRequest request,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "aid") Integer aid,
			@RequestParam(value = "uid") Integer uid){
		Map<String, String> map = new HashMap<>();
		//插入评论
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//System.out.println(user);
		int result = commentService.addComment(content,aid,uid,new Timestamp(new Date().getTime()));
		if(result>0){
			//回帖经验值+3
			int exp = user.getExp();
			int rank = user.getRank();
			String head_title = user.getHead_title();
			exp += 3;
			//判断是否升级
			if( (exp/20 + 1) > rank) {
				rank++;
				head_title = RankUtils.head_title[rank-1];
			}
			user.setRank(rank);
			user.setExp(exp);
			user.setHead_title(head_title);
			userService.updateUserRank(uid, rank, exp, head_title);
			//更新session
			session.setAttribute("user", user);
			LogUtils.info("回复成功！内容为:"+content);
			map.put("data", "回复成功！");
		}else{
			LogUtils.info("回复失败！");
			map.put("data", "回复失败！");
		}
		return map;
	}
}
