/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import proyecto2.Personaje;


public class FileFunctions {

    // Definimos arrays para cada categoría
    private LinkedList redStarWars = new LinkedList();
    private LinkedList yellowStarWars = new LinkedList();
    private LinkedList greenStarWars = new LinkedList();

    private LinkedList redStarTrek = new LinkedList();
    private LinkedList yellowStarTrek = new LinkedList();
    private LinkedList greenStarTrek = new LinkedList();

    public void read(File file) {
        String line;

        // Rellenar los arrays con las instancias de Character
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentShow = null;

            while ((line = br.readLine()) != null) {
                if (!(line.isEmpty())) {
                    if (line.startsWith("[")) {
                        currentShow = line.substring(1, line.length() - 1);
                    } else {
                        String[] parts = line.split(",");

                        Personaje personaje = new Personaje(
                                "",
                                parts[0],
                                Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]),
                                parts[4],
                                parts[5].split(";")[0]
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

