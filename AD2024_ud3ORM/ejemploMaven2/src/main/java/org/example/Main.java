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

        // Genero un estudiante
        Estudiante e = new Estudiante();
        e.setNombre("Sergio");
        e.setApellido("Castellote");
        e.setGrupo("DAM2");
        e.setNotaMedia(5);
        e.setPendiente(false);

        // Lo guardo en la BBDD
        transaction.begin();
        entityManager.persist(e);
        transaction.commit();

        //Cierro recursos
        entityManager.close();


    }
}