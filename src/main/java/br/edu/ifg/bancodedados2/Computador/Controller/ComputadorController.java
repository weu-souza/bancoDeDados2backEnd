package br.edu.ifg.bancodedados2.Computador.Controller;

import br.edu.ifg.bancodedados2.Computador.Model.ComputadorDTO;
import br.edu.ifg.bancodedados2.Computador.Service.ComputadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/computador")
@CrossOrigin("*")
public class ComputadorController {
    @Autowired
    private ComputadorService computadorService;

    @GetMapping
    public ResponseEntity<List<ComputadorDTO>> findAll() {
        List<ComputadorDTO> list = computadorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComputadorDTO> findById(@PathVariable Long id) {
        ComputadorDTO dto = computadorService.findById(id);
        if (dto != null) {
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ComputadorDTO> insert(@RequestBody ComputadorDTO dto) {
        try {
            dto = computadorService.insert(dto);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComputadorDTO> update(@PathVariable Long id, @RequestBody ComputadorDTO dto) {
        dto = computadorService.update(id, dto);
        if (dto != null) {
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ComputadorDTO> delete(@PathVariable Long id) {
        if (computadorService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
