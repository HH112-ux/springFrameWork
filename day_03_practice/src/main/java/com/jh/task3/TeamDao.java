package com.jh.task3;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 球队DAO层，使用JDBC + Druid完成实际数据库操作
 */
@Repository
public class TeamDao {
    @Autowired
    private DruidDataSource dataSource;

    /**
     * 增加球队
     */
    public void add(Team team) {
        String sql = "INSERT INTO team (name, addr) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, team.getName());
            ps.setString(2, team.getAddr());
            int rows = ps.executeUpdate();
            System.out.println("DAO层：增加球队成功，影响行数=" + rows + " -> " + team);
        } catch (SQLException e) {
            System.out.println("DAO层：增加球队失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 根据名称删除球队
     */
    public void delete(String name) {
        String sql = "DELETE FROM team WHERE name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            int rows = ps.executeUpdate();
            System.out.println("DAO层：删除球队成功，影响行数=" + rows + " -> name=" + name);
        } catch (SQLException e) {
            System.out.println("DAO层：删除球队失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 查询所有球队
     */
    public List<Team> findAll() {
        List<Team> list = new ArrayList<>();
        String sql = "SELECT id, name, addr FROM team";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setAddr(rs.getString("addr"));
                list.add(team);
            }
        } catch (SQLException e) {
            System.out.println("DAO层：查询球队失败：" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 初始化表（如果表不存在则创建）
     */
    public void initTable() {
        String sql = "CREATE TABLE IF NOT EXISTS team (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "addr VARCHAR(100)" +
                ")";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("DAO层：表team初始化完成");
        } catch (SQLException e) {
            System.out.println("DAO层：初始化表失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
