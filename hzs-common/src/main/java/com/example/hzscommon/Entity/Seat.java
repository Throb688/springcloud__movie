package com.example.hzscommon.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("seat")
public class Seat {
    private String id;
    private String row1;
    private String col;
    private String grow;
    private String gcol;
    private String type;
    private String flag;
}

