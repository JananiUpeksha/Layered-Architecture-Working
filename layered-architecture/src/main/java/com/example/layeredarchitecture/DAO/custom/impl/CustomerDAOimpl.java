package com.example.layeredarchitecture.DAO.custom.impl;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public  class CustomerDAOimpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }
    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
       /* ArrayList<CustomerDTO> saveCustomer = new ArrayList<>();
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customerDTO.getId());
        pstm.setString(2, customerDTO.getName());
        pstm.setString(3, customerDTO.getAddress());*/
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }
    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1,customerDTO.getName());
        pstm.setString(2,customerDTO.getAddress());
        pstm.setString(3,customerDTO.getId());

        pstm.executeUpdate();*/
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());

    }
    @Override
    public boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1,customerDTO.getId());
        pstm.executeUpdate();*/
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",customerDTO.getId());
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
    @Override
    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1,id);
        return pstm.executeQuery().next();*/
        ResultSet rs =SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return rs.next();
    }
    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue + "");
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
        return customerDTO;
    }
}
