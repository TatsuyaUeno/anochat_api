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

import com.anochat_api.dao.ChatListDao;
import com.anochat_api.dto.ChatDto;
import com.anochat_api.dto.ChatListResponseDto;
// import com.anochat_api.dto.ChatUpdateReqDto;

@Service
public class ChatService {
    
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private ChatListDao chatListDao;

    @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
    public List<ChatListResponseDto> getChatList() {
        List<ChatDto> chatList = new ArrayList<ChatDto>();

        try {
            chatList = chatListDao.getChatList();
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

        return chatList.stream()
                .map(this::convertToChatListResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
    public void updateChatList(Integer chatId, String chatName, LocalDateTime chatDate) {
    // public List<ChatListResponseDto> updateChatList(Integer chatId, String chatName, LocalDateTime chatDate) {
        // List<ChatDto> chatList = new ArrayList<ChatDto>();

        try {
            chatListDao.updateChatList(chatId, chatName, chatDate);
            // chatList = chatListDao.getChatList();
        } catch (Exception e) {
            log.error(String.valueOf(e));
            throw e;
        }

        // return chatList.stream()
        //         .map(this::convertToChatListResponseDto)
        //         .collect(Collectors.toList());
    }
    
    private ChatListResponseDto convertToChatListResponseDto(ChatDto chatDto) {
        ChatListResponseDto responseDto = new ChatListResponseDto();
        responseDto.setChatListId(chatDto.getChatId());
        responseDto.setContent(chatDto.getChatName());
        responseDto.setDate(chatDto.getChatDate());
        return responseDto;
    }
}
