package m2;

import java.util.HashMap;
import java.util.Map;

public class MailBoxSystem {

    private Map <Integer, Mailbox> m1;
    private int extCounter = 0;
   
    // Hard-coded for now.
    private String adminPassword = "ab$!";
    
    public MailBoxSystem() {
        m1 = new HashMap <Integer, Mailbox > ();
    }

    public void createMailbox() {
    	Mailbox mailbox = new Mailbox(extCounter);
    	extCounter++;
    	m1.put(extCounter, mailbox);
    }
    
    public Mailbox getMailBox(int ext) {
    	if (m1.containsKey(ext)) {
        	return m1.get(ext);
    	}
    	return null;
    }

    private void setPassword(int ext, String password) {
    	if (m1.containsKey(ext)) {
        	m1.get(ext).setPassword(password);
    	}
    }

    public boolean isPasswordCorrect(String Apass) {
        return adminPassword.equals(Apass);

    }
    
    public void leaveAMessage(int ext, String message) {
    	m1.get(ext).addMessage(message);
    }
    
    public int getExtCounter() {
    	return extCounter;
    }

}