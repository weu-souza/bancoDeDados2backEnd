package br.edu.ifg.bancodedados2.MaiorValor.Controller;

import br.edu.ifg.bancodedados2.MaiorValor.Model.MaiorValorDTO;
import br.edu.ifg.bancodedados2.MaiorValor.Service.MaiorValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maior-valor")
@CrossOrigin("*")
public class MaiorValorController {
    @Autowired
    MaiorValorService maiorValorService;

    @GetMapping
    public ResponseEntity<List<MaiorValorDTO>> MaiorValor() {
        List<MaiorValorDTO> list = maiorValorService.maiorValor();
        return ResponseEntity.ok().body(list);
    }
}
