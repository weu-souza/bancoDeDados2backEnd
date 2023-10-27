package br.edu.ifg.bancodedados2.Computador.Service;

import br.edu.ifg.bancodedados2.Computador.Model.ComputadorDTO;
import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import br.edu.ifg.bancodedados2.Computador.Repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputadorService {
    @Autowired
    private ComputadorRepository computadorRepository;

    public List<ComputadorDTO> findAll() {
        List<ComputadorEntity> list = computadorRepository.findAll();
        return list.stream().map(x -> new ComputadorDTO(x)).collect(Collectors.toList());
    }

    public ComputadorDTO findById(Long id) {
        Optional<ComputadorEntity> obj = computadorRepository.findById(id);
        if (obj.isPresent()) {
            ComputadorEntity entity = obj.get();
            return new ComputadorDTO(entity);
        } else {
            return null;
        }
    }

    public ComputadorDTO insert(ComputadorDTO dto) {
        ComputadorEntity entity = new ComputadorEntity(dto);
        entity = computadorRepository.save(entity);
        return new ComputadorDTO(entity);
    }

    public ComputadorDTO update(Long id, ComputadorDTO dto) {
        ComputadorEntity entity = computadorRepository.findById(id).orElse(null);
        if (entity != null) {
            entity = computadorRepository.save(new ComputadorEntity(dto));
            return new ComputadorDTO(entity);
        } else {
            return null;
        }
    }

    public boolean delete (Long id){
        try {
            Optional<ComputadorEntity> obj = computadorRepository.findById(id);
            computadorRepository.deleteById(id);
            return true;
        }
        catch (Exception e ){
            return false;
        }
    }

}
