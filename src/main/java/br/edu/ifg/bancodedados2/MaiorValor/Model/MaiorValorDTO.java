package br.edu.ifg.bancodedados2.MaiorValor.Model;

import lombok.Data;

@Data
public class MaiorValorDTO {
    private int melhorAvaliacao;

    public MaiorValorDTO(MaiorValorEntity entity) {
        this.melhorAvaliacao = entity.getMelhorAvaliacao();
    }
}
