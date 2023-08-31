import entity.Empresa;
import entity.Gerente;
import entity.Dono;
import entity.Filial;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dono dono = new Dono("Joca", 1100000.00);

        Gerente gerente1 = new Gerente("Arthur", "38492018952", 3500.00);
        Gerente gerente2 = new Gerente("Iguuu", "92825864712", 5700.98);

        Filial filial1 = new Filial("FilialSP", gerente1);
        Filial filial2 = new Filial("FilialGRU", gerente2);

        Empresa empresa = new Empresa("empresaTutu");

        empresa.setDono(dono);

        empresa.addFilial(filial2);

        empresa.setFiliais(new ArrayList<>(List.of(filial1,filial2)));

        filial1.setGerente(gerente1);
        filial2.setGerente(gerente2);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(empresa);

        transaction.commit();

        List <Empresa> empresas = session.createQuery("from Empresa", Empresa.class).list();

        for (Empresa e: empresas){
            System.out.println(e);
        }

    }
}
