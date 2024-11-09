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

    public LinkedList getRedStarWars() {
        return redStarWars;
    }

    public void setRedStarWars(LinkedList redStarWars) {
        this.redStarWars = redStarWars;
    }

    public LinkedList getYellowStarWars() {
        return yellowStarWars;
    }

    public void setYellowStarWars(LinkedList yellowStarWars) {
        this.yellowStarWars = yellowStarWars;
    }

    public LinkedList getGreenStarWars() {
        return greenStarWars;
    }

    public void setGreenStarWars(LinkedList greenStarWars) {
        this.greenStarWars = greenStarWars;
    }

    public LinkedList getRedStarTrek() {
        return redStarTrek;
    }

    public void setRedStarTrek(LinkedList redStarTrek) {
        this.redStarTrek = redStarTrek;
    }

    public LinkedList getYellowStarTrek() {
        return yellowStarTrek;
    }

    public void setYellowStarTrek(LinkedList yellowStarTrek) {
        this.yellowStarTrek = yellowStarTrek;
    }

    public LinkedList getGreenStarTrek() {
        return greenStarTrek;
    }

    public void setGreenStarTrek(LinkedList greenStarTrek) {
        this.greenStarTrek = greenStarTrek;
    }


}
