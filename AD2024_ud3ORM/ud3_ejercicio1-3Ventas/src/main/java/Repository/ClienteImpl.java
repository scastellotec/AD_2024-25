package Repository;

import Model.Cliente;

public class ClienteImpl {

    // Instancia de entitymanager

    public save(Cliente c){
        entitymanger.begin();
        entitymanager.persist(c);
        entitymanger.commit();
    }
    public delete(Cliente c){

    }
    public List<Cliente> findAll(){

    }
}
