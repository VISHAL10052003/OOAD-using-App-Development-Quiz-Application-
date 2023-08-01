package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pms.model.Student;
import com.pms.util.DBHandler;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void create(Student s) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = DBHandler.getConnection();
            String query = "INSERT INTO student(regno, sname, subject1, subject2, subject3) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, s.getRegno());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getWebScore());
            ps.setInt(4, s.getSqlScore());
            ps.setInt(5, s.getJavaScore());
            
            int rows = ps.executeUpdate();
            System.out.println(rows + " row inserted");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<Student> read(int total) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        try {
            conn = DBHandler.getConnection();
            String query = "SELECT * FROM student WHERE total > ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, total);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setRegno(rs.getInt("regno"));
                s.setName(rs.getString("sname"));
                s.setWebScore(rs.getInt("subject1"));
                s.setSqlScore(rs.getInt("subject2"));
                s.setJavaScore(rs.getInt("subject3"));
                s.setTotalScore(rs.getInt("total"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }

    @Override
    public void update(int regno) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBHandler.getConnection();
            String query = "UPDATE student SET total = subject1 + subject2 + subject3 WHERE regno = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, regno);

            int res = ps.executeUpdate();
            System.out.println(res + " row updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void delete(int regno) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBHandler.getConnection();
            String query = "DELETE FROM student WHERE regno = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, regno);

            int res = ps.executeUpdate();
            System.out.println(res + " row deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

