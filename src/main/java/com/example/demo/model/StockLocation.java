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

import com.example.demo.model.WareHouse;

@Erupt(
        name = "库位",
        tree = @Tree(pid = "parent.id")
)
@Table(name = "StockLocation")
@Entity
public class StockLocation extends BaseModel {

        @EruptField(
                views = @View(
                        title = "库位编号"
                ),
                edit = @Edit(
                        title = "库位编号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @EruptField(
                views = @View(
                        title = "仓库", column = "name"
                ),
                edit = @Edit(
                        title = "仓库",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private WareHouse Warehouse;

        @ManyToOne
        @EruptField(
                edit = @Edit(
                        title = "上级库位",
                        type = EditType.REFERENCE_TREE,
                        referenceTreeType = @ReferenceTreeType(pid = "parent.id")
                )
        )
        private StockLocation parent;

}