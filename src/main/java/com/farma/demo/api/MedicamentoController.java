package com.farma.demo.api;

import com.farma.demo.model.Medicamento;
import com.farma.demo.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoService.addMedicamento(medicamento);
    }

    @GetMapping
    public List<Medicamento> getMedicamentoList(){
        return medicamentoService.getMedicamentoList();
    }

}
