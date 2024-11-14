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
    private Lista redStarWars = new Lista();
    private Lista yellowStarWars = new Lista();
    private Lista greenStarWars = new Lista();

    private Lista redStarTrek = new Lista();
    private Lista yellowStarTrek = new Lista();
    private Lista greenStarTrek = new Lista();

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
 
                        // Clasificar el personaje en la linkedList correspondiente
                        if (line.contains("green.png") && "Star Wars".equals(currentShow)) {
                            personaje.setPriorityLevel(1);
                            this.getGreenStarWars().addEnd(personaje);
                        } else if (line.contains("yellow.png") && "Star Wars".equals(currentShow)) {
                            personaje.setPriorityLevel(2);
                            this.getYellowStarWars().addEnd(personaje);
                        } else if (line.contains("red.png") && "Star Wars".equals(currentShow)) {
                            personaje.setPriorityLevel(3);
                            this.getRedStarWars().addEnd(personaje);
                        } else if (line.contains("green.png") && "Star Trek".equals(currentShow)) {
                            personaje.setPriorityLevel(1);
                            this.getGreenStarTrek().addEnd(personaje);
                        } else if (line.contains("yellow.png") && "Star Trek".equals(currentShow)) {
                            personaje.setPriorityLevel(2);
                            this.getYellowStarTrek().addEnd(personaje);
                        } else if (line.contains("red.png") && "Strar Trek".equals(currentShow)) {
                            personaje.setPriorityLevel(3);
                            this.getRedStarTrek().addEnd(personaje);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lista getRedStarWars() {
        return redStarWars;
    }

    public void setRedStarWars(Lista redStarWars) {
        this.redStarWars = redStarWars;
    }

    public Lista getYellowStarWars() {
        return yellowStarWars;
    }

    public void setYellowStarWars(Lista yellowStarWars) {
        this.yellowStarWars = yellowStarWars;
    }

    public Lista getGreenStarWars() {
        return greenStarWars;
    }

    public void setGreenStarWars(Lista greenStarWars) {
        this.greenStarWars = greenStarWars;
    }

    public Lista getRedStarTrek() {
        return redStarTrek;
    }

    public void setRedStarTrek(Lista redStarTrek) {
        this.redStarTrek = redStarTrek;
    }

    public Lista getYellowStarTrek() {
        return yellowStarTrek;
    }

    public void setYellowStarTrek(Lista yellowStarTrek) {
        this.yellowStarTrek = yellowStarTrek;
    }

    public Lista getGreenStarTrek() {
        return greenStarTrek;
    }

    public void setGreenStarTrek(Lista greenStarTrek) {
        this.greenStarTrek = greenStarTrek;
    }


}
