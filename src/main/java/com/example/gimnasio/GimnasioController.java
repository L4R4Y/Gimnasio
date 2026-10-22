package com.example.gimnasio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GimnasioController {

    
    private List<Miembro> miembros;

    
    private Map<String, String> horarios;

    
    public GimnasioController() {

        miembros = new ArrayList<>();

        miembros.add(new Miembro("Carlos", 30));
        miembros.add(new Miembro("Ana", 25));
        miembros.add(new MiembroPremium("Luis", 35, "Andrés"));
        miembros.add(new MiembroEstudiante("María", 20, "Universidad Nacional"));

        horarios = new HashMap<>();

        horarios.put("yoga", "Lunes y miércoles, 8:00 a. m.");
        horarios.put("spinning", "Martes y jueves, 6:00 p. m.");
        horarios.put("crossfit", "Viernes, 7:00 a. m.");
    }


    @GetMapping("/miembros")
    public List<Miembro> listarMiembros() {
    return miembros;}

    @GetMapping("/miembros/buscar/{nombre}")
    public String buscarMiembro(@PathVariable String nombre) {
    for (Miembro miembro : miembros) {
        if (miembro.getNombre().equalsIgnoreCase(nombre)) {

            return miembro.descripcion()
                    + " - cuota mensual: $"
                    + miembro.cuotaMensual();
        }
    }

    return "No se encontró al miembro " + nombre;}


    @GetMapping("/miembros/cuota/{minima}")
    public List<Miembro> filtrarPorCuota(
        @PathVariable double minima) {

    List<Miembro> resultado = new ArrayList<>();

    for (Miembro miembro : miembros) {

        if (miembro.cuotaMensual() >= minima) {
            resultado.add(miembro);
        }
    }

    return resultado;}


    
    @GetMapping("/clases/{nombre}")
    public String consultarHorario(@PathVariable String nombre) {

    for (Map.Entry<String, String> clase : horarios.entrySet()) {

        if (clase.getKey().equalsIgnoreCase(nombre)) {
            return clase.getValue();
        }
    }

    return "Clase no disponible";
}
}   
