import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns={"/A1s"})
public class A1s extends HttpServlet{
	
	private ArrayList<Message> messages = new ArrayList<Message>();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HTMLGen hgen = new HTMLGen();
		PrintWriter out = response.getWriter();

		String inting=request.getParameter("int");

		if(messages.size()<1){
			Message test = new Message("please click url bar and hit enter to reload", "Wei", getTime(), "chrome refresh button buffers, causing last message to be resent", true);
			Message test2 = new Message("reply message does not indent", "Wei", getTime(), "It does work on generated messages like these, but doPost cannot test if a parameter is null for some reason, that is the \"int?\" you see when replying to msg");
			messages.add(test);
			messages.add(test2);
		}


		if(inting==null){
			out.println(hgen.header("Forum","style.css","script.js"));
			out.println(hgen.h1("SENG2050 Discussion Board"));
			out.println(hgen.div(messages));
			out.println(hgen.form());
			out.println(hgen.endbody());
			out.println(hgen.end());
		}else{
			out.println(hgen.header("Reply to message","style.css","script.js"));
			out.println(hgen.h1("Reply to message"));
			out.println(hgen.form());
			out.println(hgen.endbody());
			out.println(hgen.end());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		
		String inting=request.getParameter("int");
		int feed=0;
		//this doesn't work, inting is always null in dopost, regardless of it being there or not
		if(inting!=null){System.out.print("true?");feed = Integer.parseInt(inting);
		}

		String uname=request.getParameter("uname");
		String title=request.getParameter("title");
		String message=request.getParameter("message");

		if(inting==null&&validate(uname, title, message)==true){
			Message m = new Message(title, uname, getTime(), message, true);
			messages.add(m);
			System.out.print("new msg");
		}else if(validate(uname, title, message)==true){
			Message m = new Message(title, uname, getTime(), message);
			messages.add(feed+1,m);
			System.out.print("old msg");
		}

		doGet(request, response);
	}

	private boolean validate(String uname, String title, String message){
		if(uname==""||uname.trim().isEmpty()){return false;}
		if(title==""||title.trim().isEmpty()){return false;}
		if(message==""||message.trim().isEmpty()){return false;}
		if(message.length()>50){return false;}
		return true;
	}
	private String getTime()
	{
		SimpleDateFormat timecontainer = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		Date dateTime = new Date();
		String time = timecontainer.format(dateTime);
		return time;
	}
}
