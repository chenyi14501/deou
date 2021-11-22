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

@Erupt(name = "物料需求流水")
@Table(name = "MaterialRequirementLine")
@Entity
public class MaterialRequirementLine extends BaseModel {

        @EruptField(
                views = @View(
                        title = "日期"
                ),
                edit = @Edit(
                        title = "日期",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType
                )
        )
        private Date Date;

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
        private Material Material;

        @EruptField(
                views = @View(
                        title = "出库需求数"
                ),
                edit = @Edit(
                        title = "出库需求数",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer RequirementOutQuantity;

        @EruptField(
                views = @View(
                        title = "入库需求数"
                ),
                edit = @Edit(
                        title = "入库需求数",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer RequirementInQuantity;

        @EruptField(
                views = @View(
                        title = "出库排产数"
                ),
                edit = @Edit(
                        title = "出库排产数",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer PlanOutQuantity;

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
                        title = "排产入库数量"
                ),
                edit = @Edit(
                        title = "排产入库数量",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer PlanInQuantity;

        @EruptField(
                views = @View(
                        title = "预计剩余库存数"
                ),
                edit = @Edit(
                        title = "预计剩余库存数",
                        type = EditType.NUMBER,
                        numberType = @NumberType
                )
        )
        private Integer PlanStockQuantity;

        @EruptField(
                views = @View(
                        title = "需求列表"
                ),
                edit = @Edit(
                        title = "需求列表",
                        type = EditType.TAB_TABLE_ADD, notNull = true
                )
        )
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @OrderBy
        @JoinColumn(name = "material_requirement_line_id")
        private Set<MaterialRequirement> MaterialRequirements;

}