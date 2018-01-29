package com.pol.nl.banking.corp.digisign.controllers;

import com.pol.nl.banking.corp.digisign.config.AppConfig;
import com.pol.nl.banking.corp.digisign.helper.Message;
import com.pol.nl.banking.corp.digisign.helper.MessageType;
import com.pol.nl.banking.corp.digisign.processors.SignRequestProcessor;
import com.pol.nl.banking.corp.digisign.resource.Document;
import com.pol.nl.banking.corp.digisign.resource.SignRequest;
import com.pol.nl.banking.corp.digisign.resource.Signature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to create and manage sign requests.
 **/
@RestController
@CrossOrigin
public class SignRequestsController {

    @Autowired
    SignRequestProcessor requestProcessor;

    @Autowired
    AppConfig appConfig;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to create sign request for a particular customer.
     *
     * @param signRequest - input data for creating the sign request
     * @return Response
     */
    @RequestMapping(method = RequestMethod.POST, path = "/signrequests", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<?> createSignRequests(@RequestParam String signRequestString, @RequestParam("documents") List<MultipartFile> documents)
            throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        SignRequest signRequest = objMapper.readValue(signRequestString, SignRequest.class);
        addDocuments(signRequest, documents);
        signRequest = requestProcessor.createSignRequest(signRequest);
        if (0 == signRequest.getId()) {
            return new ResponseEntity<Message>(new Message("Sign Request creation failed",
                    MessageType.ERROR), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Long>(signRequest.getId(), HttpStatus.OK);
        }

    }

    /**
     * @param signRequest
     * @param documents
     * @throws IOException
     */
    private void addDocuments(SignRequest signRequest, List<MultipartFile> documents) throws IOException {
    	List<Document> signDocuments = new ArrayList<>();
    	for (MultipartFile signDocument : documents) {
    		Document signDoc = new Document();
    		signDoc.setActionToTake("true");
        	signDoc.setDocumentData(signDocument.getBytes());
        	signDoc.setFileName(signDocument.getOriginalFilename());
        	signDocuments.add(signDoc);
        }
    	signRequest.setDocuments(signDocuments);
    }

    /**
     * Method to fetch all sign requests created.
     *
     * @return List of sign requests
     */
    @RequestMapping(method = RequestMethod.GET, path = "/signrequests/{pageNo}/{employeeId}", produces = "application/json")
    public ResponseEntity<?> getSignRequests(@PathVariable int pageNo, @PathVariable Long employeeId) {
        List<SignRequest> signRequests = requestProcessor.getSignRequests(pageNo, employeeId);
        return new ResponseEntity<List<SignRequest>>(signRequests, HttpStatus.OK);

    }


    /**
     * Called from Customer Portal
     *
     * @param documentId
     * @param response
     * @return StreamingBody with byte array in it
     * @throws SQLException
     */
    @RequestMapping(method = RequestMethod.GET, path = "/document/{documentId}")
    public StreamingResponseBody getDocument(@PathVariable Long documentId,
                                             HttpServletResponse response) throws SQLException {
        Document signDocument = requestProcessor.getDocument(documentId);
        String documentName = signDocument.getFileName();
        String fileExtension = documentName.substring(documentName.lastIndexOf('.') + 1);

        response.setContentType(appConfig.getResponseContentTypes().get(fileExtension));
        response.setHeader("Content-Disposition", "inline; filename=" + documentName + "");

        byte[] byteArray = signDocument.getDocumentData();
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = bis.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
        };

    }

    /**
     * Called from Customer Portal
     *
     * @param signatureId
     * @return No return value
     * @throws SQLException
     */
    @RequestMapping(method = RequestMethod.POST, path = "/signature/{signatureId}/")
    public void sign(@PathVariable Long signatureId) throws SQLException {
        requestProcessor.sign(signatureId);
    }

    /**
     * Called from Customer Portal
     *
     * @return List of Signatures
     * @throws SQLException
     */
    // TODO: Lookup through Login/Contact
    @RequestMapping(method = RequestMethod.GET, path = "/allsignatures")
    public List<Signature> getAllSignatures() throws SQLException {
        return requestProcessor.getAllSignatures();
    }

}
