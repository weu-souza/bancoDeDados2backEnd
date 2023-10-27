package br.edu.ifg.bancodedados2.ResultadoComparacao.Service;


import br.edu.ifg.bancodedados2.Computador.Repository.ComputadorRepository;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoDTO;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoEntity;
import br.edu.ifg.bancodedados2.ResultadoComparacao.Repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ResultadoService {
    @Autowired
    ResultadoRepository resultadoRepository;
    @Autowired
    ComputadorRepository computadorRepository;


    public List<ResultadoDTO> comparar() {

        List<ResultadoEntity> list = resultadoRepository.findAll();
        return list.stream().map(x -> new ResultadoDTO(x)).collect(Collectors.toList());
    }

}
