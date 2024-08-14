package com.anochat_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// import org.mybatis.spring.annotation.MapperScan;

import com.anochat_api.dto.MessageDto;

// @MapperScan("com.anochat_api.mapper")
@Mapper
public interface MessageMapper {

    // List<MessageDto> getMessageList(int chatid);

    List<MessageDto> getMessagesByChatId(int chatid);

    // List<MessageDto> getMessagesByChatId(int chatid);
}
