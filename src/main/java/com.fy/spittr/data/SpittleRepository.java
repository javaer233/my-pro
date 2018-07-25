package com.fy.spittr.data;

import com.fy.spittr.Spittle;

import java.util.List;

/**
 * Created by yk on 2018/07/24
 */
public interface SpittleRepository {
    /**
     * 获取Spittle列表
     * @param max   返回数据中的id最大值
     * @param count 获取的返回数据个数
     * @return
     */
    List<Spittle> findSpittles(long max, int count);
}
