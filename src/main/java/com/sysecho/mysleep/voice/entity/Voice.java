package com.sysecho.mysleep.voice.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Voice {
    private Integer id;

    private String objectId;

    private String name;

    private String contentType;

    private BigDecimal size;

    private String dataId;

    private String imageUrl;

    private Date createdDate;

    private Integer createdBy;

    private Date updateDate;

    private Integer updateBy;
    
    private Integer sort;
    
    private String remark;
}