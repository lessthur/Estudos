package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Dono {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private double investimento;

    public Dono(String nome, double investimento) {
        this.nome = nome;
        this.investimento = investimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }

    @Override
    public String toString() {
        return "Dono{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", investimento=" + investimento +
                '}';
    }
}
