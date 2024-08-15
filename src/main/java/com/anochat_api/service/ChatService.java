package com.anochat_api.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anochat_api.dao.ChatDao;

@Service
public class ChatService {
    
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private ChatDao chatDao;

    
}
