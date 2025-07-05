package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.Curso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profesor implements Serializable {
    private String nombre;
    private String especialidad;
    private List<Curso> cursosImpartidos;

    public Profesor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursosImpartidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void asignarCurso(Curso curso) {
        if (!cursosImpartidos.contains(curso)) {
            cursosImpartidos.add(curso);
            curso.asignarProfesor(this);
        }
    }

    public void desasignarCurso(String codigoCurso) {
        cursosImpartidos.removeIf(curso -> curso.getCodigo().equalsIgnoreCase(codigoCurso));
    }

    @Override
    public String toString() {
        return "Profesor: " + nombre + " | Especialidad: " + especialidad;
    }
}
