package com.anochat_api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anochat_api.dao.ChatDao;
import com.anochat_api.dao.NewChatDao;
import com.anochat_api.dto.ChatDto;
import com.anochat_api.dto.ChatListResponseDto;

@Service
public class ChatService {
    
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private ChatDao chatDao;

    @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
    public List<ChatListResponseDto> createNewChat(String chatName, LocalDateTime createDate) {
        List<ChatDto> chatList = new ArrayList<ChatDto>();
        // String res = new String();

        try {
            // chatList = chatDao.getChatList(chatName, createDate);
        } catch (Exception e) {
            log.error(chatName, e);
        }

        return chatList.stream()
                .map(this::convertToChatListResponseDto)
                .collect(Collectors.toList());

    }
    
    private ChatListResponseDto convertToChatListResponseDto(ChatDto chatDto) {
        ChatListResponseDto responseDto = new ChatListResponseDto();
        responseDto.setChatListId(chatDto.getChatId());
        responseDto.setContent(chatDto.getChatName());
        responseDto.setDate(chatDto.getChatDate());
        return responseDto;
    }
}
