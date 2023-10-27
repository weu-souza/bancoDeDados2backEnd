package br.edu.ifg.bancodedados2.Comparacao.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComparacaoDto {
    private long id;
    private int processadorPeso;

    private int placaDeVideoPeso;

    private int memoriaRamPeso;

    private int processadorNota;

    private int placaDeVideoNota;

    private int memoriaRamNota;

    public ComparacaoDto(ComparacaoEntity entity) {
        this.memoriaRamNota = entity.getMemoriaRamNota();
        this.memoriaRamPeso = entity.getMemoriaRamPeso();
        this.placaDeVideoNota = entity.getPlacaDeVideoNota();
        this.placaDeVideoPeso = entity.getPlacaDeVideoPeso();
        this.processadorNota = entity.getProcessadorNota();
        this.processadorPeso = entity.getProcessadorPeso();

    }
}
