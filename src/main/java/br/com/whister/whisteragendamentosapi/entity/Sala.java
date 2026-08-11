package br.com.whister.whisteragendamentosapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "update sala set ativo = false where id = ?")
@SQLRestriction("ativo = true")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_sala", nullable = false, unique = true)
    private String numeroSala;

    @Column(nullable = false)
    private Boolean disponivelNoMomento = true;

    private Boolean ativo = true;
}
