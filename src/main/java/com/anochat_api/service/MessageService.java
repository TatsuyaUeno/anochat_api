package com.anochat_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
    public List<MessageResponseDto> getMessageList(Integer chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageDao.getMessage(chatid); // nullになっている！
        } catch (Exception e) {
            log.error(String.valueOf(chatid), e);
        }

        return messages.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
        // return messageMapper.getMessageList(chatid);
    }

    private MessageResponseDto convertToResponseDto(MessageDto messageDto) {
        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setChatListId(messageDto.getChatid());
        responseDto.setContent(messageDto.getMessage());
        responseDto.setDate(messageDto.getDate());
        return responseDto;
    }
}