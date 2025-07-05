package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.Curso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Serializable {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void contratarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void despedirProfesor(String nombre) {
        profesores.removeIf(profesor -> profesor.getNombre().equalsIgnoreCase(nombre));
    }

    public void ofrecerCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " | Profesores: " + profesores.size() + " | Cursos: " + cursos.size();
    }
}

