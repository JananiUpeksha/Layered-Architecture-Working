package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    boolean itemSave(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean exitItem(String code) throws SQLException, ClassNotFoundException;
    void deleteItem(String code) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
