package com.kk.blog.service.impl;

import com.kk.blog.entity.Student;
import com.kk.blog.mapper.StudentMapper;
import com.kk.blog.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 柯柯Ovo
 * @since 2021-03-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
