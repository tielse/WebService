package com.chauthoiit.kali.tools;

import java.net.MalformedURLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static boolean sendMail(String to, String subject, String txt_msg) throws MalformedURLException {

		final String email = "chauthoi_it@gmail.com";
		final String password = "123456789";

		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		Session session = Session.getInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(email, password);
			}
		});
		try {
			// EmailAttachment attach = new EmailAttachment();
			// attach.setURL(new URL("mualban.esy.es"));
			// attach.setDescription(EmailAttachment.ATTACHMENT);
			// attach.setDescription("Kali Security Team");
			// attach.setName("Kali Security Team");
			// MultiPartEmail message=new MultiPartEmail();
			MimeMessage message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=utf-8");
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(txt_msg);

			Transport.send(message);
			// message.setSSLOnConnect(true);
			// message.setAuthentication(email, password);
			// message.setSubject("Kali Security Team");
			// message.setMsg("Team");
			// message.attach(attach);
			System.out.println("send msg successfull!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// sendMail("chauthoi_it@gmail.com", "tester", "abc");
	}
}
