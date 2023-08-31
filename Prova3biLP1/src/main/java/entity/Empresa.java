package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Empresa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "dono_id")
    private Dono dono;

    @Column
    private String nome;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "empresa_id")
    private List <Filial> filiais;

    public Empresa(String nome) {
        this.dono = dono;
        this.nome = nome;
        this.filiais = new ArrayList<>();
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public List<Filial> getFiliais() {
        return filiais;
    }

    public void setFiliais(List<Filial> filiais) {
        if ((filiais.size() * 1000000) > dono.getInvestimento()) {
            System.out.println("Limite de investimento excedido. " + dono.getNome() + ", cada empresa tem o valor fixo de R$1.000.000, você pode investir apenas se possuir o valor da soma do custo do número de empresas.");
        } else {
            System.out.println("Olá " + dono.getNome() + ", o seu investimento foi realizado com sucesso!");
            this.filiais = filiais;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addFilial(Filial filial){
        if ((filiais.size() * 1000000 > getDono().getInvestimento()))
            System.err.println("O investimento não pode exceder a soma dos custo das filiais.");
        else
            this.filiais.add(filial);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", dono=" + dono +
                ", nome='" + nome + '\'' +
                ", filiais=" + filiais +
                '}';
    }
}
