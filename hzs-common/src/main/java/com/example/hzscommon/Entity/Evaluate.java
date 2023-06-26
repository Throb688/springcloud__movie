package com.example.hzscommon.Entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("evaluate")
public class Evaluate {
    private Long evaluateid;
    private int movieid;
    private String username;
    private String evaluatetext;
    private String evaluatetime;
}
