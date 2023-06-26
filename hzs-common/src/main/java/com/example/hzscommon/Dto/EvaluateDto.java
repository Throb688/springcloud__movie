package com.example.hzscommon.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateDto {
    private String evaluatetext;
    private Integer userid;
    private Integer movieId;
}
