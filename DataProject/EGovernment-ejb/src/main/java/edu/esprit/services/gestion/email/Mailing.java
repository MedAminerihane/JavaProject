package edu.esprit.services.gestion.email;

import java.util.Properties;
import java.util.jar.Attributes.Name;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailing {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	private String To;
	private String Code;
	
	private String contenu;
	private String subject;
	private String email;
	private String name;


	public Mailing(String contenu, String subject, String email, String name) {
		super();
		this.contenu = contenu;
		this.subject = subject;
		this.email = email;
		this.name = name;
	}

	public Mailing(String to, String name) {
		super();
		To = "medanwer.zayani@esprit.tn";
		this.name = name;
	}

	public void generateAndSendVerifEmail() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setFrom("ConfirmReservation");
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(To));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		generateMailMessage.setContent("essai", "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "erpairport2015@gmail.com", "fiorentina21838134");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	public void generateAndSendAcceptEmail() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setFrom("ConfirmReservation");
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(To));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String contenu = "<p><span style='font-family: 'times new roman', times; font-size: large;'>Bonjour " + name
				+ "</span></p><p><span style='font-family: 'times new roman', times; color: #ff0000; font-size: large;'>votre reservation a été crée</span></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>";
		generateMailMessage.setContent(contenu, "text/html");
		System.out.println("Your Reservation has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "erpairport2015@gmail.com", "fiorentina21838134");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	public Mailing(String to, String name, String code, String contenu, String subject) {
		super();
		To = "medanwer.zayani@esprit.tn";
		this.name = name;
		Code = code;
		this.contenu = contenu;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
