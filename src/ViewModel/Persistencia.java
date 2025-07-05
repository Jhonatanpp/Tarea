/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.Universidad;
import java.io.*;

public class Persistencia {

    public static void guardarUniversidad(Universidad uni, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(uni);
            System.out.println("✅ Universidad guardada correctamente.");
        } catch (IOException e) {
            System.out.println("⚠️ Error al guardar: " + e.getMessage());
        }
    }

    public static Universidad cargarUniversidad(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Universidad) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ Error al cargar: " + e.getMessage());
            return null;
        }
    }
}

