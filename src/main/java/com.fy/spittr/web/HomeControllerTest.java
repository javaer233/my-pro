package com.fy.spittr.web;

//import org.junit.Test;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by yk on 2018/07/24
 * mock测试
 */
public class HomeControllerTest {

    /**
     * 相比于传统test，模拟了get请求并且设置期望的返回视图名
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception {

        HomeController homeController = new HomeController();
        MockMvc build = standaloneSetup(homeController).build();
        build.perform(get("/")).andExpect(view().name("home"));
    }
}
