package com.urp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.beetl.sql.core.TailBean;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by a on 2018/5/22.
 */
public class BaseEntity extends TailBean implements Serializable {
    protected final static String ORACLE_CORE_SEQ_NAME="core_seq";
    protected final static String ORACLE_AUDIT_SEQ_NAME="audit_seq";
    protected final static String ORACLE_FILE_SEQ_NAME="core_seq";

    /**
     * 设置json字符串转换为一个map
     * @return
     */
    @JsonAnyGetter
    public Map<String, Object> getTails(){
        return super.getTails();
    }
}
