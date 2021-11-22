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


import com.example.demo.model.MaterialCategory;
import com.example.demo.model.MaterialUnit;
import com.example.demo.model.BomMaterialLine;
import com.example.demo.model.MaterialManufactureStep;
@Erupt(name = "物料",
        linkTree = @LinkTree(field = "materialCategory"))
@Table(name = "Material")
@Entity
public class Material extends BaseModel {

        @EruptField(
                views = @View(
                        title = "物料名称"
                ),
                edit = @Edit(
                        title = "物料名称",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String name;

        @EruptField(
                views = @View(
                        title = "货号"
                ),
                edit = @Edit(
                        title = "货号",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String code;

        @EruptField(
                views = @View(
                        title = "物料分类", column = "name"
                ),
                edit = @Edit(
                        title = "物料分类",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private MaterialCategory materialCategory;

        @EruptField(
                views = @View(
                        title = "物料单位", column = "name"
                ),
                edit = @Edit(
                        title = "物料单位",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private MaterialUnit materialUnit;

        @EruptField(
                views = @View(
                        title = "Bom明细"
                ),
                edit = @Edit(
                        title = "Bom明细",
                        type = EditType.TAB_TABLE_ADD
                )
        )
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @OrderBy
        @JoinColumn(name = "material_id")
        private Set<BomMaterialLine> BomLines;

        @EruptField(
                views = @View(
                        title = "工艺路线"
                ),
                edit = @Edit(
                        title = "工艺路线",
                        type = EditType.TAB_TABLE_ADD
                )
        )
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @OrderBy
        @JoinColumn(name = "material_id")
        private Set<MaterialManufactureStep> MaterialManufactureSteps;

}