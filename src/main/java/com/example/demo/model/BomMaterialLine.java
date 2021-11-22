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

import com.example.demo.model.Material;
import com.example.demo.model.MaterialUnit;
@Erupt(name = "Bom明细")
@Table(name = "BomMaterialLine")
@Entity
public class BomMaterialLine extends BaseModel {

        @EruptField(
                views = @View(
                        title = "物料名称", column = "name"
                ),
                edit = @Edit(
                        title = "物料名称",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private Material name;

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
        private Integer quantity;

        @EruptField(
                views = @View(
                        title = "单位", column = "name"
                ),
                edit = @Edit(
                        title = "单位",
                        type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                        referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private MaterialUnit unit;

}