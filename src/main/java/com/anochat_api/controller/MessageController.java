package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.dto.MessageRequestDto;
import com.anochat_api.dto.MessageResponseDto;
import com.anochat_api.service.MessageService;
import com.anochat_api.util.SaveChatId;

/**
 * メッセージ一覧取得
 */
@RestController
@RequestMapping("/api/chatMessage")
public class MessageController {
    
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);  

    @Autowired
    private MessageService messageService;
    @Autowired
    private SaveChatId saveChatId;

    @PostMapping("/getChatMessage")
    public List<MessageResponseDto> getMessageList(@RequestBody MessageRequestDto messageResponseDto) {  
        List<MessageResponseDto> messages = new ArrayList<MessageResponseDto>();  

        try {  
            Integer chatid = messageResponseDto.getChatid();
            saveChatId.setChatId(chatid);
            messages = messageService.getMessageList(chatid);
        } catch (Exception e) {  
            log.error("予期せぬエラーが発生しました。ChatId: " + messageResponseDto.getChatid(), e);  
        }

        return messages;
    }
}
