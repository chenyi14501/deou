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
@Erupt(name = "销售单")
@Table(name = "SaleOrder")
@Entity
public class SaleOrder extends BaseModel {

        @EruptField(
                views = @View(
                        title = "订单号"
                ),
                edit = @Edit(
                        title = "订单号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @EruptField(
                views = @View(
                        title = "客户"
                ),
                edit = @Edit(
                        title = "客户",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String customerName;

        @EruptField(
                views = @View(
                        title = "物料", column = "name"
                ),
                edit = @Edit(
                        title = "物料",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Material material;

        @EruptField(
                views = @View(
                        title = "下单时间"
                ),
                edit = @Edit(
                        title = "下单时间",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date createDate;

        @EruptField(
                views = @View(
                        title = "数量"
                ),
                edit = @Edit(
                        title = "数量",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer quantity;

        @EruptField(
                views = @View(
                        title = "交货时间"
                ),
                edit = @Edit(
                        title = "交货时间",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date deadlineDate;

        @EruptField(
                views = @View(
                        title = "销售员", column = "name"
                ),
                edit = @Edit(
                        title = "销售员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser saler;

        @EruptField(
                views = @View(
                        title = "状态"
                ),
                edit = @Edit(
                        title = "状态",
                        type = EditType.CHOICE, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String status;

        @EruptField(
                views = @View(
                        title = "已交货数量"
                ),
                edit = @Edit(
                        title = "已交货数量",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer finishQuantity;

}