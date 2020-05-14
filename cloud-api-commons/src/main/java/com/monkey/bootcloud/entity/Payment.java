package com.monkey.bootcloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-05-13 00:00:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -11788210391746027L;
    /**
    * 收复失地
    */    
    private Long id;
    /**
    * 斯蒂芬森
    */    
    private String serial;
    /**
    * 问问
    */    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}