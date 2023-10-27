package br.edu.ifg.bancodedados2.ResultadoComparacao.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resultadoV")
@NoArgsConstructor
public class ResultadoEntity {
    @Id
    private long id;
    @NotNull
    private String nome;
    private String descricao;
    @NotNull
    private int resultado;

    public ResultadoEntity(ResultadoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.resultado = dto.getResultado();
        this.descricao = dto.getDescricao();
    }

    public ResultadoEntity(long id, @NotNull String nome, String descricao, @NotNull int resultado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.resultado = resultado;
    }
}
