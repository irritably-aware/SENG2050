//class for generating HTML
import java.util.ArrayList;

public class HTMLGen{

	public static String header(String title, String css, String js){
		String header = doctype()+head(title);
		if(css!=""){header+= stylesheet(css);}
		header+=javascript(js);
		header=header+endhead()+"\n"+body(); 
		return header;
	}

	public static String doctype(){
		return "<!DOCTYPE html>\n<html lang=\"en\">";
	}

	public static String end(){
		return "</html>";
	}

	public static String head(String title){
		return "<head><title>" + title + "</title>";
	}

	public static String endhead(){
		return "</head>";
	}

	public static String body(){
		return "<body>\n";
	}

	public static String endbody(){
		return "</body>\n";
	}

	public static String stylesheet(String css){
		return "<link rel=\"stylesheet\" href=\""+css+"\">";
	}

	public static String javascript(String js){
		return "<script src=\""+js+"\"></script>";
	}

	public static String h1(String heading){
		return "<h1>" + heading + "</h1>";
	}

	public static String div(String div,String c/*lass*/){
		if(c!=""){return "<div class= \""+c+"\">"+div+"</div>";}
		return "<div>"+div+"</div>"; 
	}

	public static String p(String p){
		return "<p> Time:" + p + "</p>"; 
	}

	public static String p(String p, int j){
		String returnstring="";
		returnstring+= "<p class= \"";
		switch(j){
		case 1: case 10:
			returnstring+="one"; break;
		case 2: case 9:
			returnstring+="two"; break;
		case 3: case 8:
			returnstring+="three"; break;
		case 4: case 7:
			returnstring+="four"; break;
		case 5: case 6:
			returnstring+="five"; break;
		}
		returnstring= returnstring+ "\">"+p;
		returnstring += "</end>";
		return returnstring;
	}

	public static String a(String div, int i){
		return "<a href= \"A1s?int="+ i +"\">\n"+div +"</a>";
	}

	//oh no, what terrible violation of encapsulation
	public static String div(ArrayList<Message> a){
		String violation="";
		violation+= "<div class= \""+"messages"+"\">\n";
		int j=0;
		for(int i=0; i<a.size(); i++){
			if(a.get(i).getMaster()==true){j=0;}
			j++;
			String msg = "";
			msg+= p(a.get(i).getTitle(),j)	+"\n";
			msg+= p(a.get(i).getUser(),j)		+"<br>\n";
			msg+= p(a.get(i).getMessage(),j)	+"<br>\n";
			msg+= p(a.get(i).getTime(),j)		+"<br>\n";
			msg = a(msg,i);
			violation+=msg;
		}
		violation+= "</div>\n";
		return violation;
	}

	public static String form(){
		String form = "";

		form+="<form id=\"newmsg\" action=\"A1s\" onsubmit=\"return validateForm(this);\" method=\"post\" class=\"form\">\n";
		form+="<p class= \""+"formp"+"\"><label>New Message</label></p>\n";
		form+="<p class= \""+"formp"+"\"><label for \"uname\">Username:</label></p>\n<input class=\"input\" type=\"text\" id=\"uname\" value=\"anonymous\" name=\"uname\"/ required>\n";
		form+="<p class= \""+"formp"+"\"><label for \"title\">Message title:</label></p>\n<input class=\"input\" type=\"text\" id=\"title\" name=\"title\"/ required>\n";
		form+="<p class= \""+"formp"+"\"><label for \"message\">Message:</label></p>\n<input class=\"input\" type=\"text\" id=\"message\" name=\"message\"/ required><br><br>\n";
		form+="<input type=\"submit\" id=\"submit-btn\" value=\"Submit\"/> \n<input type=\"reset\" id=\"reset-btn\" value=\"Clear\"/>\n</form>\n";

		return form;
	}
}