package com.jh.mapper;

import com.jh.entity.Records;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordsMapper {
    void insert(Records records);

    List<Records> selectList();
}
