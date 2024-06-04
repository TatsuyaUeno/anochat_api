package com.anochat_api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.anochat_api.dto.TestResponseDto;
import java.util.List;

@Mapper
public interface ChatMapper {
    /* サンプル用 */
    List<TestResponseDto> getUserInfo();

    void registChat(String message);
}
