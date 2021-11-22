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

@Erupt(name = "批次库存明细",
        linkTree = @LinkTree(field = "lotCode")
)
@Table(name = "LotStock")
@Entity
public class LotStock extends BaseModel {

        @EruptField(
                views = @View(
                        title = "批次唯一码", column = "code"
                ),
                edit = @Edit(
                        title = "批次唯一码",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "code")
                )
        )
        @ManyToOne
        private LotNumber lotCode;

        @EruptField(
                views = @View(
                        title = "库位", column = "name"
                ),
                edit = @Edit(
                        title = "库位",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private StockLocation localtion;

        @EruptField(
                views = @View(
                        title = "数量"
                ),
                edit = @Edit(
                        title = "数量",
                        type = EditType.NUMBER, search = @Search, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer quanltity;

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