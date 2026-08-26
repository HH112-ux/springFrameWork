package com.jh.mapper;

import com.jh.entity.Acc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccMapper {
    @Update("update acc set money=money-#{money} where accno=#{accno}")
    void update(Acc acc);
    @Delete("delete from acc where id=#{id}")
    void delete(int id);
    @Select("select * from acc")
    List<Acc> selectList();
}
