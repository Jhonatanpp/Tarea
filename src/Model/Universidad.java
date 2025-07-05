package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Model.Profesor;
import Model.Departamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universidad implements Serializable {
    private String nombre;
    private List<Departamento> departamentos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void agregarDepartamento(String nombre) {
        departamentos.add(new Departamento(nombre));
    }

    public void eliminarDepartamento(String nombre) {
        departamentos.removeIf(dep -> dep.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Profesor> obtenerTodosProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Departamento dep : departamentos) {
            profesores.addAll(dep.getProfesores());
        }
        return profesores;
    }

    @Override
    public String toString() {
        return "Universidad: " + nombre + " con " + departamentos.size() + " departamentos.";
    }
}
