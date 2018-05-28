package com.urp.dao;

import com.urp.model.CoreUser;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * Created by a on 2018/5/22.
 */
@SqlResource("coreUser")
public interface CoreUserDao extends BaseMapper<CoreUser> {
    /**
     * 根据角色查询跟角色相关的信息
     * @param roleCode
     * @return
     */
    List<CoreUser> getUserByRole(String roleCode);

}
