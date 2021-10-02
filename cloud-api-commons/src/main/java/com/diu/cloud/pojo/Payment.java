package com.diu.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DIU
 * @date 2021/9/29 9:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    
    private long id;
    private String serial;

}
