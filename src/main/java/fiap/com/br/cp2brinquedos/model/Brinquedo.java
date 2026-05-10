package fiap.com.br.cp2brinquedos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TDS_TB_Brinquedos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brinquedo_seq")
    @SequenceGenerator(name = "brinquedo_seq", sequenceName = "brinquedo_seq", allocationSize = 1)
    private Long id;

    private String nome;
    private String tipo;
    private String classificacao;
    private String tamanho;
    private Double preco;
}
