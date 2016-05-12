package edu.hubu.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hubu.entities.Friend;
import edu.hubu.entities.Message;
import edu.hubu.entities.User;
import edu.hubu.service.FriendService;
import edu.hubu.service.MessageService;
import edu.hubu.service.UserService;

@Controller
@RequestMapping("/loging")
public class LoginController {
	@Resource
	private UserService userService;
	@Resource 
	private MessageService msgService;
	@Resource
	private FriendService friendService;
	@ResponseBody
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public List<User> login(@RequestParam(value="username",required=true)String name,
					  @RequestParam(value="password",required=true)String psw,
					  @RequestParam(value="IP",required=true)String IP,
					  HttpServletRequest request,
					  HttpServletResponse response)
	{
		System.out.println(IP);
		User user =null;
		List<User> users = null;
		Friend friend = null;
		User temp = null;
		String msg = "success";
		try
		{
			if(userService.listUserByHql("from User u where u.name = '" + name + "'")!=null)
			{
				user = userService.listUserByHql("from User u where u.name = '" + name + "' and u.password = '" + psw +"'").get(0);
				if(user.getName().equals(name)&&user.getPassword().equals(psw))
				{
					request.getSession().setAttribute("user", user);
					user.setStatus("在线");
					user.setIp(request.getRemoteAddr());
					user.setPort(request.getRemotePort());
					userService.updateUser(user);
					msg = "success";
					users = new ArrayList<User>(); 
					users.add(user);
					//users = userService.listUserByHql("from User u where u.friend.Aid = "+user.getId() +" order by u.friend.Bid");
					for(int i=0;i<user.getFriendsForAid().size();i++)
					{
						friend = user.getFriendsForAid().get(i);
						temp = friend.getUserByBid();
						temp.setMessage(null);
						temp.setMessagesForFromid(null);
						temp.setMessagesForToid(null);
						temp.setPassword(null);
						users.add(temp);
					}
				}
				else
				{
					msg = "fail";
				}
			}
			else
			{
				msg = "fail";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	@RequestMapping("logout.do")
	public void logout(HttpServletRequest request,
					   HttpServletResponse response,
					   @RequestParam(value = "id",required=true)Long id) throws IOException
	{
		User user = null;
		String msg="";
		try
		{
			if(request.getSession()!=null)
			{
				user =(User)request.getSession().getAttribute("user");
				if(user.getId() == id)
				{
					request.getSession().removeAttribute("user");
					user.setStatus("离线");
					user.setIp("");
					user.setPort(0);
					userService.updateUser(user);
					msg = "success";
				}
				else
				{
					msg = "fail";
				}
			}
			else
			{
				msg = "fail";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			msg = "unexpected error";
		}
		response.getWriter().print(msg);
	}
	
	@RequestMapping("/test.do")
	public void test(HttpServletResponse response) throws IOException
	{
		String result;
		result = "<a href='test.do'>refresh</a>";
		List<Message> msgs =  msgService.listMessageByHql("from Message u");
		List<User> users = userService.listUserByHql("from User u");
		result +=users.toString();
		result +=msgs;
		response.getWriter().print(result);
	}

}
