package com.more.demo.pojo;

import lombok.Data;

@Data
public class CustomResult {
    String msg;

    public CustomResult(String msg) {
        this.msg = msg;
    }

}
