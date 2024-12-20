package com.project.template.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.template.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 试题表
 * </p>
 *
 * @author B站：程序员瑞哥
 *
 */
@Getter
@Setter
@TableName("exam_question")
@ApiModel(value = "ExamQuestion对象", description = "试题表")
public class ExamQuestion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("题目")
    private String name;

    @ApiModelProperty("题型")
    private String type;

    @ApiModelProperty("选择题选项")
    private String options;

    @ApiModelProperty("正确答案")
    private String answer;

    @ApiModelProperty("分值")
    private Integer score;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @TableField(exist = false)
    private String user;
}
