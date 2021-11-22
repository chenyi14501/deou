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

@Erupt(name = "物料工序")
@Table(name = "MaterialManufactureStep")
@Entity
public class MaterialManufactureStep extends BaseModel {

        @EruptField(
                views = @View(
                        title = "序号"
                ),
                edit = @Edit(
                        title = "序号",
                        type = EditType.NUMBER, search = @Search, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer sort;

        @EruptField(
                views = @View(
                        title = "生产工序", column = "name"
                ),
                edit = @Edit(
                        title = "生产工序",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "name")
                )
        )
        @ManyToOne
        private ManufactureStep name;

        @EruptField(
                views = @View(
                        title = "操作特殊说明"
                ),
                edit = @Edit(
                        title = "操作特殊说明",
                        type = EditType.HTML_EDITOR, notNull = true,
                        htmlEditorType = @HtmlEditorType(HtmlEditorType.Type.UEDITOR)
                )
        )
        private @Lob String OpNote;

        @EruptField(
                views = @View(
                        title = "质检特殊说明"
                ),
                edit = @Edit(
                        title = "质检特殊说明",
                        type = EditType.HTML_EDITOR,  notNull = true,
                        htmlEditorType = @HtmlEditorType(HtmlEditorType.Type.UEDITOR)
                )
        )
        private @Lob String quanlityCheckNote;

}