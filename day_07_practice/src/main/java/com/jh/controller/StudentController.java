package com.jh.controller;

import com.jh.entity.Student;
import com.jh.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 学生管理控制器
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 学生列表
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    /**
     * 跳转到新增页面
     */
    @GetMapping("/toAdd")
    public String toAdd() {
        return "student/add";
    }

    /**
     * 新增学生
     */
    @PostMapping("/add")
    public String add(Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String toEdit(Integer id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/edit";
    }

    /**
     * 修改学生
     */
    @PostMapping("/edit")
    public String edit(Student student) {
        studentService.update(student);
        return "redirect:/student/list";
    }

    /**
     * 删除学生
     */
    @GetMapping("/delete")
    public String delete(Integer id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }
}
