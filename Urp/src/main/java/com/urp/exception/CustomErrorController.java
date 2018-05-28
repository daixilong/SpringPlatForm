package com.urp.exception;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urp.Tool.JsonResult;
import com.urp.conf.JsonCom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 2018/5/22.
 */
public class CustomErrorController extends SimpleMappingExceptionResolver {

    //@Autowired
   // private  ObjectMapper objectMapper;

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Throwable cause =getCause(request);
        if(isJsonRequest(request)){
            writeJson(response,JsonResult.failMessage(getErrorMessage(cause)));
            return null;
        }else{
            ModelAndView modelAndView=new ModelAndView("/error.html");
            return modelAndView;
        }

    }

    protected List<FieldError> getFieldError(Throwable cause){
        if(cause instanceof FormFieldException){
            FormFieldException  fe = (FormFieldException)cause;
            return fe.getErrors();
        }
        return null;


    }

    /**
     * 判断当前的请求是否是ajax请求
     */
    protected boolean isJsonRequest(HttpServletRequest request){
        String requestUri =  (String)request.getAttribute("javax.servlet.error.request_uri");
        if(requestUri!=null&&requestUri.endsWith(".json")){
            return true;
        }else{
            return (request.getHeader("Accept").contains("application/json") || (request.getHeader("X-Requested-With") != null
                    && request.getHeader("X-Requested-With").contains("XMLHttpRequest")));
        }
    }

    protected void writeJson(HttpServletResponse response,JsonResult error){
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            response.getWriter().write(objectMapper.writeValueAsString(error));
        } catch (IOException e) {
            // ignore
        }
    }
    protected String getErrorMessage(Throwable ex) {
        if(ex instanceof PlatformException){
            return ex.getMessage();
        }else{
            return "服务器错误,请联系管理员";
        }

    }

    protected Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException) error).getCause();
            }
        }
        return error;
    }


}
