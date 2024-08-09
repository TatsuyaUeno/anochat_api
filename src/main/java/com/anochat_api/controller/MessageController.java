package com.anochat_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.service.MessageService;


/**
 * メッセージ一覧取得
 */
@Controller
@RequestMapping("/api/chat/msglist")
public class MessageController {
    
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private MessageService messageService;

    @GetMapping("/api/chat/msglist/{chatid}/")
    public List<MessageDto> getMessageList(@PathVariable String chatid) {
        List<MessageDto> messages = new ArrayList<MessageDto>();

        try {
            messages = messageService.getMessageList(chatid);
        } catch (Exception e) {
            log.error("予期せぬエラーが発生しました。");
        }

        return messages;
    }
}
