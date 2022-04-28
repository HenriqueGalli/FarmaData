package com.farma.demo.dao;

import com.farma.demo.model.Medicamento;
import org.springframework.stereotype.Repository;

import java.awt.image.MemoryImageSource;
import java.util.ArrayList;
import java.util.List;

@Repository("medicamentoDao")
public class MedicamentoDataAccessService implements MedicamentoDao {

    private List<Medicamento> list = new ArrayList<Medicamento>();



    @Override
    public int insertMedicamento(String nomeComercial, String fabricante,
                                 String nomeGenerico, String bulaRemedio, Double valor) {
        //TODO chamar o banco de dados
        return 0;
    }

    @Override
    public List<Medicamento> getMedicamentoList() {
        list.add(new Medicamento(0,"teste","treste","teste","teste",30.));
        return list;
    }

}
