package entity;

import jakarta.persistence.*;

@Entity
@Table

public class Piloto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codAutorizacao;

    @Column
    private String nome;

    public Piloto(String codAutorizacao, String nome) {
        this.codAutorizacao = codAutorizacao;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodAutorizacao() {
        return codAutorizacao;
    }

    public void setCodAutorizacao(String codAutorizacao) {
        this.codAutorizacao = codAutorizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", codAutorizacao='" + codAutorizacao + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
