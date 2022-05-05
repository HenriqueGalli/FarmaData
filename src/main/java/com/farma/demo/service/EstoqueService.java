package com.farma.demo.service;

import com.farma.demo.dao.EstoqueDao;
import com.farma.demo.model.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    private final EstoqueDao estoqueDao;

    @Autowired
    public EstoqueService(@Qualifier("estoqueDao") EstoqueDao estoqueDao) {
        this.estoqueDao = estoqueDao;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueDao.getEstoqueList();
    }

    public void editEstoque(Estoque estoque) {
        estoqueDao.editEstoque(estoque);
    }

}
