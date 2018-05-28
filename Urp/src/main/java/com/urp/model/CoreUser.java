package com.urp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urp.Tool.ValidateConfig;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * Created by a on 2018/5/22.
 */
public class CoreUser extends  BaseEntity {
    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID
    protected Long id;
    // 删除标识
    @JsonIgnore
    protected Integer delFlag= 0;
    // 创建时间

    protected Date createTime;


    // 登录名，编号
    @NotNull(message = "用户编号不能为空", groups = ValidateConfig.ADD.class)
    @Null(message = "用户编号不能为空", groups = ValidateConfig.UPDATE.class)
    private String code;

    // 用户姓名
    @NotNull(message = "用户名不能为空")
    private String name;

    // 组织机构id

    private Long orgId;

    // 密码
    @JsonIgnore
    private String password;

    private Date updateTime;

    /*用户的个人资料附件，保存到Core_File 表里*/
    private String attachmentId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
