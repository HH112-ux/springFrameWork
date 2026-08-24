package com.jh.mapper;

import com.jh.entity.Acc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccMapper {
    void insert(Acc acc);

    Acc findByAccount(String account);

    void updateCoupon(Acc acc);

    List<Acc> selectList();
}
