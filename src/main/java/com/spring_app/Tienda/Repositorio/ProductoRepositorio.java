package com.spring_app.Tienda.Repositorio;


import com.spring_app.Tienda.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {


}
