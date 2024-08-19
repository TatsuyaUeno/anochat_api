package com.anochat_api.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewChatMapper {

    int countChats();
    
    String createNewChat(String chatName, LocalDateTime createDate);

}
