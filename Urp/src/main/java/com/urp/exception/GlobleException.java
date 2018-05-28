package com.urp.exception;

import com.urp.Tool.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by a on 2018/5/18.
 */

/**
 * 定义一个统一的异常处理机制
 * 针对于不同的请求处理
 */
@ControllerAdvice
public class GlobleException {

    @ExceptionHandler(PlatformException.class)
    @ResponseBody
    public JsonResult exception(Exception e){
        PlatformException ex=(PlatformException)e;
        return JsonResult.failMessage(ex.getMessage());
    }
}
