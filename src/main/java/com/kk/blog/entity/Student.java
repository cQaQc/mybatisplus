package com.kk.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author 柯柯Ovo
 * @since 2021-03-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student{

    private static final long serialVersionUID = 1L;

    private Integer sid;

    private String sname;

    private Integer sage;

    private String ssex;


}
