package com.mysz.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: provider
 * @Data: 2020/12/12 16:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider implements Serializable {
    private Long id;
    private String names;
    private Integer ages;
}
