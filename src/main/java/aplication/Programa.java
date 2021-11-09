package aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.Session;

import dminio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(1,"daniel","daniel@gmail");
		Pessoa p2 = new Pessoa(null,"samuel","samuel@gmail");
		Pessoa p3 = new Pessoa(null,"israel","israel@gmail");
		Pessoa p4 = new Pessoa(null,"ruthelle","ruthe@gmail");
		
		//criando a conexao
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		//conexao com banco de dados estabelecida e persistencia estabelecida
		EntityManager em = emf.createEntityManager();
		//inicar uma transação
		em.getTransaction().begin();
		//inserindo pessoas
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		//salvando as transaçoes
		em.getTransaction().commit();
		System.out.println("Done!");
		
		//buscar elementos pelo id
		Pessoa p5 = em.find(Pessoa.class, 2);
		System.out.println(p5);
		//removendo dados
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("removido"+p);
		
		
		
		em.close();
		emf.close();
		
		

	}

}
