package com.farma.demo.dao;

import com.farma.demo.model.Medicamento;
import com.mysql.jdbc.CallableStatement;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("medicamentoDao")
public class MedicamentoDataAccessService implements MedicamentoDao {

    Connection connection = ConectDataBase.conectDb();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement = null;


    @Override
    public int insertMedicamento(Medicamento medicamento) {
        try{
            callableStatement = (CallableStatement) connection.prepareCall("{CALL spIncluiMedicamento(?,?,?,?,?)}");
            callableStatement.setString(1, medicamento.getNomeComercial() );
            callableStatement.setString(2, medicamento.getFabricante());
            callableStatement.setString(3, medicamento.getNomeGenerico());
            callableStatement.setString(4, medicamento.getBulaRemedio());
            callableStatement.setDouble(5, medicamento.getValor());

            callableStatement.executeUpdate();

            return 1;
        }catch (Exception e) {
            System.out.println(e);

            return 0;
        }
    }

    @Override
    public int deleteMedicamento(Integer id){
        try{
            callableStatement = (CallableStatement) connection.prepareCall("{CALL spDeleteEstoque(?)}");
            callableStatement.setInt(1, id );
            callableStatement.executeUpdate();

            callableStatement = (CallableStatement) connection.prepareCall("{CALL spDeleteMedicamento(?)}");
            callableStatement.setInt(1, id );
            callableStatement.executeUpdate();

            return 1;
        }catch (Exception e){
            System.out.println(e);

            return 0;
        }
    }

    @Override
    public List<Medicamento> getMedicamentoList() {
        try{
            List<Medicamento> listMedicamentos = new ArrayList<>();
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
            return listMedicamentos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
