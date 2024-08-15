package com.anochat_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anochat_api.service.ChatService;

/*
 * チャット情報
 */

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    // 扱うデータを定義
    @Autowired
    private ChatService chatService;

    // @PostMapping("/register")
    // public 

    // @PutMapping("/update")


    // @DeleteMapping("/delete")

}
