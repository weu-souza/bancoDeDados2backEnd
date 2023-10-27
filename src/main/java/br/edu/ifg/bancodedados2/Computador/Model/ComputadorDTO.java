package br.edu.ifg.bancodedados2.Computador.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComputadorDTO {
    private long id;
    private String nome;
    private String descricao;

    public ComputadorDTO(ComputadorEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

}
