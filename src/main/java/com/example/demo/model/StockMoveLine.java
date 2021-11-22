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

import  com.example.demo.model.StockInOutOrder;
import  com.example.demo.model.StockLocation;
import  com.example.demo.model.WareHouse;

@Erupt(name = "批次移动明细")
@Table(name = "StockMoveLine")
@Entity
public class StockMoveLine extends BaseModel {

        @EruptField(
                views = @View(
                        title = "单号", column = "name"
                ),
                edit = @Edit(
                        title = "单号",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private StockInOutOrder order;

        @EruptField(
                views = @View(
                        title = "批次号", column = "name"
                ),
                edit = @Edit(
                        title = "批次号",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private LotNumber LotCode;

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
                        title = "源库位", column = "name"
                ),
                edit = @Edit(
                        title = "源库位",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private StockLocation srcLocation;

        @EruptField(
                views = @View(
                        title = "目的仓库", column = "name"
                ),
                edit = @Edit(
                        title = "目的仓库",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private WareHouse dstWareHouse;

        @EruptField(
                views = @View(
                        title = "目的库位", column = "name"
                ),
                edit = @Edit(
                        title = "目的库位",
                        type = EditType.REFERENCE_TREE, search = @Search,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private StockLocation dstLocation;

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
                        title = "更新时间"
                ),
                edit = @Edit(
                        title = "更新时间",
                        type = EditType.DATE, notNull = true,
                        dateType = @DateType(type = DateType.Type.TIME)
                )
        )
        private String updatetime;

        @EruptField(
                views = @View(
                        title = "备注"
                ),
                edit = @Edit(
                        title = "备注",
                        type = EditType.INPUT, notNull = true,
                        inputType = @InputType
                )
        )
        private String note;

}