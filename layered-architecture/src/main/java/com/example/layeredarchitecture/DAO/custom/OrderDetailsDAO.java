package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface OrderDetailsDAO {
    boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
