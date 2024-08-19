package com.anochat_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anochat_api.dto.MessageDto;

@Mapper
public interface MessageMapper {

    // List<MessageDto> getMessageList(int chatid);

    List<MessageDto> getMessagesByChatId(int chatid);

    // List<MessageDto> getMessagesByChatId(int chatid);
}
