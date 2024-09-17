// package com.anochat_api.dao;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;

// import com.anochat_api.dto.ChatDto;
// import com.anochat_api.mapper.ChatListMapper;

// @Repository
// public class ChatUpdateResDao {

//     /** チャットMapper */
//     @Autowired
//     private ChatListMapper chatListMapper;

//     @Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
//     public List<ChatDto> getChatList() {
        
//         return chatListMapper.getChatList();
//     }
// }