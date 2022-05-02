package com.farma.demo.dao;

import com.farma.demo.model.Medicamento;

import java.util.List;

public interface MedicamentoDao {

    List<Medicamento> getMedicamentoList();

    default int insertMedicamento(Medicamento medicamento) {
        return insertMedicamento(medicamento);
    }

}
