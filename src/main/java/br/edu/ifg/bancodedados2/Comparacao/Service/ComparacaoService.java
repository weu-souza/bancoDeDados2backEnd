package br.edu.ifg.bancodedados2.Comparacao.Service;

import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoDto;
import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoEntity;
import br.edu.ifg.bancodedados2.Comparacao.Repository.ComparacaoRepository;
import br.edu.ifg.bancodedados2.Computador.Model.ComputadorDTO;
import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import br.edu.ifg.bancodedados2.Computador.Repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ComparacaoService {
    @Autowired
    private ComparacaoRepository comparacaoRepository;
    @Autowired
    ComputadorRepository computadorRepository;

    public ComparacaoDto findById(Integer id) {
        Optional<ComparacaoEntity> obj = comparacaoRepository.findById(id);
        if (obj.isPresent()) {
            ComparacaoEntity entity = obj.get();
            return new ComparacaoDto(entity);
        } else {
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

    public ComparacaoDto update(Integer id, ComparacaoDto dto) {
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

    public boolean delete(Integer id) {
        try {
            comparacaoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ComparacaoDto> findAll() {
        List<ComparacaoEntity> list = comparacaoRepository.findAll();
        return list.stream().map(x -> new ComparacaoDto(x)).collect(Collectors.toList());
    }
}
