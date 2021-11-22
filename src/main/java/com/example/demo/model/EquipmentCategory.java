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

@Erupt(name = "设备分类",
        tree = @Tree(pid = "parent.id"))
@Table(name = "EquipmentCategory")
@Entity
public class EquipmentCategory extends BaseModel {

        @EruptField(
                views = @View(
                        title = "分类名称"
                ),
                edit = @Edit(
                        title = "分类名称",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @ManyToOne
        @EruptField(
                edit = @Edit(
                        title = "上级分类",
                        type = EditType.REFERENCE_TREE,
                        referenceTreeType = @ReferenceTreeType(pid = "parent.id")
                )
        )
        private MaterialCategory parent;

}