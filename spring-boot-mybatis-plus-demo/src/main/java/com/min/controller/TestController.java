package com.min.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.min.entity.Student;
import com.min.service.StudentService;
import com.min.util.Result;
@RestController
@RequestMapping("/v1/login")
public class TestController {
	
	@Autowired
    private StudentService studentService;

    @RequestMapping("/register")
    public Result Register(@RequestBody Student student){
        studentService.insert(student);
        return new Result(Result.OK,"保存成功");
    }

    @RequestMapping("/findAllStudent")
    public Result test1(){
        Result result = new Result();
        List<Student> student = studentService.findAllStudent();
        result.setData(student);
        return result;
    }

    @RequestMapping("/findSomeColumn")
    public Result test2(){
        Result result = new Result();
        List<Student> stu = studentService.findSomeColumn();
        result.setData(stu);
        return result;
    }

    @RequestMapping("/deleteById/{id}")
    public Result test3(@PathVariable  Integer id){
        Result result = new Result();
        studentService.deleteById(id);
        result.setMsg("删除成功");
        return result;
    }

    @RequestMapping("/updateByPrimarKeySelective")
    public Result test4(@RequestBody Student student){
        Result result = new Result();
        EntityWrapper<Student> entityWrapper = new EntityWrapper<Student>();
        entityWrapper.eq("stu_mobile", student.getStuMobile());
        Student stu = studentService.selectOne(entityWrapper);
        if (null != stu) {
            stu.setParName("my hero");
            stu.setStuName("zxs");
        }
        studentService.updateByPrimarKeySelective(stu);
        result.setData(stu);
        return result;
    }

    @RequestMapping("/saveStudent")
    public Result<Student> test5(@RequestBody Student student){
        Result<Student> result = new Result<Student>();
        studentService.saveStudent(student);
        result.setData(student);

        return result;

    }
    /**
     * 分页的方法
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("/page/{pageNumber}")
    public Result findAllStuPage(@PathVariable Integer pageNumber,
                                     @RequestParam(defaultValue="6") Integer pageSize){
        Result result = new Result();
        Page page = new Page(pageNumber,pageSize);
        Page<Student> pageStu = studentService.findAllStudentPage(page);
         result.setData(pageStu.getRecords());
        return result;

    }

    @RequestMapping("/pageByGender/{pageNumber}")
    public Result findStuByGender(@PathVariable Integer pageNumber,
            @RequestParam(defaultValue="6") Integer pageSize){
        Result result = new Result();

        EntityWrapper<Student> wrapper = new EntityWrapper<Student>();
        wrapper.eq("gender", 1);
        Page<Student> page = getPage(pageNumber, pageSize);
        Page<Student> stuPage = studentService.selectPage(page, wrapper);
        result.setData(stuPage.getRecords());

        return result;
    }



    /**
     * 获取分页对象
     * 每页显示数量
     */

    private <T> Page<T> getPage(int pageNum,int pageSize){

        return new Page<T>(pageNum,pageSize);
    }
}
