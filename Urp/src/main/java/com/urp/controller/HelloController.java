package com.urp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urp.Tool.JsonResult;
import com.urp.Tool.ValidateConfig;
import com.urp.model.CoreUser;
import com.urp.valid.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by a on 2018/5/17.
 */
@RestController
public class HelloController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/hello")
    public JsonResult hello(){
        return JsonResult.successMessage("执行成功");
    }

    @PostMapping("/add")
    public JsonResult add(CoreUser coreUser){
        ValidateUtils.validateEntity(coreUser,ValidateConfig.ADD.class);
        return  JsonResult.successMessage("添加成功");
    }
}
