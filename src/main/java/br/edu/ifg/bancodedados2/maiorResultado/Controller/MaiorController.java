package br.edu.ifg.bancodedados2.maiorResultado.Controller;

import br.edu.ifg.bancodedados2.maiorResultado.Model.MaiorDTO;
import br.edu.ifg.bancodedados2.maiorResultado.Service.MaiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maior-valor")
public class MaiorController {
    @Autowired
    MaiorService maiorValorService;

    @GetMapping
    public ResponseEntity<List<MaiorDTO>> MaiorValor() {
        List<MaiorDTO> list = maiorValorService.maiorValor();
        return ResponseEntity.ok().body(list);
    }

}
