package br.edu.ifg.bancodedados2.maiorResultado.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MaiorDTO {
    private int melhorAvaliacao;

    public MaiorDTO(MaiorEntity entity) {
        this.melhorAvaliacao = entity.getMelhorAvaliacao();
    }
}
