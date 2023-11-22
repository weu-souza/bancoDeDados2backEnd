package br.edu.ifg.bancodedados2.maiorResultado.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "maior_valor")
@NoArgsConstructor
public class MaiorEntity {
    @Id
    private int melhorAvaliacao;

    public MaiorEntity(MaiorDTO dto) {
        this.melhorAvaliacao = dto.getMelhorAvaliacao();
    }
}
