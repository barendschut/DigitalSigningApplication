package com.pol.nl.banking.corp.digisign.processors;

import com.pol.nl.banking.corp.digisign.resource.SignRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pol.nl.banking.corp.digisign.helper.ApplicationConstants;
import com.pol.nl.banking.corp.digisign.resource.SignRequest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    DataSupportProcessor dataSupportProcessor;

    public void sendMail(SignRequest signRequest) throws MessagingException {
        for (SignRecipient signRecipient : signRequest.getSignRecipients()) {
            MimeMessage mailMessage = this.emailSender.createMimeMessage();
            addMailHeader(mailMessage, signRecipient, signRequest.getMessage(), signRequest.getId());
            this.emailSender.send(mailMessage);
        }
    }

    private void addMailHeader(MimeMessage mailMessage, SignRecipient signRecipient, String message, Long requestId) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
        helper.setSubject(ApplicationConstants.MAIL_SUBJECT);
        helper.setText(addMailBody(message,requestId));
        helper.setTo(signRecipient.getContact().getEmail());
        helper.setFrom(ApplicationConstants.NO_REPLY_POL_COM);
    }

	private String addMailBody(String message, Long requestId) {
        StringBuffer mailBody = new StringBuffer(ApplicationConstants.USER_SALUTATION);
        mailBody.append(ApplicationConstants.NEW_LINE);
        mailBody.append(ApplicationConstants.MAIL_BODY_PREFIX);
        mailBody.append(requestId);
        mailBody.append(ApplicationConstants.NEW_LINE);
        mailBody.append(message);
        return mailBody.toString();
    }

}
