package com.anochat_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.dto.MessageResponseDto;

@Mapper
public interface MessageMapper {

    // List<MessageDto> getMessageList(int chatid);

    List<MessageDto> getMessagesByChatId(@Param("chatid") Integer chatid);

    // List<MessageDto> getMessagesByChatId(int chatid);
}
