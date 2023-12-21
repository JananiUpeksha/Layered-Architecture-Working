package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO> {
    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean Save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean exitItem(String code) throws SQLException, ClassNotFoundException;
    boolean delete(String code) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
