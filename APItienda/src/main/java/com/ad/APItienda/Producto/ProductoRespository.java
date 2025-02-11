package com.ad.APItienda.Producto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRespository extends MongoRepository<Producto,Integer> {
}
