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

@Erupt(name = "需求单")
@Table(name = "MaterialRequirement")
@Entity
public class MaterialRequirement extends BaseModel {

        @EruptField(
                views = @View(
                        title = "需求(截止)日期"
                ),
                edit = @Edit(
                        title = "需求(截止)日期",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType
                )
        )
        private Date endDate;

        @EruptField(
                views = @View(
                        title = "类型"
                ),
                edit = @Edit(
                        title = "类型",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String type;

        @EruptField(
                views = @View(
                        title = "物料名称" , column = "name"
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
                        title = "开始日期"
                ),
                edit = @Edit(
                        title = "开始日期",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType
                )
        )
        private Date startDate;

        @EruptField(
                views = @View(
                        title = "需求数量"
                ),
                edit = @Edit(
                        title = "需求数量",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer requirementQuantity;

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