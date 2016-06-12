package com.tqmall.combo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Cart {

    private Integer recId;

    private Integer activityId;

    private String activityName;

    private Integer activityGroupId;

    private Byte buyNow;

    private String activityGroupName;

    private Short delType;

    private Integer userId;

    private String sessionId;

    private Integer goodsId;

    private Integer supplierId;

    private String goodsSn;

    private String newGoodsSn;

    private String goodsName;

    private Integer goodsNumber;

    private Boolean isReal;

    private Integer parentId;

    private Boolean recType;

    private Short isGift;

    private Boolean isShipping;

    private String goodsAttrId;

    private Integer warehouseId;

    private Integer cityId;

    private String goodsAttr;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte userType;

    private Integer sellerId;

    private String sellerNick;

    private Integer accountId;//帐号id
}