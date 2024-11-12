import Model.Cliente;
import Model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Insertar un cliente y un producto
        transaction.begin();
        Cliente c1 = new Cliente("Eduardo","Calle Batalla de Lepanto 30","Zaragoza","123456789","11111111H");
        entityManager.persist(c1);
        Producto p1 = new Producto("Un teclado mecanico",10,2,80.5f);
        entityManager.persist(p1);
        transaction.commit();

        //Modificar un cliente y un producto
        transaction.begin();
        c1.setNombre("Marisa");
        p1.setPrecio(49.99f);
        transaction.commit();

        // Eliminar cliente y producto
        transaction.begin();
        entityManager.remove(c1);
        entityManager.remove(p1);
        transaction.commit();

        // Listar todos los clientes
        Cliente c2 = new Cliente("Javier","Calle Cadiz 30","Zaragoza","123456789","2222222M");
        Cliente c3 = new Cliente("Edurne","Calle Batalla de Lepanto 29","Zaragoza","123456789","3333333J");
        Cliente c4 = new Cliente("Juana","Calle Batalla de Lepanto 28","Zaragoza","123456789","44444444X");
        Cliente c5 = new Cliente("Paco","Calle Batalla de Lepanto 27","Zaragoza","123456789","666666666X");
        transaction.begin();
        entityManager.persist(c2);entityManager.persist(c3);entityManager.persist(c4);entityManager.persist(c5);

        List clientes =
                entityManager.createNativeQuery("select * from Clientes", Cliente.class)
                .getResultList();

        for(Object c: clientes){
            System.out.println(c);
        }

        transaction.commit();

        // Listar todos los productos


        entityManager.close();

    }
}
