package fiap.com.br.cp2brinquedos.controller;

import fiap.com.br.cp2brinquedos.dto.BrinquedoDto;
import fiap.com.br.cp2brinquedos.dto.BrinquedoResponse;
import fiap.com.br.cp2brinquedos.service.BrinquedoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
@RequiredArgsConstructor
public class BrinquedoController {

    private final BrinquedoService service;

    @GetMapping
    public ResponseEntity<List<BrinquedoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrinquedoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<BrinquedoResponse> criar(@Valid @RequestBody BrinquedoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrinquedoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody BrinquedoDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletar(id));
    }
}
