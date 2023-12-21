package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.QueryDAO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOimpl implements QueryDAO {
    @Override
    public void printDetails() {
        String sql = "SELECT * FROM Orders o LEFT JOIN OrderDetails od ON o.oid=od.oid";
        try {
            ResultSet rst = SQLUtil.execute(sql);
            while (rst.next()){
                String orderId = rst.getString("oid");
                String orderDate = rst.getString("date");
                String customerID = rst.getString("customerID");
                String detailOrderId = rst.getString("od.oid");
                String itemCode = rst.getString("itemCode");
                Integer qty = rst.getInt("qty");
                BigDecimal unitPrice = rst.getBigDecimal("unitPrice");

                System.out.println("Order ID: " + orderId);
                System.out.println("Order Date: " + orderDate);
                System.out.println("Customer ID: " + customerID);
                System.out.println("Detail Order ID: " + detailOrderId);
                System.out.println("Item Code: " + itemCode);
                System.out.println("Quantity: " + qty);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("-----------------------------------");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
