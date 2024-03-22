package model;
import lombok.*;

import jakarta.persistence.*;

//construtor padrão
@NoArgsConstructor
//construtor com todos os parâmetros, na ordem de declaração
@AllArgsConstructor
//quando aplicados a uma classe
//geram getters/setters para todos os campos não marcados como
@Getter
@Setter
@Entity
public class Livro {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private int edicao;
}