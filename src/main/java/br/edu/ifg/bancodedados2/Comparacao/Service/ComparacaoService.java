package br.edu.ifg.bancodedados2.Comparacao.Service;

import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoDto;
import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoEntity;
import br.edu.ifg.bancodedados2.Comparacao.Repository.ComparacaoRepository;
import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import br.edu.ifg.bancodedados2.Computador.Repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ComparacaoService {
    @Autowired
    private ComparacaoRepository comparacaoRepository;
    @Autowired
    ComputadorRepository computadorRepository;

    public List<ComparacaoDto> findByComputador(Long id) {
        try {
            ComputadorEntity computador = computadorRepository.findById(id).orElse(null);
            List<ComparacaoEntity> list = comparacaoRepository.findByComputador(computador);
            return list.stream().map(x -> new ComparacaoDto(x)).collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    public ComparacaoDto insert(ComparacaoDto dto, long id) {
        try {
            ComparacaoEntity entity = new ComparacaoEntity(dto);
            ComputadorEntity computador = computadorRepository.findById(id).orElse(null);
            entity.setComputador(computador);
            entity = comparacaoRepository.save(entity);
            return new ComparacaoDto(entity);

        } catch (Exception e) {
            return null;
        }
    }

    public ComparacaoDto update(Long id, ComparacaoDto dto) {
        ComparacaoEntity entity = comparacaoRepository.findById(id).orElse(null);
        if (entity != null) {
            ComparacaoEntity toSave = new ComparacaoEntity(dto);
            toSave.setComputador(entity.getComputador());
            entity = comparacaoRepository.save(toSave);
            return new ComparacaoDto(entity);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            comparacaoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
