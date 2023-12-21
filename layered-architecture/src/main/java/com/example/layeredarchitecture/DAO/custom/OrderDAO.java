package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO {
    public String newOrderID() throws SQLException, ClassNotFoundException;
    public boolean orderexist(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

}
