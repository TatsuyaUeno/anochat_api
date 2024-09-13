package com.anochat_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.anochat_api.dto.MessageDto;

@Mapper
public interface MessageMapper {

    List<MessageDto> getMessagesByChatId(@Param("chatid") Integer chatid);
}
