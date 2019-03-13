package com.jqmkj.roadtrip.base;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName ：BaseEntity
 * @Description: TODO
 * @Author ：wangyao
 * @Date ：2019/1/4 上午11:39
 */
@Data
public class BaseEntity {
    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;
}
