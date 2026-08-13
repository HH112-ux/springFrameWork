package com.jh.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void listAllTeams() {
        System.out.println("Service层：调用DAO层查询所有球队");
        List<Team> teams = teamDao.findAll();
        if (teams.isEmpty()) {
            System.out.println("当前没有球队数据");
        } else {
            for (Team team : teams) {
                System.out.println("  " + team);
            }
        }
    }

    public void initTable() {
        teamDao.initTable();
    }
}
