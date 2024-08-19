package com.anochat_api.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anochat_api.mapper.NewChatMapper;

@Repository
public class NewChatDao {
    
    @Autowired
    private NewChatMapper chatMapper;

    @Transactional
    public void createChat(String chatName, LocalDateTime createDate) {
        chatMapper.createNewChat(chatName, createDate);
    }
}
