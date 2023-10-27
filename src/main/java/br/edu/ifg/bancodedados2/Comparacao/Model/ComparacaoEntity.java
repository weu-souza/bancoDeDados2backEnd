package br.edu.ifg.bancodedados2.Comparacao.Model;

import br.edu.ifg.bancodedados2.Computador.Model.ComputadorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@Table(name = "comparacao")
@NoArgsConstructor
public class ComparacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int processadorPeso;
    @NotNull
    private int placaDeVideoPeso;
    @NotNull
    private int memoriaRamPeso;
    @NotNull
    private int processadorNota;
    @NotNull
    private int placaDeVideoNota;
    @NotNull
    private int memoriaRamNota;
    @ManyToOne
    @JoinColumn(name = "computador_id")
    private ComputadorEntity computador;

    public ComparacaoEntity(ComparacaoDto dto) {
        this.memoriaRamNota = dto.getMemoriaRamNota();
        this.memoriaRamPeso = dto.getMemoriaRamPeso();
        this.placaDeVideoNota = dto.getPlacaDeVideoNota();
        this.placaDeVideoPeso = dto.getPlacaDeVideoPeso();
        this.processadorNota = dto.getProcessadorNota();
        this.processadorPeso = dto.getProcessadorPeso();

    }
}


