package com.farma.demo.api;

import com.farma.demo.model.Estoque;
import com.farma.demo.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    @CrossOrigin
    public List<Estoque> getListEstoque() {
        return estoqueService.getEstoqueList();
    }

    @PatchMapping
    @CrossOrigin
    public void editEstoque(@RequestBody Estoque estoque) {
        estoqueService.editEstoque(estoque);
    }

}
