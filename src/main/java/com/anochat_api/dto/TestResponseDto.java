package com.anochat_api.dto;

/**
 * 【サンプルクラス】
 * ・Dtoと呼ばれる（Entityと呼ばれることもある）
 * ・責務：データを管理する
 * ・行うこと
 * 　・入れたいデータを定義
 * 　・setter/getterを定義
 * ・イメージ：JSON形式・・・{name: 値, age: 値}
 */
public class TestResponseDto {

    private String name;

    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}