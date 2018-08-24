package com.fy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bzl on 2016-12-14 上午 9:22
 */
@Repository
public interface BaseDataMapper {
     /**
      * 获取单条记录详情
      * @return
      */
     Map<String,Object> getInfo(@Param("sql") String sql);

     /**
      * 获取菜单对应列表
      * @return
      */
     Page<Map<String,Object>> getList(@Param("sql") String sql);

     /**
      * 获取Olap数据
      * @param sql
      * @return
      */
     List<LinkedHashMap<String,Object>> getOlapData(@Param("sql") String sql);

     void execute(@Param("sql") String sql);
}
