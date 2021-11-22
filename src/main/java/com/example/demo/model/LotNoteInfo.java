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

@Erupt(name = "物料批次信息")
@Table(name = "LotNoteInfo")
@Entity
public class LotNoteInfo extends BaseModel {

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
                        title = "规格1"
                ),
                edit = @Edit(
                        title = "规格1",
                        type = EditType.INPUT, search = @Search, notNull = true,
                        inputType = @InputType
                )
        )
        private String Note1;

}