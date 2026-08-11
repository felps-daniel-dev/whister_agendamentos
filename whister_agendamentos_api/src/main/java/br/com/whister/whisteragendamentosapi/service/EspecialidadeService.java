package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import br.com.whister.whisteragendamentosapi.exception.custom.EspecialidadeNaoEncontrada;
import br.com.whister.whisteragendamentosapi.mapper.EspecialidadeMapper;
import br.com.whister.whisteragendamentosapi.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private EspecialidadeMapper especialidadeMapper;

    public EspecialidadeResponseDTO novaEspecialidade(EspecialidadeRequestDTO request) {
        Especialidade especialidade = especialidadeMapper.toEntity(request);

        especialidadeRepository.save(especialidade);

        return especialidadeMapper.toResponse(especialidade);
    }

    public EspecialidadeResponseDTO buscarPorId(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidade não encontrada!"));

        return especialidadeMapper.toResponse(especialidade);
    }

    public List<EspecialidadeResponseDTO> listarEspecialidades() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        return especialidadeMapper.toResponseList(especialidades);
    }

    public void excluirEspecialidade(Long id) {

        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidae não encontrada!"));

        especialidadeRepository.deleteById(id);
    }

    public EspecialidadeResponseDTO atualizarEspecialidade(Long id, EspecialidadeRequestDTO request) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new EspecialidadeNaoEncontrada("Especialidade não encontrada!"));

        if (!request.nome().equals(especialidade.getNome())) {
            especialidade.setNome(request.nome());
        }

        if (!request.duracao().equals(especialidade.getDuracao())) {
            especialidade.setDuracao(request.duracao());
        }

        if (!request.intervalo().equals(especialidade.getIntervalo())) {
            especialidade.setIntervalo(request.intervalo());
        }

        if (!request.descontoPromocional().equals(especialidade.getDescontoPromocional())) {
            especialidade.setDescontoPromocional(request.descontoPromocional());
        }

        if (!request.porcentagemEspecial().equals(especialidade.getPorcentagemEspecial())) {
            especialidade.setPorcentagemEspecial(request.porcentagemEspecial());
        }

        especialidadeRepository.save(especialidade);

        return especialidadeMapper.toResponse(especialidade);
    }
}
