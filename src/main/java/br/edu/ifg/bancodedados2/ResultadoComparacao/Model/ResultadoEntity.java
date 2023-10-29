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
    private String nome;
    private int resultado;

    public ResultadoEntity(ResultadoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.resultado = dto.getResultado();
    }
}
