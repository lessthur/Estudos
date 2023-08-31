import entity.Passageiro;
import entity.Piloto;
import entity.Viagem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Piloto piloto = new Piloto ("Rusbé", "voo2023");

        Passageiro pass1 = new Passageiro("Igu", "12345678910");
        Passageiro pass2 = new Passageiro("Jão", "02784929128");
        Passageiro pass3 = new Passageiro("Marquin", "12394782873");
        Passageiro pass4 = new Passageiro("Leleco", "78392748290");

        //verificando erro
        Passageiro pass5 = new Passageiro("Henricuy", "02934726381");

        Viagem viagem = new Viagem(4, "Arraial do Cabo");

        viagem.setPiloto(piloto);

        viagem.setPassageiros(new ArrayList<>(List.of(pass1, pass2, pass3, pass4, pass5)));

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(viagem);

        transaction.commit();

        List <Viagem> viagens = session.createQuery("from Viagem", Viagem.class).list();

        viagens.forEach(v -> System.out.println(v));

        //Passageiro pass5 = new Passageiro("Henricuy", "02934726381");

        //viagens.get(0).addPassageiros(pass5);
    }
}
