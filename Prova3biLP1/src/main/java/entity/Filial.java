package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Filial {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    public Filial(String nome, Gerente gerente) {
        this.nome = nome;
        this.gerente = gerente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", gerente=" + gerente +
                '}';
    }
}
