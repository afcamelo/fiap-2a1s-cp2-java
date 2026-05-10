package fiap.com.br.cp2brinquedos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrinquedoResponse {

    private String nome;
    private String tipo;
    private String classificacao;
    private String tamanho;
    private Double preco;
}
