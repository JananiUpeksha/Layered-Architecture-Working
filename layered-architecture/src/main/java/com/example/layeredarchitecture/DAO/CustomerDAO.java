package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    void deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    String generateId() throws SQLException, ClassNotFoundException;
    boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
