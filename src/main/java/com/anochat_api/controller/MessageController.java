package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.service.MessageService;


/**
 * メッセージ一覧取得
 */
@RestController
@RequestMapping("/api/chat/msglist")
public class MessageController {
    
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @GetMapping("/{chatid}")
    public List<MessageDto> getMessageList(@PathVariable int chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageService.getMessageList(chatid);
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました。ChatId: " + chatid, e);
        }

        return messages;
    }
}
