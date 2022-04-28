package com.farma.demo.api;

import com.farma.demo.model.Medicamento;
import com.farma.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public void addMedicamento(Medicamento medicamento) {
        medicamentoService.addMedicamento(medicamento);
    }

    @GetMapping
    public List<Medicamento> getMedicamentoList(){
        return medicamentoService.getMedicamentoList();
    }

}
