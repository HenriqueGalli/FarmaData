package com.farma.demo.dao;

import com.farma.demo.model.Estoque;

import java.util.List;

public interface EstoqueDao {

    List<Estoque> getEstoqueList();

    default int editEstoque(Estoque estoque) {
        return editEstoque(estoque);
    }
}
