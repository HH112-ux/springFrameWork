package com.jh.mapper;

import com.jh.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    /** 查询所有学生 */
    List<Student> findAll();

    /** 根据id查询 */
    Student findById(Integer id);

    /** 新增学生 */
    void save(Student student);

    /** 修改学生 */
    void update(Student student);

    /** 根据id删除 */
    void delete(Integer id);
}
