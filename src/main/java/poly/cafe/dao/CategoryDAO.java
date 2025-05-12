/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao;

import java.util.List;
import poly.cafe.entity.Category;
import poly.cafe.util.XJDBC;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class CategoryDAO {

    final String INSERT_SQL = "insert into Categories(id,name) values (?,?)";
    final String UPDATE_SQL = "UPDATE Categories SET name=? WHERE Id=?";
    final String DELETE_SQL = "DELETE FROM  Categories WHERE Id=?";
    final String SELLECT_ALL_SQL = "SELECT*FROM Categories";
    final String SELLECT_BY_ID_SQL = "SELECT*FROM Categories WHERE Id=?";

    public void insert(Category entity) {
        XJDBC.update(INSERT_SQL, entity.getId(), entity.getName());
    }

    public void update(Category entity) {
        XJDBC.update(UPDATE_SQL, entity.getName(), entity.getId());
    }

    public void delete(String id) {
        XJDBC.update(DELETE_SQL, id);
    }

    public List<Category> selectAll() {
        return selectBySQL(SELLECT_ALL_SQL);
    }

    public Category selectedById(String id) {
        List<Category> list = selectBySQL(SELLECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
public List<Category> selectBySQL(String sql, Object... args) {
    List<Category> list = new ArrayList<>();
    
    try (
        ResultSet rs = XJDBC.query(sql, args);
    ) {
        while (rs.next()) {
            Category entity = new Category();
            entity.setId(rs.getString("Id"));
            entity.setName(rs.getString("Name"));
            list.add(entity);
        }
        rs.getStatement().getConnection().close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    return list;
}
}
