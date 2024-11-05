package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.Model.Estudiante;

public class Main {
    public static void main(String[] args) {

        // Invoco los entityManager para poder guardar
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        // Lo guardo en la BBDD
        transaction.begin();
        Estudiante eSergio = entityManager.find(Estudiante.class, "2");
        eSergio.setNotaMedia(10);
        entityManager.remove(eSergio);
        transaction.commit();

        transaction.begin();
        eSergio.setNombre("Maria");
        entityManager.merge(eSergio);
        transaction.commit();

        //Cierro recursos
        entityManager.close();


    }
}