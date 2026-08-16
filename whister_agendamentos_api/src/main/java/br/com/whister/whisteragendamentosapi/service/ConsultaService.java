package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.controller.ConsultaController;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaCancelamentoDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaResponseDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.RealizarConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.entity.*;
import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import br.com.whister.whisteragendamentosapi.exception.custom.ConsultaNaoEncontrada;
import br.com.whister.whisteragendamentosapi.exception.custom.MedicoNaoEncontrado;
import br.com.whister.whisteragendamentosapi.exception.custom.PacienteNaoEncontrado;
import br.com.whister.whisteragendamentosapi.exception.custom.SalaNaoEncontrada;
import br.com.whister.whisteragendamentosapi.mapper.ConsultaMapper;
import br.com.whister.whisteragendamentosapi.repository.ConsultaRepository;
import br.com.whister.whisteragendamentosapi.repository.MedicoRepository;
import br.com.whister.whisteragendamentosapi.repository.PacienteRepository;
import br.com.whister.whisteragendamentosapi.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    private final SalaRepository salaRepository;

    private final ConsultaRepository consultaRepository;

    private final ConsultaMapper consultaMapper;

    private final LogConsultaService logService;


    public ConsultaResponseDTO realizarConsulta(Long id, RealizarConsultaRequestDTO request) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNaoEncontrada("Consulta não encontrada!"));

        if (!request.motivoPrevio().equals(consulta) && !request.motivoPrevio().isEmpty()) {
            consulta.setMotivoPrevio(request.motivoPrevio());
        }

        if (!request.resultadoConsulta().isEmpty()) {
            consulta.setResultadoConsulta(request.resultadoConsulta());
        }

        consultaRepository.save(consulta);

        logService.alteraLog(consulta);

        return consultaMapper.toResponse(consulta);
    }

    public ConsultaResponseDTO novaConsulta(ConsultaRequestDTO request) {

        Medico medico = medicoRepository.findById(request.medicoId())
                .orElseThrow(() -> new MedicoNaoEncontrado("Este Médico não foi registrado!"));

        Paciente paciente = pacienteRepository.findById(request.pacienteId())
                .orElseThrow(() -> new PacienteNaoEncontrado("Este Paciente não foi registrado"));

        Sala sala = salaRepository.findById(request.salaId())
                .orElseThrow(() -> new SalaNaoEncontrada("Esta sala não foi registrada!"));

        Consulta consulta = Consulta.builder()
                .medico(medico)
                .paciente(paciente)
                .sala(sala)
                .dataHora(request.dataHora())
                .valorBruto(request.valorBruto())
                .motivoPrevio(request.motivoPrevio())
                .especial(request.especial())
                .status(StatusConsulta.AGUARDANDO)
                .motivoCancelamento(request.motivoCancelamento())
                .criadoEm(LocalDate.now())
                .atualizadoEm(LocalDate.now())
                .build();

        consultaRepository.save(consulta);

        logService.novoLog(consulta);

        return consultaMapper.toResponse(consulta);
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNaoEncontrada("Consulta não encontrada!"));
        return consultaMapper.toResponse(consulta);
    }

    public ConsultaResponseDTO cancelarConsulta(Long id, ConsultaCancelamentoDTO request) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ConsultaNaoEncontrada("Esta consulta não existe!"));

        if (consulta.getMotivoCancelamento() == null || !consulta.getMotivoCancelamento().equals(request.motivoCancelamento())) {
            consulta.setMotivoCancelamento(request.motivoCancelamento());
            consulta.setStatus(StatusConsulta.CANCELADA);

            consultaRepository.save(consulta);
        }

        logService.alteraLog(consulta);

        return consultaMapper.toResponse(consulta);
    }

    public List<ConsultaResponseDTO> listarConsultas() {
        List<Consulta> listaConsulta = consultaRepository.findAll();
        return consultaMapper.toResponseList(listaConsulta);
    }

    public List<ConsultaResponseDTO> listarConsultaPorIdPaciente(Long id) {
        List<Consulta> listaConsultas = consultaRepository.findByPacienteId(id);
        return consultaMapper.toResponseList(listaConsultas);
    }

    public List<ConsultaResponseDTO> listarConsultaPorIdMedico(Long id) {
        List<Consulta> listaConsultas = consultaRepository.findByMedicoId(id);
        return consultaMapper.toResponseList(listaConsultas);
    }

    @Autowired
    private Calculadora calc;

    public ConsultaResponseDTO testeCalculoConsulta(ConsultaRequestDTO req) {
        Consulta consulta = consultaMapper.toEntity(req);
        // o BO ta na consulta mapper que não esta passando os valores


        consulta.setCriadoEm(LocalDate.now());
        consulta.setAtualizadoEm(LocalDate.now());
        consultaRepository.save(consulta);

        calc.calculaValorConsulta(consulta);

        consultaRepository.save(consulta);

        return consultaMapper.toResponse(consulta);
    }
}
