package com.min.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.min.entity.Student;
import com.min.mapper.StudentMapper;
import com.min.service.StudentService;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService{

	    public List<Student> findAllStudent() {
	        return baseMapper.findAllStudent();
	    }

	    public List<Student> findSomeColumn() {
	        return baseMapper.findSomeColumn();
	    }

	    public void deleteById(Integer id) {
	        baseMapper.deleteById(id);

	    }

	    public void updateByPrimarKeySelective(Student student) {
	        baseMapper.updateById(student);

	    }

	    public void saveStudent(Student student) {
	        baseMapper.saveStudent(student);

	    }

	    public Page<Student> findAllStudentPage(Page<Student> page) {
	        page.setRecords(baseMapper.findAllStudentPage(page));
	        return page;
	    }

	    public List<Student> findStuByGender(Integer gender) {
	        return baseMapper.findStuByGender(gender);
	    }
	  
	 
}
