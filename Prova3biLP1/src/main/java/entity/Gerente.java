package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Gerente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String CPF;

    @Column
    private double salario;

    public Gerente(String nome, String CPF, double salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", salario=" + salario +
                '}';
    }
}
