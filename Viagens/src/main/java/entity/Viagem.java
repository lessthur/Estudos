package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class Viagem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "piloto_id")
    private Piloto piloto;

    @Column
    private Integer vagas;

    @ManyToMany (cascade = CascadeType.ALL)
    //Muitos para muitos requer a criação de uma tabela própria, portanto, segue a criação de uma:
    @JoinTable (name = "viagem_passageiros", joinColumns = @JoinColumn (name = "viagem_id"), inverseJoinColumns = @JoinColumn (name = "passageiros_id"))
    //inverseJoinColumns = chama a tabela oposta que se relacionará com a tabela referente a classe, no caso (viagem = tab. classe) (passageiros = tab. oposta)
    private List <Passageiro> passageiros;

    @Column
    private String destino;

    public Viagem(Integer vagas,String destino) {
        this.vagas = vagas;
        this.destino = destino;
        this.passageiros = new ArrayList<>();
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        if (passageiros.size() > vagas)
            System.out.println("Limite de vagas excedido. Essa viagem possui apenas " + this.vagas + " vagas.");
        else
            this.passageiros = passageiros;
    }

    public void addPassageiros(Passageiro passageiro){
        if (this.passageiros.size() < vagas){
            this.passageiros.add(passageiro);
        }else {
            System.out.println("Limite de vagas atingido seu otario.");
        }
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", piloto=" + piloto +
                ", vagas=" + vagas +
                ", passageiros=" + passageiros +
                ", destino='" + destino + '\'' +
                '}';
    }
}
