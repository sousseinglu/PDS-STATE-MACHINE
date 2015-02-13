package metier;

import java.util.HashMap;
import java.util.Map;

public class ControllerStoreMessages {
	public static Map<String, String> messageList = new HashMap<String,String>();
	
	public static Map<String, String> getMessages(){
		return messageList;
	}
	
	public static void setMessage(String idCorrel, String message){
		messageList.put(idCorrel, message);
	}

}
