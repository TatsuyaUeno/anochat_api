package com.anochat_api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anochat_api.mapper.ChatMapper;

@Repository
public class ChatDao {

    /** チャットMapper */
    @Autowired
    private ChatMapper chatMapper;

    @Transactional
    public void resistChat(String message) {
        chatMapper.registChat(message);
    }
}