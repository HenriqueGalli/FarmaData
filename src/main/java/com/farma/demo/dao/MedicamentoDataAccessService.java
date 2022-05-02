package com.farma.demo.dao;

import com.farma.demo.model.Medicamento;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("medicamentoDao")
public class MedicamentoDataAccessService implements MedicamentoDao {

    private List<Medicamento> listMedicamentos = new ArrayList<>();
    Connection connection = ConectDataBase.conectDb();
    PreparedStatement preparedStatement;

    @Override
    public int insertMedicamento(Medicamento medicamento) {
        try{
            String insert = "INSERT INTO medicamento (NomeComercial, Fabricante, NomeGenerico, BulaRemedio, Valor) VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,medicamento.getNomeComercial());
            preparedStatement.setString(2,medicamento.getFabricante());
            preparedStatement.setString(3,medicamento.getNomeGenerico());
            preparedStatement.setString(4,medicamento.getBulaRemedio());
            preparedStatement.setDouble(5,medicamento.getValor());
            preparedStatement.executeUpdate();
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Medicamento> getMedicamentoList() {
        try{
            String select = "call spListaMedicamentos";
            preparedStatement = connection.prepareStatement(select);
            ResultSet medicamentosResponse = preparedStatement.executeQuery(select);
            while (medicamentosResponse.next()){
                Medicamento medicamento = new Medicamento(Integer.parseInt(medicamentosResponse.getString("Id")),
                        medicamentosResponse.getString("NomeComercial"), medicamentosResponse.getString("Fabricante"),
                        medicamentosResponse.getString("NomeGenerico"), medicamentosResponse.getString("BulaRemedio"),
                        Double.parseDouble(medicamentosResponse.getString("Valor")));
                listMedicamentos.add(medicamento);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listMedicamentos;
    }
}
