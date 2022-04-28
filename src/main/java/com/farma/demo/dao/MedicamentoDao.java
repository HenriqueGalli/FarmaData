package com.farma.demo.dao;

import com.farma.demo.model.Medicamento;

import java.util.List;

public interface MedicamentoDao {
    int insertMedicamento(String nomeComercial, String fabricante,
                          String nomeGenerico, String bulaRemedio, Double valor);

    List<Medicamento> getMedicamentoList();

    default int insertMedicamento(Medicamento medicamento) {
        return insertMedicamento(
                medicamento.getNomeComercial(), medicamento.getFabricante(),
                medicamento.getNomeGenerico(), medicamento.getBulaRemedio(),
                medicamento.getValor());
    }

}
