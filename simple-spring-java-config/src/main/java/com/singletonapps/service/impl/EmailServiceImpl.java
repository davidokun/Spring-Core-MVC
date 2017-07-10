package com.singletonapps.service.impl;

import com.singletonapps.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailServiceImpl implements EmailService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail() {

        LOGGER.debug("EmailServiceImpl : send email is called!");
    }
}
