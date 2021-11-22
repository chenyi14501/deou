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
import com.example.demo.model.StockInOutOrder;

@Erupt(name = "生产单")
@Table(name = "ProductionOrder")
@Entity
public class ProductionOrder extends BaseModel {

        @EruptField(
                views = @View(
                        title = "生产单号"
                ),
                edit = @Edit(
                        title = "生产单号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

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
        private Material material;

        @EruptField(
                views = @View(
                        title = "计划生产数量"
                ),
                edit = @Edit(
                        title = "计划生产数量",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer planQuantity;

        @EruptField(
                views = @View(
                        title = "下单时间"
                ),
                edit = @Edit(
                        title = "下单时间",
                        type = EditType.DATE, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date createDatetime;

        @EruptField(
                views = @View(
                        title = "物料出入记录"
                ),
                edit = @Edit(
                        title = "物料出入记录",
                        type = EditType.TAB_TABLE_ADD, notNull = true
                )
        )
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @OrderBy
        @JoinColumn(name = "production_order_id") 
        private Set<StockInOutOrder> stockOrders;

        @EruptField(
                views = @View(
                        title = "下单人员", column = "name"
                ),
                edit = @Edit(
                        title = "下单人员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser createUser;

        @EruptField(
                views = @View(
                        title = "生产对接员", column = "name"
                ),
                edit = @Edit(
                        title = "生产对接员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser worker;

        @EruptField(
                views = @View(
                        title = "实际完成数量"
                ),
                edit = @Edit(
                        title = "实际完成数量",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer finishQuantity;

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

}