package edu.esprit.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.MessagingException;

import edu.esprit.services.gestion.email.MailService;

@Named
@RequestScoped

public class MailBean {
	
    private String recipient;
    private String subject;
    private String message;
    private String statusMessage = "";
	   public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getRecipient() {
	        return recipient;
	    }

	    public void setRecipient(String recipient) {
	        this.recipient = recipient;
	    }

	    public String getSubject() {
	        return subject;
	    }

	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

	    public String getStatusMessage() {
	        return statusMessage;
	    }
	    
	    public String send() throws MessagingException {
	        statusMessage = "Message Sent";
            MailService.sendMessage("medanwer.zayani@esprit.tn", subject, message);
	       
            FacesMessage message = new FacesMessage("Your Mail was sent succesfully");
    		FacesContext.getCurrentInstance().addMessage(null, message);
	        return "index";  // redisplay page with status message

	    }
	    

}
