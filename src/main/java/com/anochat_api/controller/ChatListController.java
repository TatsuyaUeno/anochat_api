package com.anochat_api.controller;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.dto.ChatDto;
import com.anochat_api.dto.ChatListResponseDto;
import com.anochat_api.dto.ChatUpdateReqDto;
import com.anochat_api.service.ChatService;

/*
 * チャット情報
 */

@RestController
@RequestMapping("/api/chatList")
public class ChatListController {
    
    private static final Logger log = LoggerFactory.getLogger(ChatListController.class);

    // 扱うデータを定義
    @Autowired
    private ChatService chatService;

    @PostMapping("/getChatList")
    public List<ChatListResponseDto> getChatList() {
        List<ChatListResponseDto> chatList = new ArrayList<ChatListResponseDto>();

        try {
            chatList = chatService.getChatList();
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました。", e);  
        }

        return chatList;
    }

    // チャット一覧登録更新API
    @PostMapping("/updateChatList")
    public void updateChatList(@RequestBody ChatDto chatRequestDto) {
    // public List<ChatListResponseDto> updateChatList(@RequestBody ChatDto chatRequestDto) {
        // List<ChatListResponseDto> chatList = new ArrayList<ChatListResponseDto>();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate chatDate = LocalDate.parse(chatRequestDto.getChatDate(), formatter);
            Integer chatId = chatRequestDto.getChatId();
            String chatName = chatRequestDto.getChatName();
            LocalDateTime chatDateTime = chatDate.atStartOfDay();
            chatService.updateChatList(chatId, chatName, chatDateTime);
            // chatList = chatService.updateChatList(chatId, chatName, chatDateTime);
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました。", e);  
        }

        // return chatList;
    }
}
