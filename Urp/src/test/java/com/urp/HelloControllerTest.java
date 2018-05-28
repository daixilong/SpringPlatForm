package com.urp;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.urp.conf.JasonConfig;
import com.urp.dao.CoreUserDao;
import com.urp.model.CoreUser;
import com.urp.service.CoreUserService;
import org.apache.logging.log4j.core.config.json.JsonConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by a on 2018/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext.xml","classpath*:spring-mvc.xml"})
public class HelloControllerTest {
    private static Log log= LogFactory.getLog(HelloControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private  CoreUserDao coreUserDao;

    @Autowired
    private CoreUserService coreUserService;

    @Before
    public  void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public  void test() throws Exception {
        MvcResult mvcResult= mockMvc.perform(get("/hello")).andReturn();
        log.info("请求的结果信息："+mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void test1(){
       List<CoreUser> users= coreUserDao.all();
        for (CoreUser user:users
             ) {
           log.info("用户的名称是："+user.getName());
        }
    }

    @Test
    public void test2(){
        log.info("查询的结果是:"+coreUserService.getAllUser().size());
    }


    @Test
    public void test3() throws  Exception{
        String str=mockMvc.perform( post("/Add").contentType(MediaType.APPLICATION_JSON).content("")).andReturn().getResponse().getContentAsString();
        log.info(str);
    }

    @Test
    public void test4(){
        ApplicationContext context1 =new AnnotationConfigApplicationContext(JasonConfig.class);
        log.info("================start=======================");
        log.info(context1.getBean("objectMapper").toString());
        log.info("================end=======================");
    }
}
