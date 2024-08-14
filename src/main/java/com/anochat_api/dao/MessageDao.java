package com.anochat_api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.mapper.MessageMapper;

@Repository
public class MessageDao {

    @Autowired
    private MessageMapper messageMapper;

    // @Transactional
    // public List<MessageDto> findMessageList(int chatid) {
    //     return messageMapper.getMessageList(chatid);
    // }

    // @Transactional
    public List<MessageDto> getMessage(int chatid) {
        return messageMapper.getMessagesByChatId(chatid);
    }
}
