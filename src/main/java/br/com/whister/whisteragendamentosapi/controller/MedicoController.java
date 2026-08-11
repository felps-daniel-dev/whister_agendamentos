package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.medico.MedicoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.medico.MedicoResponseDTO;
import br.com.whister.whisteragendamentosapi.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(medicoService.buscarMedicoPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MedicoResponseDTO>> listarMedico(){
        return ResponseEntity.ok().body(medicoService.listarMedico());
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> novoMedico(@RequestBody MedicoRequestDTO request){
        return ResponseEntity.ok().body(medicoService.novoMedico(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id){
        medicoService.excluirMedico(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicoRequestDTO request){
        return ResponseEntity.ok().body(medicoService.atualizarMedico(id, request));
    }
}
