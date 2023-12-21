package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(T dto) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;
    public T search(String newValue) throws SQLException, ClassNotFoundException;
}
