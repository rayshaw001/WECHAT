package edu.hubu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hubu.entities.User;
import edu.hubu.service.UserService;

@Controller
public class findController {
	@Resource
	private UserService uService;
	
	@RequestMapping(value="find.do",method=RequestMethod.POST)
	@ResponseBody
	public List<User> getFriends(String keyword)
	{
		List<User> friends = null;
		friends = uService.listUserByHql("from User u where u.name LIKE '" + keyword + "'");
		return friends;
	}
}
