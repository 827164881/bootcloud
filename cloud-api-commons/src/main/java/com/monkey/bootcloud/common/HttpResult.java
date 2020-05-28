package com.monkey.bootcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 通用返回结果类
 * @author: monkey.G
 * @create: 2020-05-13 10:28
 **/
@Data
@AllArgsConstructor
public class HttpResult<T> {

  private Integer code;
  private String msg;
  private T data;

  public HttpResult(){
    this(200,"成功",null);
  }

  public HttpResult(Integer code,String msg){
    this(code,msg,null);
  }

  public HttpResult(T data){
    this(200,"成功",data);
  }
}
