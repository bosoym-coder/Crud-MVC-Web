package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Cliente;
import com.example.demo.models.Empleado;
import com.example.demo.models.Producto;

@Controller
public class MainController {

    private List<Producto> listaProductos = new ArrayList<>(List.of(
        new Producto(1, "Alerón Frontal W15", 50000.00),
        new Producto(2, "Neumáticos Pirelli Blandos", 15000.00)
    ));

    private List<Cliente> listaClientes = new ArrayList<>(List.of(
        new Cliente("12345-6", "Petronas", "Kuala Lumpur"),
        new Cliente("98765-4", "IWC Schaffhausen", "Suiza")
    ));

    private List<Empleado> listaEmpleados = new ArrayList<>(List.of(
        new Empleado(44, "Lewis Hamilton", "Piloto Principal"),
        new Empleado(63, "George Russell", "Piloto Secundario")
    ));

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/productos")
    public String verProductos(Model model) {
        model.addAttribute("productos", listaProductos);
        return "productos";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@RequestParam int id, @RequestParam String nombre, @RequestParam double precio) {
        listaProductos.add(new Producto(id, nombre, precio));
        return "redirect:/productos";
    }

    @GetMapping("/clientes")
    public String verClientes(Model model) {
        model.addAttribute("clientes", listaClientes);
        return "clientes";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@RequestParam String nit, @RequestParam String nombre, @RequestParam String direccion) {
        listaClientes.add(new Cliente(nit, nombre, direccion));
        return "redirect:/clientes";
    }

    @GetMapping("/empleados")
    public String verEmpleados(Model model) {
        model.addAttribute("empleados", listaEmpleados);
        return "empleados";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@RequestParam int codigo, @RequestParam String nombre, @RequestParam String puesto) {
        listaEmpleados.add(new Empleado(codigo, nombre, puesto));
        return "redirect:/empleados";
    }
}