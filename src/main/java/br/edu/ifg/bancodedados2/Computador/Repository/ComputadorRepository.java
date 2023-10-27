package br.edu.ifg.bancodedados2.Computador.Repository;

import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComputadorRepository extends JpaRepository<ComputadorEntity, Long> {

}
