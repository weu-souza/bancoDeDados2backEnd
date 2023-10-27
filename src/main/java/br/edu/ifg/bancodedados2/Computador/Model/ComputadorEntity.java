package br.edu.ifg.bancodedados2.Computador.Model;

import br.edu.ifg.bancodedados2.Comparacao.Model.ComparacaoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "computador")
@NoArgsConstructor
public class ComputadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "computador")
    private List<ComparacaoEntity> comparacaoFk = new ArrayList<>();


    public ComputadorEntity(ComputadorDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
    }



}
