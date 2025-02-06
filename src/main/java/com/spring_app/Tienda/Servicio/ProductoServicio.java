package com.spring_app.Tienda.Servicio;

import com.spring_app.Tienda.Entidad.Producto;
import com.spring_app.Tienda.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//
@Service

public class ProductoServicio {

    //Inyeccion de dependecias
    @Autowired
    ProductoRepositorio productoRepositorio;

    //Producto que devuele una lista
    public List<Producto> listarProductos (){
        return productoRepositorio.findAll();
    }

    //Metodo para buscar producto
    public List<Producto> buscarProductoNombre(String buscarProducto){
        if (buscarProducto==null || buscarProducto.isEmpty()){
            return productoRepositorio.findAll();
        }
        else {
            return productoRepositorio.findByNombreContainingIgnoreCase(buscarProducto);
        }
    }
    //Optional es un contenedor de producto
    //Si encuentra el producto con el ID genera algo si no un null
    public Optional<Producto> buscarProducto(Long id){
        return productoRepositorio.findById(id);
    }

    //Metodo que no devuelve nada
    public void guardarProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    //Metodo para eliminar producto
    public void eliminarProducto(Long id){
        productoRepositorio.deleteById(id);
    }
}
