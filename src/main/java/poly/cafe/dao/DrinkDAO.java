/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.dao;

import poly.cafe.util.XJDBC;

/**
 *
 * @author admin
 */
public interface DrinkDAO {
    @Override
    public void insert (Drink entity) {
        XJDBC.update(INSERT_SQL, entity.getId(), entity.getNam(), entity.UnitPrice(), entity.getDiscount(), entity.getImage(), entity.isAvailable(), entity.getCategoryId());
    }
    
        @Override
    public void update (Drink entity) {
        XJDBC.update(UPDATE_SQL, entity.getNam(), entity.UnitPrice(), entity.getDiscount(), entity.getImage(), entity.isAvailable(), entity.getCategoryId());
    }
    
}
