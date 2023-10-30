package com.fan.wanwindow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "good_index_info_rel")
@Data
public class GoodIndexInfoRel {
    @Id
    @Column(name = "item_index")
    private String itemIndex;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "appearance_type_name")
    private String appearanceTypeName;

    @Column(name = "info")
    private String info;

    @Column(name = "consignment_id")
    private String consignmentID;

}
