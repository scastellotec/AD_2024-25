import Model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Mapeo la unidad de persistencia declarada
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa-hibernate-mysql");

        // Creo el objeto Entity Manager para gestionar las entidades de esa BBDD
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Inicio una transacción
        entityManager.getTransaction().begin();

        // Inserta varios un empleados
        Empleado e1 = new Empleado();
        e1.setApellido("Winchester");
        e1.setComision(10f);
        e1.setSalario(25000f);
        e1.setFechAlta(new Date());
        e1.setOficio("Programador");
        entityManager.persist(e1);

        entityManager.persist(new Empleado("Larraga", "Diseñador",new Date(), 20000f, 3f));
        entityManager.persist(new Empleado("Lechuga", "Seguridad",new Date(), 23000f, 0.0f));
        entityManager.persist(new Empleado("Mandril", "Jefe de proyecto",new Date(), 35000f, 1.5f));
        entityManager.persist(new Empleado("Garcia", "Comercial",new Date(), 15000f, 50f));

        //Buscad un empleado por su clave primaria
        Empleado empleadoBuscado = entityManager.find(Empleado.class, 3);
        System.out.println(empleadoBuscado.toString());

        // Eliminar un empleado
        entityManager.remove(empleadoBuscado);

        // Busar todos los empleados
        List<Empleado> empleados =
                entityManager.createNativeQuery("select * from empleados", Empleado.class)
                        .getResultList();

        for(Empleado e: empleados){
            System.out.println(e.toString());
        }
        //empleados.forEach(x -> System.out.println(x.toString()));

        // Buscar solo empleados con una condicion
        List<Empleado> empleadosPudientes =
                entityManager.createNativeQuery("select * from empleados where salario > 24000", Empleado.class)
                        .getResultList();

        for(Empleado e: empleadosPudientes){
            System.out.println(e.toString());
        }

        // Modificar un empleado
        Empleado empleadoBuscado2 = entityManager.find(Empleado.class, 4);
        empleadoBuscado2.setApellido("Calvo");

        // Finalizo transacción
        entityManager.getTransaction().commit();

        // Finalizo la sesion de persistencia
        entityManager.close();

    }
}
