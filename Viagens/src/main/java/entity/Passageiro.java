package entity;

import jakarta.persistence.*;

@Entity
@Table

public class Passageiro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String CPF;

    @Column
    private String nome;

    public Passageiro(String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id=" + id +
                ", CPF='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
