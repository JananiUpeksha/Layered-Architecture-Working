package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public class OrderDAOimpl implements OrderDAO {
    @Override
    public String newOrderID() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");*/
        ResultSet rst= SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

    }
    @Override
    public boolean orderexist(String orderId) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        *//*if order id already exist*//*
        return stm.executeQuery().next();*/
        return SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
    }
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderDTO.getOrderId());
        stm.setDate(2, Date.valueOf(orderDTO.getOrderDate()));
        stm.setString(3, orderDTO.getCustomerId());
        return stm.executeUpdate()>0;*/
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderDTO.getOrderId(),Date.valueOf(orderDTO.getOrderDate()),orderDTO.getCustomerId());
    }

}
