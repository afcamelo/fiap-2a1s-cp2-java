package fiap.com.br.cp2brinquedos.service;

import fiap.com.br.cp2brinquedos.dto.BrinquedoDto;
import fiap.com.br.cp2brinquedos.dto.BrinquedoResponse;
import fiap.com.br.cp2brinquedos.exception.ResourceNotFoundException;
import fiap.com.br.cp2brinquedos.mapper.BrinquedoMapper;
import fiap.com.br.cp2brinquedos.model.Brinquedo;
import fiap.com.br.cp2brinquedos.repository.BrinquedoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BrinquedoService {

    private final BrinquedoRepository repository;
    private final BrinquedoMapper mapper;

    public List<BrinquedoResponse> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public BrinquedoResponse buscarPorId(Long id) {
        Brinquedo brinquedo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brinquedo não encontrado com id: " + id));
        return mapper.toResponse(brinquedo);
    }

    public BrinquedoResponse criar(BrinquedoDto dto) {
        return mapper.toResponse(repository.save(mapper.toEntity(dto)));
    }

    public BrinquedoResponse atualizar(Long id, BrinquedoDto dto) {
        Brinquedo brinquedo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brinquedo não encontrado com id: " + id));
        mapper.updateEntityFromDto(dto, brinquedo);
        return mapper.toResponse(repository.save(brinquedo));
    }

    public String deletar(Long id) {
        Brinquedo brinquedo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brinquedo não encontrado com id: " + id));
        repository.deleteById(id);
        return "O produto " + brinquedo.getNome() + " de id " + id + " foi excluido com sucesso.";
    }
}
