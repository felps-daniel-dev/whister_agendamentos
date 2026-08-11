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
@SQLDelete(sql = "update Medico set ativo = false where id = ?")
@SQLRestriction("ativo = true")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 13, nullable = false, unique = true)
    private String crm;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Pessoa pessoa;

    @ManyToOne
    private Especialidade especialidade;

    private Boolean ativo = true;

}
