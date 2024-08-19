package com.anochat_api.service;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anochat_api.dao.NewChatDao;

@Service
public class ChatService {
    
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private NewChatDao chatDao;

    public String createNewChat(String chatName, LocalDateTime createDate) {

        // String res = new String();

        try {
            chatDao.createChat(chatName, createDate);
        } catch (Exception e) {
            log.error(chatName, e);
        }

        return "SUCCESS";
    }

}
