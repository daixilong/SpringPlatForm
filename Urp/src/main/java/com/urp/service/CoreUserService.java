package com.urp.service;

import com.urp.dao.CoreUserDao;
import com.urp.model.CoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by a on 2018/5/22.
 */
@Service
@Transactional
public class CoreUserService extends BaseService<CoreUser>{
    @Autowired
    private CoreUserDao coreUserDao;

    public List<CoreUser> getAllUser(){
        return coreUserDao.all();
    }
}
