package br.edu.ifg.bancodedados2.MaiorValor.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "maior_valor")
@NoArgsConstructor
public class MaiorValorEntity {
   @Id
    private int melhorAvaliacao;

    public MaiorValorEntity(MaiorValorDTO dto) {
        this.melhorAvaliacao = dto.getMelhorAvaliacao();
    }


}
