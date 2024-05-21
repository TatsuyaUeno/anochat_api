package com.anochat_api.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    void registChat(String message);
}
