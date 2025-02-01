package com.spring_app.Tienda.Controlador;

import com.spring_app.Tienda.Entidad.Producto;
import com.spring_app.Tienda.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoControlador {

    //Inyeccion de dependencias para llamar a ProductoServicio
    @Autowired
    ProductoServicio productoServicio;

    //LEER
    @GetMapping("/productos")
    public String mostrarProductos(Model model){ //Model de ui framework spring
        List<Producto> productos = productoServicio.listarProductos();
        model.addAttribute("productos", productos);
        return  "//";
    }

    //CREAR
    @GetMapping("/formulario")
    public String formularioProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "/formulario";
    }
    @PostMapping("/guardar")
    public String crearProducto(Producto producto){
        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    //ACTUALIZAR
    @GetMapping("/editar{id}")
    public String editarProducto(@PathVariable Long id, Model model){
        Optional<Producto> producto = productoServicio.buscarProducto(id);
        model.addAttribute("producto", producto);
        return "//";
    }

    //ELIMINAR
    @GetMapping("/eliminar{id}")
    public String eliminarProducto(@PathVariable Long id){
        productoServicio.eliminarProducto(id);
        return "redirect/producto"; //PUSO LIBROS EN EL VIDEO
    }

}
