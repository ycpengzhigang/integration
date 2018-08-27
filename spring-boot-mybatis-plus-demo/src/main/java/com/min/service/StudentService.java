package com.min.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.min.entity.Student;

public interface StudentService extends IService<Student> {
	
	List<Student> findAllStudent();

	List<Student> findSomeColumn();

	void deleteById(Integer id);

	void updateByPrimarKeySelective(Student student);

	void saveStudent(Student student);

	Page<Student> findAllStudentPage(Page<Student> page);

	List<Student> findStuByGender(Integer gender);

}
