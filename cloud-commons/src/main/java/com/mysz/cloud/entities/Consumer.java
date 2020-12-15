package com.mysz.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Consumer
 * @Data: 2020/12/12 16:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer implements Serializable {
        private Long id;
        private String name;
        private Integer age;
}
