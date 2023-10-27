package br.edu.ifg.bancodedados2.ResultadoComparacao.Repository;

import br.edu.ifg.bancodedados2.ResultadoComparacao.Model.ResultadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<ResultadoEntity, Long> {
}
