package com.kk.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 *
 * @author 柯神_
 * @date 2021-03-11 15:48:09
 * @Description   代码生成器
 * @param
 * @return
*/
public class AutoCode {

    public static void main(String[] args) {

      final AutoGenerator ag = new AutoGenerator();

        // 1.全局配置
        final GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir"); // 获取当前目录
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("柯柯Ovo");
        gc.setOpen(false); // 是否打开文件夹
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去掉 service 的前缀 I
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        ag.setGlobalConfig(gc);

        // 2.配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("666666");
        dsc.setDbType(DbType.MYSQL);
        ag.setDataSource(dsc);

        // 3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.kk");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        ag.setPackageInfo(pc);

        // 4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("student");  // 设置要映射的表
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("父类实体，没有就不用设置");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        ag.setStrategy(strategy);
        strategy.setLogicDeleteFieldName("deleted");  // 逻辑删除
        final TableFill createTime = new TableFill("create_time", FieldFill.INSERT);// 自动填充
        final TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);// 自动填充
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(createTime);
        list.add(updateTime);
        strategy.setTableFillList(list);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        ag.setStrategy(strategy);


        // 5.执行
        ag.execute();


    }
}
