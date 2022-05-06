package com.farma.demo.dao;

import com.farma.demo.model.Estoque;
import com.mysql.jdbc.CallableStatement;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("estoqueDao")
public class EstoqueDataAccessService implements EstoqueDao {

    Connection connection = ConectDataBase.conectDb();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement = null;

    @Override
    public List<Estoque> getEstoqueList() {
        try {
            List<Estoque> estoqueList = new ArrayList<>();
            String select = "call spListaEstoque";
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery(select);

            while (resultSet.next()) {
                Estoque estoque = new Estoque(Integer.parseInt(resultSet.getString("Id")),
                        Integer.parseInt(resultSet.getString("IdMedicamento")),
                        resultSet.getString("NomeComercial"),
                        Integer.parseInt(resultSet.getString("Quantidade")));
                estoqueList.add(estoque);
            }
            return estoqueList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int editEstoque(Estoque estoque) {
        //return EstoqueDao.super.editEstoque(estoque);

        try{
            callableStatement = (CallableStatement) connection.prepareCall("{CALL spAlteraQuantidadeEstoque	(?,?)}");

            callableStatement.setInt(1, estoque.getQuantidade());
            callableStatement.setInt(2, estoque.getId());

            callableStatement.executeUpdate();

            return 1;
        }catch (Exception e) {
            System.out.println(e);

            return 0;
        }
    }
}
