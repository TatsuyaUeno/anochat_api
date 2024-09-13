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

    @Autowired
    private MessageDao messageDao;

    @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
    public List<MessageResponseDto> getMessageList(Integer chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageDao.getMessage(chatid);
        } catch (Exception e) {
            log.error(String.valueOf(chatid), e);
        }

        return messages.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    private MessageResponseDto convertToResponseDto(MessageDto messageDto) {
        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setMessage(messageDto.getMessage());
        responseDto.setSort(messageDto.getDate());
        return responseDto;
    }
}