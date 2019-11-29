package com.rayeye.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author licc
 * @since 2019-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Build对象", description="")
public class Build implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "这是id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;


}
