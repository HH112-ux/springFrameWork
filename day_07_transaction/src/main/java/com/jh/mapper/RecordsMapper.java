package com.jh.mapper;

import com.jh.entity.Records;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsMapper {
    @Insert("insert into records values(null,#{accno},#{category},#{money})")
    void insert(Records records);
}
