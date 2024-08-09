package com.anochat_api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.mapper.MessageMapper;

@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    // @Autowired
    // private MessageDao messageDao;

    // public List<MessageDto> getMessageList() {
    //     List<MessageDto> messages = new ArrayList<MessageDto>();

    //     try {
    //         messages = messageDao.getMessageList();
    //     } catch (Exception e) {
    //         log.error("データベース接続でエラーが発生しました。");
    //     }

    //     return messages;
    // }
    // ↑TestDaoにあたるものがこれだが、ChatGPTなどや他のもので調べてもDaoを2つ作る意味がわからないので、一旦なしにしている

    @Autowired
    private MessageMapper messageMapper;

    public List<MessageDto> getMessageList(String chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageMapper.getMessageList(chatid);
        } catch (Exception e) {
            log.error(chatid, e);
        }

        return messages;
        // return messageMapper.getMessageList(chatid);
    }
}