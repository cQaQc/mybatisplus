package com.kk.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mapper.UserMapper;
import com.kk.pojo.Teacher;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     *  查询
     */

    @Test
    void context() {
        List<Teacher> teachers = userMapper.selectList(null);
        teachers.forEach(System.out::println);
    }


    /**
     * 插入
     */
    @Test
    void testInsert() {
        Teacher teacher = new Teacher();
        teacher.setTname("小柯");
        int insert = userMapper.insert(teacher);
    }

    /**
     * 更新
     */
    @Test
    void testUpdate() {
        Teacher teacher = new Teacher();
        teacher.setTid(8l);
        teacher.setTname("小南");
        userMapper.updateById(teacher);
    }

    /**
     * 测试乐观锁
     */
    @Test
    void testOpt(){
        Teacher teacher = userMapper.selectById(1);
        teacher.setTname("南柯1梦");
        userMapper.updateById(teacher);
    }


    /**
     * 测试分页
     */
    @Test
    void testPage(){
        Page<Teacher> page = new Page<Teacher>(2,2);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    void testDel(){
        userMapper.deleteById(5l);
    }

    /**
     * wrapper
     */
    @Test
    void testWra(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("tname")
                .isNotNull("tid")
        .ge("version",2);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void testWra1(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        final QueryWrapper<Teacher> eq = wrapper.eq("tname", "小柯");
        final List<Teacher> teachers = userMapper.selectList(eq);
        System.out.println(teachers);
    }
    @Test
    void testWra2(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        final QueryWrapper<Teacher> between = wrapper.between("version",2,3);
        final List<Teacher> teachers = userMapper.selectList(between);
        System.out.println(teachers);
    }

    @Test
    void testWra3(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("tname", "1")
                .likeRight("tname","小");
        final List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }


    @Test
    void testWra4(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper
                .inSql("tid","select tid from teacher where tid>6");
        final List<Teacher> maps = userMapper.selectList(wrapper);
        maps.forEach(System.out::println);
    }

}
