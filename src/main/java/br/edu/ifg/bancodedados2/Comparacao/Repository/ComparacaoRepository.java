package br.edu.ifg.bancodedados2.Comparacao.Repository;

import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoEntity;
import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComparacaoRepository extends JpaRepository<ComparacaoEntity, Long> {


    List<ComparacaoEntity> findByComputador(ComputadorEntity computador);


}
