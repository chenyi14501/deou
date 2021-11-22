/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */
package com.example.demo.model;
import javax.persistence.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

import xyz.erupt.upms.model.EruptUser;
import com.example.demo.model.LotQuanltyLine;

@Erupt(name = "发货单")
@Table(name = "ShipOrder")
@Entity
public class ShipOrder extends BaseModel {

        @EruptField(
                views = @View(
                        title = "单号"
                ),
                edit = @Edit(
                        title = "单号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @EruptField(
                views = @View(
                        title = "销售单号", column = "name"
                ),
                edit = @Edit(
                        title = "销售单号",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private SaleOrder saleOrder;

        @EruptField(
                views = @View(
                        title = "发货员", column = "name"
                ),
                edit = @Edit(
                        title = "发货员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser worker;

        @EruptField(
                views = @View(
                        title = "物料名称", column = "name"
                ),
                edit = @Edit(
                        title = "物料名称",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Material Material;

        @EruptField(
                views = @View(
                        title = "批次列表"
                ),
                edit = @Edit(
                        title = "批次列表",
                        type = EditType.TAB_TABLE_REFER, notNull = true
                )
        )
        @ManyToMany 
        @JoinTable(name = "ship_order_lot_quantity",
            joinColumns = @JoinColumn(name = "ship_order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lot_quantity_id", referencedColumnName = "id")) 
        private Set<LotQuanltyLine> LotQuanltyLine;

        @EruptField(
                views = @View(
                        title = "状态"
                ),
                edit = @Edit(
                        title = "状态",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String status;

        @EruptField(
                views = @View(
                        title = "计划发货日期"
                ),
                edit = @Edit(
                        title = "计划发货日期",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType
                )
        )
        private Date planDate;

        @EruptField(
                views = @View(
                        title = "完成日期"
                ),
                edit = @Edit(
                        title = "完成日期",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date finishDatetime;

}