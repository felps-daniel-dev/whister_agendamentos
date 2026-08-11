package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> novoPaciente(@RequestBody PacienteRequestDTO request) {
        return ResponseEntity.ok().body(pacienteService.novoPaciente(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable Long id) {
        pacienteService.excluirPaciente(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO request){
        return ResponseEntity.ok().body(pacienteService.atualizarPaciente(id, request));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PacienteResponseDTO>> listarPacientes(){
        return ResponseEntity.ok().body(pacienteService.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pacienteService.buscaPacientePorId(id));
    }


}
