package br.com.whister.whisteragendamentosapi.controller;

import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaCancelamentoDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaResponseDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.RealizarConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.entity.Consulta;
import br.com.whister.whisteragendamentosapi.service.ConsultaService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> novaConsulta(@RequestBody @Valid ConsultaRequestDTO request){
        return ResponseEntity.ok().body(consultaService.novaConsulta(request));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<ConsultaResponseDTO> cancelarConsulta(@PathVariable Long id, @RequestBody ConsultaCancelamentoDTO request){
        return ResponseEntity.ok().body(consultaService.cancelarConsulta(id, request));
    }

    @PutMapping("/{id}/realizar")
    public ResponseEntity<ConsultaResponseDTO> realizarConsulta(@PathVariable Long id, @RequestBody RealizarConsultaRequestDTO request){
          return ResponseEntity.ok().body(consultaService.realizarConsulta(id, request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(consultaService.buscarPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultas(){
        return ResponseEntity.ok().body(consultaService.listarConsultas());
    }


    @GetMapping("/paciente/{id}/consulta")
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultaPorIdPaciente(@PathVariable Long id){
        return ResponseEntity.ok().body(consultaService.listarConsultaPorIdPaciente(id));
    }

    @GetMapping("/medico/{id}/consulta")
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultaPoridMedico(@PathVariable Long id){
        return ResponseEntity.ok().body(consultaService.listarConsultaPorIdMedico(id));
    }
    //fazer rotina que retorna todas as consultas do dia tanto para médicos e pacientes para questão de emails e relatorio diario para o médico
    //pensar na rotina que vai notificar o cliente
    //cauculadora de consultas

    @PostMapping("/teste/calculo/consulta")
    public ResponseEntity<ConsultaResponseDTO> testeValorConsulta(@RequestBody ConsultaRequestDTO req){
        return ResponseEntity.ok().body(consultaService.testeCalculoConsulta(req);
    }


}
