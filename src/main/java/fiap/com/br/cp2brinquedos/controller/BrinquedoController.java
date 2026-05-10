package fiap.com.br.cp2brinquedos.controller;

import fiap.com.br.cp2brinquedos.dto.BrinquedoDto;
import fiap.com.br.cp2brinquedos.dto.BrinquedoResponse;
import fiap.com.br.cp2brinquedos.service.BrinquedoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
@RequiredArgsConstructor
public class BrinquedoController {

    private final BrinquedoService service;

    @GetMapping
    public List<BrinquedoResponse> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public BrinquedoResponse buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrinquedoResponse criar(@Valid @RequestBody BrinquedoDto dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}")
    public BrinquedoResponse atualizar(@PathVariable Long id, @Valid @RequestBody BrinquedoDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
