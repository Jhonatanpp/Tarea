# 🎓 Sistema de Gestión Universitaria en Java (POO + JavaFX + MVVM)

Este proyecto implementa un sistema de gestión universitaria utilizando **Programación Orientada a Objetos (POO)** en Java. Se trabajan relaciones entre clases como **composición, agregación, asociación y dependencia**, incluyendo persistencia de datos y una interfaz gráfica básica con **JavaFX y patrón MVVM**.

---

## Estructura del Proyecto

- `model/` → Clases del dominio: Universidad, Departamento, Profesor, Curso, Estudiante, GeneradorReporte.
- `viewmodel/` → Clase Persistencia (guardado/carga de datos).
- `view/` → Interfaz JavaFX (FXML + Controller). NO SE IMPLEMENTO
- `MainApp.java` → Clase principal

---

## Checklist de Requisitos (según el documento original)

### Relaciones entre Clases

- [x] **Composición**: `Universidad` contiene y controla `Departamento`.
- [x] **Agregación**: `Departamento` mantiene una relación débil con `Profesor`.
- [x] **Asociación bidireccional**: `Curso` ↔ `Estudiante`.
- [x] **Dependencia**: `Curso` depende temporalmente de `GeneradorReporte`.

### Clases y Métodos

- [x] `Universidad`, `Departamento`, `Profesor`, `Curso`, `Estudiante`, `GeneradorReporte`
- [x] Métodos de gestión: agregar, contratar, asignar, inscribir, generar reportes.
- [x] Getters/Setters y constructores apropiados.
- [x] Uso correcto de `ArrayList` y `Serializable`.

### Casos de Uso

- [x] Crear universidad con departamentos.
- [x] Contratar profesores en departamentos.
- [x] Crear cursos y asignar profesores.
- [x] Inscribir estudiantes en cursos.
- [x] Generar reportes por curso.
- [x] Guardar y cargar datos del sistema.

### Interfaz y Arquitectura

- [x] Consola interactiva con menú (`Scanner`)
- [x] Interfaz gráfica JavaFX (FXML)
- [x] Patrón MVVM aplicado: Separación Model / ViewModel / View
- [x] Actualización dinámica de vista con controlador JavaFX

---

## Requisitos para ejecutar

- JDK 17+
- NetBeans o IDE compatible con JavaFX
- JavaFX SDK (configurado en el proyecto)
- Archivo `universidad.dat` (opcional, generado al guardar)

---

## Persistencia

Se usa `ObjectOutputStream` y `ObjectInputStream` para guardar/cargar la estructura completa de la universidad.

---

## Capturas de Pantalla
1.Interfaz

![image](https://github.com/user-attachments/assets/9739e8da-d6e4-45a0-8f9e-994c6aaf74df)

2.Crear Departamento

![image](https://github.com/user-attachments/assets/d8e7d43a-e068-41f0-9f7f-b3160088ae22)

3.Contratar Profesor

![image](https://github.com/user-attachments/assets/ee15654d-f804-48f8-be8c-b2561868bb86)

4.Crear cursos

![image](https://github.com/user-attachments/assets/2fb53a00-db79-40d9-bd38-25cbd0ccdaf1)

5.Inscribir estudiante

![image](https://github.com/user-attachments/assets/2ec4c7ed-8c25-4bd4-9528-5ea42f6bb60c)

6.Reporte del curso

![image](https://github.com/user-attachments/assets/da1a874a-8413-4e30-8dd9-f44792d64a1a)

7.Guardar

![image](https://github.com/user-attachments/assets/6709b341-020a-4bc9-aaf9-50c711d10dc3)
