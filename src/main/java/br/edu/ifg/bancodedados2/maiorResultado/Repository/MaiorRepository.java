package br.edu.ifg.bancodedados2.maiorResultado.Repository;

import br.edu.ifg.bancodedados2.maiorResultado.Model.MaiorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaiorRepository extends JpaRepository<MaiorEntity,Long> {
}
