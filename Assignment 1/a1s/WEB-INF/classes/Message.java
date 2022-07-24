//Wei Chen C3355372
//class to represent messages

public class Message {
	
	//class composition variables
	private String title;
	private String user;
	private String time;
	private String message;
	private boolean master;

	public Message(String newtitle, String newuser, String newtime, String newmessage, boolean newmaster){
		title = newtitle;
		user = newuser;
		time = newtime;
		message = newmessage;
		master = newmaster;
	}
	public Message(String newtitle, String newuser, String newtime, String newmessage){
		title = newtitle;
		user = newuser;
		time = newtime;
		message = newmessage;
		master = false;
	}

	//setters
	public void setTitle(String t){
		title=t;
	}
	public void setUser(String u){
		user=u;
	}
	public void setTime(String t){
		time=t;
	}
	public void setMessage(String m){
		message=m;
	}
	public void setMaster(boolean m){
		master = m;
	}

	//getters
	public String getTitle(){
		return title;
	}
	public String getUser(){
		return user;
	}
	public String getTime(){
		return time;
	}
	public String getMessage(){
		return message;
	}
	public boolean getMaster(){
		return master;
	}
}