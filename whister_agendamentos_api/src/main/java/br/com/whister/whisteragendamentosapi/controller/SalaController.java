package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.sala.SalaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.sala.SalaResponseDTO;
import br.com.whister.whisteragendamentosapi.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(salaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> novaSala(@RequestBody @Valid SalaRequestDTO request){
        return ResponseEntity.ok().body(salaService.novaSala(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSala(@PathVariable Long id){
        salaService.excluirSala(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> atualizarSala(@PathVariable Long id, @RequestBody @Valid SalaRequestDTO request){
        return ResponseEntity.ok().body(salaService.atualizarSala(id, request));
    }

    @GetMapping("/listar")
    ResponseEntity<List<SalaResponseDTO>> listarSalas(){
        return ResponseEntity.ok().body(salaService.listarSalas());
    }
}
