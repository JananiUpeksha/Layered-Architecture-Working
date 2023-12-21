package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    @Override
        public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
            /*Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, dto.getOid());
            stm.setString(2, dto.getItemCode());
            stm.setBigDecimal(3, dto.getUnitPrice());
            stm.setInt(4, dto.getQty());
            return stm.executeUpdate()>0;*/
            return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
        }

}
