package com.qztc.appdemo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;
/**
 * 专业
 * @author xiayj
 * @since
 */
@Data
public class Profession {
    @TableId(value = "profession_id",type = IdType.AUTO)
    private Integer professionId;

    private String professionName;

    private String apartment;

    private String school;

    private Date createTime;

}