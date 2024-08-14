package com.anochat_api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.anochat_api.dto.MessageDto;
import com.anochat_api.mapper.MessageMapper;

@Repository
public class MessageDao {

    @Autowired
    private MessageMapper messageMapper;

    // @Transactional 更新・削除APIでは必要らしい
    // public List<MessageDto> findMessageList(int chatid) {
    //     return messageMapper.getMessageList(chatid);
    // }

    // @Transactional
    public List<MessageDto> getMessage(int chatid) {

        // DBなし動作確認用
        // List<MessageDto> result = new ArrayList<>();
        // MessageDto data1 = new MessageDto(101, 1, "message");
        // MessageDto data2 = new MessageDto(101, 2, "testmsg");
        // result.add(data1);
        // result.add(data2);
        // return result;

        return messageMapper.getMessagesByChatId(chatid);
    }
}
