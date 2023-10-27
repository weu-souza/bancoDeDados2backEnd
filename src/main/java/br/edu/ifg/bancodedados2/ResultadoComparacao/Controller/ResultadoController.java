package br.edu.ifg.bancodedados2.ResultadoComparacao.Controller;

import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoDTO;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultado")
@CrossOrigin("*")
public class ResultadoController {
    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<ResultadoDTO>> comparar() {
        List<ResultadoDTO> list = resultadoService.comparar();
        return ResponseEntity.ok().body(list);
    }



}
