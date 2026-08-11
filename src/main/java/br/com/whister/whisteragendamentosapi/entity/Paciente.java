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

@SQLDelete(sql = "update Paciente set ativo = false where id = ? ")
@SQLRestriction("ativo = true")// retorna registro com where ativo = true
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // não é o ALL porque se for o all ele excluir a pessoa, mas sem o remove que fica no all ele não apaga a pessoa quando excluir o paciente
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    private Plano plano;

    private Boolean ativo = true;
}
