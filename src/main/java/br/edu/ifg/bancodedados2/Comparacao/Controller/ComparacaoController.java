package br.edu.ifg.bancodedados2.Comparacao.Controller;


import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoDto;

import br.edu.ifg.bancodedados2.Comparacao.Service.ComparacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comparar")
@CrossOrigin("*")
public class ComparacaoController {
    @Autowired
    private ComparacaoService comparacaoService;

    @GetMapping(value = "/computador/{id}")
    public ResponseEntity<List<ComparacaoDto>> findByComputador(@PathVariable Long id) {
        List<ComparacaoDto> list = comparacaoService.findByComputador(id);
        if (list != null) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<ComparacaoDto> insert(@PathVariable Long id, @RequestBody ComparacaoDto dto) {
        dto = comparacaoService.insert(dto, id);
        if (dto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComparacaoDto> update(@PathVariable Long id, @RequestBody ComparacaoDto dto) {
        dto = comparacaoService.update(id, dto);
        if (dto != null) {
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComparacaoDto> delete(@PathVariable Long id) {
        if (comparacaoService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
