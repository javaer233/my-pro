package com.fy.spittr.web;

import com.fy.spittr.Spittle;
import com.fy.spittr.data.SpittleRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yk on 2018/07/25
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles(){
        //SpittleRepository mockRepository = mock(SpittleRepository.class);
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

}
