package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeResponseDTO;
import br.com.whister.whisteragendamentosapi.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidade")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;


    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> novaEspecialidade(@RequestBody EspecialidadeRequestDTO request){
        return ResponseEntity.ok().body(especialidadeService.novaEspecialidade(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO>  buscarEspecialidadePoriD(@PathVariable Long id){
        return ResponseEntity.ok().body(especialidadeService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEspecialidade(@PathVariable Long id){
        especialidadeService.excluirEspecialidade(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EspecialidadeResponseDTO>> listarEspecialidades(){
        return ResponseEntity.ok().body(especialidadeService.listarEspecialidades());
    }


    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> atualizarEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeRequestDTO request){
        return  ResponseEntity.ok().body(especialidadeService.atualizarEspecialidade(id, request));
    }

}
