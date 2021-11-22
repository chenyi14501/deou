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

import com.example.demo.model.Material;
import xyz.erupt.upms.model.EruptUser;

@Erupt(name = "采购单")
@Table(name = "PurchaseOrder")
@Entity
public class PurchaseOrder extends BaseModel {

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
                        title = "供货商"
                ),
                edit = @Edit(
                        title = "供货商",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String supplier;

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
                        title = "单位价格"
                ),
                edit = @Edit(
                        title = "单位价格",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer price;

        @EruptField(
                views = @View(
                        title = "总价"
                ),
                edit = @Edit(
                        title = "总价",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer totalPrice;

        @EruptField(
                views = @View(
                        title = "订单状态"
                ),
                edit = @Edit(
                        title = "订单状态",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String status;

        @EruptField(
                views = @View(
                        title = "采购员", column = "name"
                ),
                edit = @Edit(
                        title = "采购员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser worker;

        @EruptField(
                views = @View(
                        title = "关闭时间"
                ),
                edit = @Edit(
                        title = "关闭时间",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date closeDatetime;

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
        private Date createDatetime;

        @EruptField(
                views = @View(
                        title = "预计到货时间"
                ),
                edit = @Edit(
                        title = "预计到货时间",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType
                )
        )
        private Date deadlineDate;

}