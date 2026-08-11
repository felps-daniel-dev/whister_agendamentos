package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.sala.SalaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.sala.SalaResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Sala;
import br.com.whister.whisteragendamentosapi.exception.custom.SalaNaoEncontrada;
import br.com.whister.whisteragendamentosapi.mapper.SalaMapper;
import br.com.whister.whisteragendamentosapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
     private SalaMapper salaMapper;


    public SalaResponseDTO buscarPorId(Long id){
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNaoEncontrada("Sala não Encontrada!"));

        return salaMapper.toResponse(sala);
    }

    public SalaResponseDTO novaSala(SalaRequestDTO request) {
        Sala sala = salaMapper.toEntity(request);

        salaRepository.save(sala);

        return salaMapper.toResponse(sala);
    }

    public void excluirSala(Long id) {
        Sala sala = salaRepository.findById(id)
                        .orElseThrow(() -> new SalaNaoEncontrada("Sala não encontrada!"));
        salaRepository.delete(sala);
    }

    public SalaResponseDTO atualizarSala(Long id, SalaRequestDTO request){
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNaoEncontrada("Sala não encontrada!"));

        if(!sala.getNumeroSala().equals(request.numeroSala())){
            sala.setNumeroSala(request.numeroSala());
        }

        if (!sala.getDisponivelNoMomento().equals(request.disponivelNoMomento())){
            sala.setDisponivelNoMomento(request.disponivelNoMomento());
        }

        salaRepository.save(sala);

        return salaMapper.toResponse(sala);
    }

    public List<SalaResponseDTO> listarSalas() {
        List<Sala> salas = salaRepository.findAll();
        return salaMapper.toResponseList(salas);
    }
}
