package br.edu.ifg.bancodedados2.MaiorValor.Repository;

import br.edu.ifg.bancodedados2.MaiorValor.Model.MaiorValorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaiorValorRepository extends JpaRepository<MaiorValorEntity, Long> {
}
