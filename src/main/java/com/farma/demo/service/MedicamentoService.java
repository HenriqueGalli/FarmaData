package com.farma.demo.service;

import com.farma.demo.dao.MedicamentoDao;
import com.farma.demo.model.Medicamento;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoDao medicamentoDao;

    @Autowired
    public MedicamentoService(@Qualifier("medicamentoDao") MedicamentoDao medicamentoDao) {  //testar sem o @Qualifier
        this.medicamentoDao = medicamentoDao;
    }

    public int addMedicamento(Medicamento medicamento) {
        return medicamentoDao.insertMedicamento(medicamento);
    }

    public int removeMedicamento(Integer id){
        return medicamentoDao.deleteMedicamento(id);
    }

    public List<Medicamento> getMedicamentoList(){
        return medicamentoDao.getMedicamentoList();
    }
}
