/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao;

import java.util.List;
import poly.cafe.entity.Drink;
import poly.cafe.util.XJDBC;

/**
 *
 * @author admin
 */
public class DrinkDAO extends CrudDAO<Drink,String> {
    final String INSERT_SQL="insert into Drink (id,name,uniprice,discount,image,available,categoryid) values(?,?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE Drinks SET name =?,uniprice=?,dicount=?,image=?,available=?,categoryid=? WHERE Id=?";
    final String DELETE_SQL="DELETE FROM Drinks WHERE Id=?";
    final String SELECT_ALL_SQL="SELECT* FROM Drinks";
    final String SELECT_BY_ID_SQL="SELECT* FROM Drinks WHERE Id=?";
    final String SELECT_BY_Category_SQL="SELECT*FROM Drinks WHERE CategoryId=?";

    @Override
    public void insert (Drink entity) {
        XJDBC.update(INSERT_SQL, entity.getId(), entity.getName(), entity.getUnitPrice(), entity.getDiscount(), entity.getImage(), entity.isAvailable(), entity.getCategoryId());
    }
    
        @Override
    public void update (Drink entity) {
        XJDBC.update(UPDATE_SQL, entity.getName(), entity.getUnitPrice(), entity.getDiscount(), entity.getImage(), entity.isAvailable(), entity.getCategoryId());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Drink> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Drink selectByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Drink> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
