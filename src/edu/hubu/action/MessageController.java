package edu.hubu.action;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.hubu.entities.Friend;
import edu.hubu.entities.Message;
import edu.hubu.entities.User;
import edu.hubu.service.FriendService;
import edu.hubu.service.MessageService;
import edu.hubu.service.UserService;
import edu.hubu.util.*;

@Controller
@RequestMapping("/loged")
public class MessageController {
	@Resource
	private UserService userService;
	@Resource
	private MessageService msgService;
	@Resource FriendService friendService;
	/**
	 * 
	 * @param fid	from id
	 * @param tid	to	id
	 * @param msg	message
	 * @param mid	last received msg message
	 * @param response
	 * @throws IOException
	 * 
	 * result save msg & send broadcast
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="saveMessage.do",method=RequestMethod.POST)
	public void saveMsg(@RequestParam(value="fromID",required=true)Long fid,
						@RequestParam(value="toID",required=true)Long tid,
						@RequestParam(value="msg",required=true)String msg,
						HttpServletResponse response,
						HttpServletRequest request) throws IOException
	{
		Message message = new Message(); 
		User fuser;
		User tuser;
		SendThread st;
		try
		{
			System.out.println("params:");
			System.out.println(fid);
			System.out.println(tid);
			System.out.println(msg);
			fuser = userService.getUserById(fid);
			tuser = userService.getUserById(tid);
			message.setMsg(msg);
			message.setUserByFromid(fuser);
			message.setUserByToid(tuser);
			msgService.saveMessage(message);
			st = ((Map<Long, SendThread>)request.getServletContext().getAttribute("sends")).get(tuser.getId());
			
			sendMsgs(st,fid,tid,msg,message.getId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//broadcast to original sender to inform fail
			response.getWriter().print("fail");
			return ;
		}
		response.getWriter().print("ok");
		return;
	}
	@RequestMapping("/getMessage.do")
	public void getMessgae(@RequestParam(value="id")Long tid,
						   @RequestParam(value="lastMsg")Long lid,
						   HttpServletResponse response)
	{
		List<Message> msgs =null;
		try
		{
			msgs = msgService.listMessageByHql("from Message u where u.lastmsgId > " + lid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
	@RequestMapping("/getAllMessage.do")
	public void getAllMessage(@RequestParam(value="id")Long tid,
							  HttpServletResponse response)
	{
		List<Message> msgs = msgService.listMessageByHql("from Message u");
		
		// convert to other data model eg: json
		
		return;
	}
	@RequestMapping("/updateStatus.do")
	public void updateStatus(@RequestParam(value="id")Long id,
			String status,
			HttpServletResponse response) throws IOException
	{
		try
		{
			User u = userService.getUserById(id);
			u.setStatus(status);
			userService.updateUser(u);
			response.getWriter().print("success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().print("fail");
		}
		
	}
	@RequestMapping(value="/inform.do",method=RequestMethod.POST)
	public void inform(Long id,Long friendId, Long msgId)
	{
		Friend f = friendService.listFriendByHql("from f where f.Aid = " + id + " and f.Bid = " + friendId).get(0);
		f.setRecentMsgID(msgId);
		friendService.updateFriend(f);
	}
	@RequestMapping("/test.do")
	public void test(HttpServletResponse response) throws IOException
	{
		this.getClass().getResourceAsStream("");
		String result;
		result = "<a href='test.do'>refresh</a>";
		Message msg = msgService.getMessageById(new Long(1));
		result += msg.toString();
		response.getWriter().print(result);
	}
	

	private synchronized boolean sendMsgs(SendThread st,Long fid,Long tid,String msg,Long msgId)
	{
		String temp =  fid + ":" +msg + ":" + msgId;
		st.setMsg(temp);
		notifyAll();
		return true;
	}
}
