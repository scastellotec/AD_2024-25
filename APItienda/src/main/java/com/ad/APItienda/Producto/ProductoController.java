package com.ad.APItienda.Producto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    private ProductoRespository productoRespository;

    public ProductoController(ProductoRespository productoRespository){
        this.productoRespository = productoRespository;
    }

    @GetMapping("/")
    public List<Producto> getAll(){
        return productoRespository.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody Producto p){
        productoRespository.save(p);
    }
}
