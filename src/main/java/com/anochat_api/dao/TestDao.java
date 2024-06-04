package com.anochat_api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.anochat_api.dto.TestResponseDto;
import com.anochat_api.mapper.ChatMapper;

/**
 * 【サンプルクラス】
 * ・リポジトリーと呼ばれる
 * ・責務：DB操作を行う
 * ・行うこと
 * 　・DBにクエリをたたく
 * 　・トランザクションを張る
 */
@Repository
public class TestDao {
    
    @Autowired
    private ChatMapper chatMapper;

    @Transactional
    public List<TestResponseDto> getUserInfo() {
        return chatMapper.getUserInfo();
    }
}
