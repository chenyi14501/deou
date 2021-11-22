/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */
package  com.example.demo.model;

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

@Erupt(name = "出入库单")
@Table(name = "StockInOutOrder")
@Entity
public class StockInOutOrder extends BaseModel {

        @EruptField(
                views = @View(
                        title = "单号", column = "name"
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
                        title = "发起人", column = "name"
                ),
                edit = @Edit(
                        title = "发起人",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser createUser;

        @EruptField(
                views = @View(
                        title = "起始仓库", column = "name"
                ),
                edit = @Edit(
                        title = "起始仓库",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private WareHouse srcWareHouse;

        @EruptField(
                views = @View(
                        title = "目的仓库", column = "name"
                ),
                edit = @Edit(
                        title = "目的仓库",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private WareHouse dstWareHouse;

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
        private Integer finalQuantity;

        @EruptField(
                views = @View(
                        title = "仓库员", column = "name"
                ),
                edit = @Edit(
                        title = "仓库员",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EruptUser wareHouseWorker;

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
                        title = "批次明细"
                ),
                edit = @Edit(
                        title = "批次明细",
                        type = EditType.TAB_TABLE_ADD, notNull = true
                )
        )
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @OrderBy
        @JoinColumn(name = "stock_in_out_order_id")
        private Set<StockMoveLine> StockMoveLine;

}