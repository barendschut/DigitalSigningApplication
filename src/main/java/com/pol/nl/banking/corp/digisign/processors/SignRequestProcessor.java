package com.pol.nl.banking.corp.digisign.processors;

import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import com.pol.nl.banking.corp.digisign.database.DocumentRepository;
import com.pol.nl.banking.corp.digisign.database.SignatureRepository;
import com.pol.nl.banking.corp.digisign.resource.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.pol.nl.banking.corp.digisign.database.SignRequestRepository;

/**
 * Sign request processor to process the input sign requests.
 *
 */
@Component
public class SignRequestProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SignRequestRepository signRequestRepository;

    @Autowired
    SignatureRepository signatureRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    EmailNotificationService emailService;
    
    @Autowired
    DataSupportProcessor dataSupportRepo;

    /**
     * Method to save the sign request data to the database.
     *
     * @param signRequest
     * @return Messages - if any
     */
    public SignRequest createSignRequest(SignRequest signRequest) {
        try {
            signRequest = signRequestRepository.save(signRequest);
            this.emailService.sendMail(signRequest);
        } catch (MessagingException e) {
            logger.debug("Mail sending failed");
        }
        return signRequest;
    }

    /**
     * Method to fetch all the sign requests from the database.
     *
     * @param pageNo - Page no from the front to facilitate pagination
     * @param employeeId
     * @return list of all the sign requests created by bank employees.
     */
    public List<SignRequest> getSignRequests(int pageNo, Long employeeId) {
    	List<SignRequest> signRequestsList = this.signRequestRepository.getAllSignRequests(new PageRequest(pageNo, 5), employeeId);
        return signRequestsList;
	}


    public Document getDocument(Long documentId) throws SQLException {
        Document document = (Document)documentRepository.findOne(documentId);
        return document;
    }

    public void sign(Long signatureId) throws SQLException {
        Signature signature = (Signature) signatureRepository.findOne(signatureId);
        signature.setActionTaken("Signed");
        signatureRepository.save(signature);
    }

    public List<Signature> getAllSignatures() throws SQLException {
        return (List<Signature>) signatureRepository.findAll();
    }

}

