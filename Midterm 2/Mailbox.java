package m2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Mailbox {
	
	Queue<String> messages = new LinkedList<String>();
	private int ext; 
	private static String password;
	private Map<String, String> greetings = new HashMap<String, String>();
	
	public Mailbox(int ext) {
		this.ext = ext;
		//Set the default password
		setPassword("1234");
		// Create default greetings, greeting one is the main greeting
		this.greetings.put("greeting1","Welcome");
		this.greetings.put("greeting2","Welcome!");
		this.greetings.put("greeting3","Welcome!!");
	}
	
	public void addMessage(String msg) {
		this.messages.add(msg);
	}
	
	public void deleteMessage(int index) {
		this.messages.remove(index);
	}
	
	public void updateGreeting(String greeting, String msg) {
		// Ensure there are only three greetings
		if (greeting.equals("greeting1") || greeting.equals("greeting2") || greeting.equals("greeting3")) {
			this.greetings.put(greeting,msg);		
		}
	}
	
	public void setDefaultGreeting(String msg) {
		updateGreeting("greeting1",msg);
	}
	
	public String getDefaultGreeting() {
		return this.greetings.get("greeting1");
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password; 
	}
	
	public boolean isPasswordCorrect(String pass) {
        return pass.equals(password);
	}
}

