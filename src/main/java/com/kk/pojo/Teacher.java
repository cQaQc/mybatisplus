package com.kk.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

  @TableId(type = IdType.AUTO)
  private long tid;
  private String tname;

  @Version
  private Integer version;
  @TableLogic
  private Integer deleted;

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;



}
