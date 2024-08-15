package com.anochat_api.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NewChatDao {
    
    @Autowired
    // private NewChatMapper chatMapper;

    @Transactional
    public void resistChat(Integer chatid, LocalDateTime createDate) {
        // chatMapper.registChat(chatid, createDate);
    }
}
