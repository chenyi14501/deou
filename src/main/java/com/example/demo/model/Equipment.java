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

import com.example.demo.model.EquipmentCategory;

@Erupt(name = "设备名称",
        linkTree = @LinkTree(field = "category"))
@Table(name = "Equipment")
@Entity
public class Equipment extends BaseModel {

        @EruptField(
                views = @View(
                        title = "设备名"
                ),
                edit = @Edit(
                        title = "设备名",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @EruptField(
                views = @View(
                        title = "设备类别", column = "name"
                ),
                edit = @Edit(
                        title = "设备类别",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private EquipmentCategory category;

        @EruptField(
                views = @View(
                        title = "设备编号"
                ),
                edit = @Edit(
                        title = "设备编号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String code;

}