import Model.Departamento;
import Model.Empleado;
import Model.Proyecto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-empresa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // Inicio transaccion
        transaction.begin();

        // EMPLEDAOS
        Empleado e1 = new Empleado();
        e1.setNombre("Sergio");
        entityManager.persist(e1);

        Empleado e2 = new Empleado();
        e2.setNombre("Andres");
        entityManager.persist(e2);

        Empleado e3 = new Empleado();
        e3.setNombre("Natalia");
        entityManager.persist(e3);

        // DEPARTAMENTOS
        Departamento d1 = new Departamento();
        d1.setNombre("informatica");
        entityManager.persist(d1);

        Departamento d2 = new Departamento();
        d2.setNombre("ventas");
        entityManager.persist(d2);

        e1.setDept(d1);
        e2.setDept(d2);
        e3.setDept(d1);

        // PROYECTOS
        Proyecto p1 = new Proyecto();
        p1.setNombre("Api-rest");
        entityManager.persist(p1);
        p1.addEmpleado(e1);

        Proyecto p2 = new Proyecto();
        p2.setNombre("Aulas felices");
        entityManager.persist(p2);
        p2.addEmpleado(e2);

        Proyecto p3 = new Proyecto();
        p3.setNombre("Cena de navidad");
        entityManager.persist(p3);
        p3.addEmpleado(e1);p3.addEmpleado(e2);p3.addEmpleado(e3);

        Empleado pTemporaal = entityManager.find(Empleado.class,"2");
        System.out.println(pTemporaal);

        // Fin de la transaccion
        transaction.commit();
        entityManager.close();
    }
}
