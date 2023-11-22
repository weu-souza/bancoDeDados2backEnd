package br.edu.ifg.bancodedados2.maiorResultado.Service;


import br.edu.ifg.bancodedados2.maiorResultado.Model.MaiorDTO;
import br.edu.ifg.bancodedados2.maiorResultado.Model.MaiorEntity;
import br.edu.ifg.bancodedados2.maiorResultado.Repository.MaiorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaiorService {
    @Autowired
    MaiorRepository maiorRepository;

    public List<MaiorDTO> maiorValor() {

        List<MaiorEntity> list = maiorRepository.findAll();
        return list.stream().map(x -> new MaiorDTO(x)).collect(Collectors.toList());
    }

}


