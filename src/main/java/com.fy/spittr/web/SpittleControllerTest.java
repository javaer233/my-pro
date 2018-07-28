package com.fy.spittr.web;

import com.fy.spittr.Spittle;
import com.fy.spittr.data.SpittleRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

//import org.mockito.Mockito;
/**
 * Created by yk on 2018/07/25
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB_INF/views/spittles.jsp")).build();

        //对/spittles发起请求
        //mockMvc.perform(get("/spittles"))
        //        .andExpect(view().name("spittles"))
        //        .andExpect(model().attributeExists("spittleList"))
        //        .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void showRegistrationTest() throws Exception {
        SpittleController spittleController = new SpittleController();
        MockMvc build = standaloneSetup(spittleController).build();

        build.perform(get("/spittles/register"))
                .andExpect(view().name("registerForm"));
    }

}
