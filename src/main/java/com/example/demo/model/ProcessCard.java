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

@Erupt(name = "批次流程卡")
@Table(name = "ProcessCard")
@Entity
public class ProcessCard extends BaseModel {

        @EruptField(
                views = @View(
                        title = "时间"
                ),
                edit = @Edit(
                        title = "时间",
                        type = EditType.DATE, search = @Search, notNull = true,
                        dateType = @DateType(type = DateType.Type.DATE_TIME)
                )
        )
        private Date datetime;

        @EruptField(
                views = @View(
                        title = "生产单", column = "name"
                ),
                edit = @Edit(
                        title = "生产单",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private ProductionOrder ProductionOrder;

        @EruptField(
                views = @View(
                        title = "工序", column = "name"
                ),
                edit = @Edit(
                        title = "工序",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private MaterialManufactureStep ManufactureStep;

        @EruptField(
                views = @View(
                        title = "设备", column = "name"
                ),
                edit = @Edit(
                        title = "设备",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Equipment Equipment;

        @EruptField(
                views = @View(
                        title = "操作"
                ),
                edit = @Edit(
                        title = "操作",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String OpType;

        @EruptField(
                views = @View(
                        title = "物料", column = "name"
                ),
                edit = @Edit(
                        title = "物料",
                        type = EditType.REFERENCE_TABLE, search = @Search,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Material Material;

        @EruptField(
                views = @View(
                        title = "批次号", column = "name"
                ),
                edit = @Edit(
                        title = "批次号",
                        type = EditType.REFERENCE_TABLE, search = @Search,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private LotNumber LotNumber;

        @EruptField(
                views = @View(
                        title = "数量", show = false
                ),
                edit = @Edit(
                        title = "数量",
                        type = EditType.NUMBER, show = false, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer quantity;

        @EruptField(
                views = @View(
                        title = "库位", column = "name"
                ),
                edit = @Edit(
                        title = "库位",
                        type = EditType.REFERENCE_TABLE, search = @Search,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private StockLocation StockLocation;

        @EruptField(
                views = @View(
                        title = "备注"
                ),
                edit = @Edit(
                        title = "备注",
                        type = EditType.TEXTAREA
                )
        )
        private @Lob String Note;

}