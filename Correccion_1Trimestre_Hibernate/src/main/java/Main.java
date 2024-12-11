import Model.Categoria;
import Model.Cliente;
import Model.Producto;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Productos
        Producto p1 = new Producto("Zapatos", 15.3);
        Producto p2 = new Producto("Camiseta", 25.3);
        Producto p3 = new Producto("Teclado", 35.3);

        // Categoria
        Categoria c1 = new Categoria("Ropa");
        Categoria c2 = new Categoria("Electronica");

        // Clientes
        Cliente cli1 = new Cliente("Eduardo");
        Cliente cli2 = new Cliente("Teresa");

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(c1);
        entityManager.persist(c2);

        p1.setCategoria(c1);
        p2.setCategoria(c1);
        p3.setCategoria(c2);

        entityManager.persist(cli1);
        entityManager.persist(cli2);

        p1.addCliente(cli1);
        p2.addCliente(cli1);
        p3.addCliente(cli2);


        List<Producto> productosRopa =  entityManager.createNativeQuery("select * from Productos where categoria_id  = 1", Producto.class).getResultList();

        for(Producto p: productosRopa){
            System.out.println(p);
        }

        transaction.commit();
        entityManager.close();
    }
}
