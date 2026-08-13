package com.jh.task1;

import org.springframework.stereotype.Repository;

/**
 * 球队DAO层，完成球队的增加和删除（模拟操作）
 */
@Repository
public class TeamDao {
    public void add(Team team) {
        System.out.println("DAO层：增加球队 -> " + team);
    }

    public void delete(String name) {
        System.out.println("DAO层：删除球队 -> " + name);
    }
}
