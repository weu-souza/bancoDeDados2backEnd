package br.edu.ifg.bancodedados2.ResultadoComparacao.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoDTO {

    private long id;
    private String nome;
    private int resultado;

    public ResultadoDTO(ResultadoEntity entity) {
        this.nome = entity.getNome();
        this.id = entity.getId();
        this.resultado = entity.getResultado();
    }
}
