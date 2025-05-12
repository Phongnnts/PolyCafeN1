/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import poly.cafe.entity.User;
import poly.cafe.util.XJDBC;

public class UserDAO extends CrudDAO<User, String> {

    final String INSERT_SQL = "INSERT INTO Users(Username, Password, Enabled, Fullname, Photo, Manager) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE Users SET Password = ?, Enabled = ?, Fullname = ?, Photo = ?, Manager = ? WHERE Username = ?";
    final String DELETE_SQL = "DELETE FROM Users WHERE Username = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Users";
    final String SELECT_BY_ID_SQL = "SELECT * FROM Users WHERE Username = ?";

    @Override
    public void insert(User entity) {
        XJDBC.update(INSERT_SQL, entity.getUsername(), entity.getPasssword(), entity.isEnabled(), entity.getFullname(), entity.getPhoto(), entity.isManager());
    }

    @Override
    public void update(User entity) {
        XJDBC.update(UPDATE_SQL, entity.getPasssword(), entity.isEnabled(), entity.getFullname(), entity.getPhoto(), entity.isManager(), entity.getUsername());
    }

    public void delete(String id) {
        XJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<User> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    public User selectByID(String id) {
        List<User> list = selectBySQL(SELECT_BY_ID_SQL, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<User> selectBySQL(String sql, Object... args) {
        List<User> list = new ArrayList<>();
        try (ResultSet rs = XJDBC.query(sql, args)) {
            while (rs.next()) {
                User entity = new User();
                entity.setUsername(rs.getString("Username"));
                entity.setPasssword(rs.getString("Password"));
                entity.setEnabled(rs.getBoolean("Enabled"));
                entity.setFullname(rs.getString("Fullname"));
                entity.setPhoto(rs.getString("Photo"));
                entity.setManager(rs.getBoolean("Manager"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error querying Users", e);
        }
        return list;
    }

    @Override
    public User selectedByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}