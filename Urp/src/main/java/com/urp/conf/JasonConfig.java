package com.urp.conf;

/**
 * Created by a on 2018/5/22.
 */

import com.urp.Tool.JsonResult;
import org.springframework.context.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 该类的作用是将前端以及后端的json字符串转换
 */
@Configuration
public class JasonConfig {

    @Bean(name="objectMapper")
    public ObjectMapper  getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SimpleModule simpleModule = new SimpleModule("SimpleModule",
                Version.unknownVersion());
        simpleModule.addSerializer(JsonResult.class, new CustomJsonResultSerializer());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

    /**
     * layui 前端要求后台返回的数据格式
     * @author xiandafu
     *
     */
    public static class CustomJsonResultSerializer extends JsonSerializer<JsonResult> {

        public CustomJsonResultSerializer() {
        }


        @Override
        public void serialize(JsonResult value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            if(value.getCode().equals("200")) {
                gen.writeObjectField("code", 0);
            }else {
                gen.writeObjectField("code", Integer.parseInt(value.getCode()));
            }
            gen.writeStringField("msg", value.getMsg());
            Object data = value.getData();
            //针对于页面请求的参数是否有一定的相关的分页
          /*  if(data instanceof PageQuery ) {
                PageQuery query = (PageQuery)(data);
                gen.writeObjectField("count", query.getTotalRow());
                gen.writeObjectField("data", query.getList());
            }else {

                gen.writeObjectField("data", data);
            }*/
            gen.writeEndObject();
        }

    }
}
