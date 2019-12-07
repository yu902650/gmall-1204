package com.atguigu.gmall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author bo bo
 * @date 2019/12/5 22:15
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageInfoVo implements Serializable {
    private static final long serialVersionUID = 1601619699219218004L;
    @ApiModelProperty("总记录数")
    private Long total;

    @ApiModelProperty("总页码")
    private Long totalPage;

    @ApiModelProperty("每页显示的记录数")
    private Long pageSize;

    @ApiModelProperty("分页查出的数据")
    private List<? extends Object> list;

    @ApiModelProperty("当前页的页码")
    private Long pageNum;
}
