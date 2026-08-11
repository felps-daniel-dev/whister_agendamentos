package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Paciente;
import br.com.whister.whisteragendamentosapi.exception.custom.NenhumPacienteEncontrado;
import br.com.whister.whisteragendamentosapi.exception.custom.PacienteNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.PacienteMapper;
import br.com.whister.whisteragendamentosapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private PessoaService pessoaService;


    public PacienteResponseDTO buscaPacientePorId(Long id) {
        return pacienteMapper.toResponse(pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!")));
    }

    public PacienteResponseDTO novoPaciente(PacienteRequestDTO request) {

        Paciente paciente = pacienteMapper.toEntity(request);
        paciente.getPessoa().setDataCadastro(LocalDate.now());
        paciente.setAtivo(true);

        return pacienteMapper.toResponse(pacienteRepository.save(paciente));
    }

    public void excluirPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!"));
        pacienteRepository.delete(paciente);
    }


    public List<PacienteResponseDTO> listarPacientes() {
        List<Paciente> lista = pacienteRepository.findAll();

        if (lista.isEmpty()) {
            throw new NenhumPacienteEncontrado("Nenhum paciente encontrado!");
        }
        return pacienteMapper.toResponseList(lista);
    }

    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO request) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado("Paciente não encontrado!"));

        if (request.dadosPessoais() != null){
            paciente.setPessoa(pessoaService.alteraPessoa(paciente.getPessoa(), request.dadosPessoais()));
        }

        if(request.planoId() != null){
            paciente.setId(request.planoId());
        }

        return pacienteMapper.toResponse(pacienteRepository.save(paciente));
    }
}
