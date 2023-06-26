package com.example.hzscommon.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("session")
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    private Integer sessionid;
    private Integer movieid;
    private String site;
    private String time;
    private String status;

}