package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.medico.MedicoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.medico.MedicoResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import br.com.whister.whisteragendamentosapi.entity.Medico;
import br.com.whister.whisteragendamentosapi.exception.custom.EspecialidadeNaoEncontrada;
import br.com.whister.whisteragendamentosapi.exception.custom.MedicoNaoEncontrado;
import br.com.whister.whisteragendamentosapi.mapper.MedicoMapper;
import br.com.whister.whisteragendamentosapi.repository.EspecialidadeRepository;
import br.com.whister.whisteragendamentosapi.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {


    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    public MedicoResponseDTO buscarMedicoPorId(Long id) {
        return medicoMapper.toResponse(medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontrado("Medico não encontrado!")));
    }

    public MedicoResponseDTO novoMedico(MedicoRequestDTO request) {
        Especialidade especialidade = especialidadeRepository.findById(request.especialidadeId())
                .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidade não existe!"));

        Medico medico = medicoMapper.toEntity(request);
        medico.setEspecialidade(especialidade);

        medicoRepository.save(medico);

        return medicoMapper.toResponse(medico);
    }

    public void excluirMedico(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontrado("Medico não encontrado!"));
        medicoRepository.delete(medico);
    }

    public List<MedicoResponseDTO> listarMedico(){
        List<Medico> listaMedicos = medicoRepository.findAll();
        return medicoMapper.toListResponse(listaMedicos);
    }


    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO request) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNaoEncontrado("Médico não encontrado"));

        if(request.especialidadeId() != medico.getEspecialidade().getId()){
            Especialidade especialidade = especialidadeRepository.findById(request.especialidadeId())
                            .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidade não encontrada!"));
            medico.setEspecialidade(especialidade);
        }

        if (!request.crm().equals(medico.getCrm())){
            medico.setCrm(request.crm());
        }

        if(request.dadosPessoais() != null){
            medico.setPessoa(pessoaService.alteraPessoa(medico.getPessoa(), request.dadosPessoais()));
        }

        medicoRepository.save(medico);

        return medicoMapper.toResponse(medico);
    }
}
