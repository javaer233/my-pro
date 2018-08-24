package com.fy.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


//@Repository
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
     List<Map<String,Object>> getList(@Param("sql") String sql);

     /**
      * 获取Olap数据
      * @param sql
      * @return
      */
     List<LinkedHashMap<String,Object>> getOlapData(@Param("sql") String sql);

     /**
      * @Title: execute
      * @Description: 执行sql
      * @author kai
      * @date 2018/6/6 17:19
      * @param [sql]
      * @return void
      */
     void execute(@Param("sql") String sql);

     /**
      * @Title: getSet
      * @Description: 获取set
      * @author kai
      * @date 2018/6/29 11:26
      * @param [sql]
      * @return java.util.Set<java.lang.String>
      */
     Set<String> getSet(@Param("sql") String sql);
}
