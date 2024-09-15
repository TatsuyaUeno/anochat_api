package com.anochat_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anochat_api.dto.ChatDto;

@Mapper
public interface ChatListMapper {

	List<ChatDto> getChatList();
}
