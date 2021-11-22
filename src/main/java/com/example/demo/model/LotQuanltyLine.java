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

import com.example.demo.model.LotNumber;
@Erupt(name = "批次数量明细")
@Table(name = "LotQuanltyLine")
@Entity
public class LotQuanltyLine extends BaseModel {

        @EruptField(
                views = @View(
                        title = "批次号", column = "code"
                ),
                edit = @Edit(
                        title = "批次号",
                        type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                        referenceTableType = @ReferenceTableType(id = "id", label = "code")
                )
        )
        @ManyToOne
        private LotNumber lotCode;

        @EruptField(
                views = @View(
                        title = "操作数量"
                ),
                edit = @Edit(
                        title = "操作数量",
                        type = EditType.NUMBER, search = @Search, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer quantity;

        @EruptField(
                views = @View(
                        title = "操作状态"
                ),
                edit = @Edit(
                        title = "操作状态",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "xxx", label = "xxx"), @VL(value = "yyy", label = "yyy")})
                )
        )
        private String status;

}