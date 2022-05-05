package com.farma.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estoque {
    private final Integer Id;
    private final Integer IdMedicamento;
    private final String NomeComercial;
    private Integer Quantidade;

    public Integer getId() {
        return Id;
    }

    public Integer getIdMedicamento() {
        return IdMedicamento;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer qtd) {
        Quantidade = qtd;
    }

    public String getNomeComercial() {
        return NomeComercial;
    }


    public Estoque(@JsonProperty("Id") Integer id, @JsonProperty("IdMedicamento") Integer idMedicamento,@JsonProperty("NomeComercial") String nomeComercial,@JsonProperty("Quantidade") Integer quantidade) {
        Id = id;
        IdMedicamento = idMedicamento;
        NomeComercial = nomeComercial;
        Quantidade = quantidade;
    }
}
