package com.urp.Tool;

import org.beetl.sql.core.annotatoin.EnumMapping;

/**
 * Created by a on 2018/5/22.
 */
@EnumMapping("value")
public enum DelFlagEnum {
    NORMAL(0), DELETED(1);

    private int value;

    DelFlagEnum(int value) {
        this.value = value;
    }

    public static DelFlagEnum getEnum(int value) {
        for (DelFlagEnum type : DelFlagEnum.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}