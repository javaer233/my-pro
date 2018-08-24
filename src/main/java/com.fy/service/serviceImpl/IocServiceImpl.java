package com.fy.service.serviceImpl;/**
 * Created by yk on 2018/08/23
 */

import com.fy.mapper.BaseDataMapper;
import com.fy.service.IocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author kai
 * @Description
 * @Create 2018-08-23 16:43
 **/
@Service("iocService")
public class IocServiceImpl implements IocService {
    @Autowired
    private BaseDataMapper baseDataMapper;
    @Override
    public void sayHello() {
        baseDataMapper.execute("select 1 as name");
        System.out.println("hello");
    }
}
