package com.jh.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 球队Service层，调用DAO层方法
 */
@Service
public class TeamService {
    @Autowired
    private TeamDao teamDao;

    public void addTeam(Team team) {
        System.out.println("Service层：调用DAO层增加球队");
        teamDao.add(team);
    }

    public void deleteTeam(String name) {
        System.out.println("Service层：调用DAO层删除球队");
        teamDao.delete(name);
    }
}
