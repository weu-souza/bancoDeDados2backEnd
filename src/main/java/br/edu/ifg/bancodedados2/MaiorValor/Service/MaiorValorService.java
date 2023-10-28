package br.edu.ifg.bancodedados2.MaiorValor.Service;

import br.edu.ifg.bancodedados2.MaiorValor.Model.MaiorValorDTO;
import br.edu.ifg.bancodedados2.MaiorValor.Model.MaiorValorEntity;
import br.edu.ifg.bancodedados2.MaiorValor.Repository.MaiorValorRepository;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoDTO;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaiorValorService {
@Autowired
    MaiorValorRepository maiorValorRepository;

    public List<MaiorValorDTO> maiorValor() {

        List<MaiorValorEntity> list = maiorValorRepository.findAll();
        return list.stream().map(x -> new MaiorValorDTO(x)).collect(Collectors.toList());
    }
}
