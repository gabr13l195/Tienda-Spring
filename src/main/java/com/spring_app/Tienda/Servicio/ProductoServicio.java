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

    //Optional es un contenedor de producto
    //Si encuentra el producto con el ID genera algo si no un null
    public Optional<Producto> buscarProducto(Long id){
        return productoRepositorio.findById(id);
    }

    //Metodo que no devuelve nada
    public void guardarProducto(Producto producto) {
        if (producto.getId() != null) { // Si tiene ID, es una actualización
            Optional<Producto> productoExistente = productoRepositorio.findById(producto.getId());
            if (productoExistente.isPresent()) {
                Producto actualizado = productoExistente.get();
                actualizado.setNombre(producto.getNombre());
                actualizado.setPrecio(producto.getPrecio());
                actualizado.setStock(producto.getStock());
                productoRepositorio.save(actualizado);
            } else {
                throw new RuntimeException("El producto con ID " + producto.getId() + " no existe.");
            }
        } else { // Si no tiene ID, es un nuevo registro
            productoRepositorio.save(producto);
        }
    }

    //Metodo para eliminar producto
    public void eliminarProducto(Long id) {
        if (productoRepositorio.existsById(id)) {
            productoRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }
    }
}
