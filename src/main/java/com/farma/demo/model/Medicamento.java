package com.farma.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Medicamento {
    private final Integer Id;
    private final String NomeComercial;
    private final String Fabricante;
    private final String NomeGenerico;
    private final String BulaRemedio;
    private final Double Valor;

    public Integer getId() {
        return Id;
    }

    public String getNomeComercial() {
        return NomeComercial;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public String getNomeGenerico() {
        return NomeGenerico;
    }

    public String getBulaRemedio() {
        return BulaRemedio;
    }

    public Double getValor() {
        return Valor;
    }

    public Medicamento(@JsonProperty("id") Integer id,@JsonProperty("NomeComercial") String nomeComercial,
                       @JsonProperty("Fabricante") String fabricante,@JsonProperty("NomeGenerico") String nomeGenerico,
                       @JsonProperty("BulaRemedio") String bulaRemedio, @JsonProperty("Valor") Double valor) {
        Id = id;
        NomeComercial = nomeComercial;
        Fabricante = fabricante;
        NomeGenerico = nomeGenerico;
        BulaRemedio = bulaRemedio;
        Valor = valor;
    }


}
