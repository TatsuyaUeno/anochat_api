package com.anochat_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anochat_api.dao.MessageDao;
import com.anochat_api.dto.MessageDto;
import com.anochat_api.dto.MessageResponseDto;

@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

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
    private MessageDao messageDao;

    public List<MessageResponseDto> getMessageList(int chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageDao.getMessage(chatid);
        } catch (Exception e) {
            log.error(String.valueOf(chatid), e);
        }

        return messages.stream()
                .map(this::formatMessage)
                .collect(Collectors.toList());
        // return messageMapper.getMessageList(chatid);
    }

    private MessageResponseDto formatMessage(MessageDto message) {
        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setChatid(message.getChatid());
        responseDto.setMessageid(message.getMessageid());
        responseDto.setMessage(message.getMessage());
        return responseDto;
    }
}