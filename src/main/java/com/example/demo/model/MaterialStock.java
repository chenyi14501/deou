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

@Erupt(name = "物料库存")
@Table(name = "MaterialStock")
@Entity
public class MaterialStock extends BaseModel {

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
                        title = "当前库存数"
                ),
                edit = @Edit(
                        title = "当前库存数",
                        type = EditType.NUMBER, search = @Search, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer quantity;

}