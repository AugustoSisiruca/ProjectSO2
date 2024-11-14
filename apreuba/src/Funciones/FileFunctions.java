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
    private Lista greenStarWars = new Lista();
    private Lista yellowStarWars = new Lista();
    private Lista redStarWars = new Lista();

    private Lista greenStarTrek = new Lista();
    private Lista yellowStarTrek = new Lista();
    private Lista redStarTrek = new Lista();

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

                        Personaje character = new Personaje(
                                "",
                                parts[0],
                                Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]),
                                parts[4],
                                parts[5].split(";")[0]
                        );
 
                        // Clasificar el personaje en la lista correspondiente
                        if (line.contains("green.png") && "Star Wars".equals(currentShow)) {
                            character.setPriorityLevel(1);
                            this.getGreenStarWars().addEnd(character);
                        } else if (line.contains("yellow.png") && "Star Wars".equals(currentShow)) {
                            character.setPriorityLevel(2);
                            this.getYellowStarWars().addEnd(character);
                        } else if (line.contains("red.png") && "Star Wars".equals(currentShow)) {
                            character.setPriorityLevel(3);
                            this.getRedStarWars().addEnd(character);
                        } else if (line.contains("green.png") && "Star Trek".equals(currentShow)) {
                            character.setPriorityLevel(1);
                            this.getGreenStarTrek().addEnd(character);
                        } else if (line.contains("yellow.png") && "Star Trek".equals(currentShow)) {
                            character.setPriorityLevel(2);
                            this.getYellowStarTrek().addEnd(character);
                        } else if (line.contains("red.png") && "Star Trek".equals(currentShow)) {
                            character.setPriorityLevel(3);
                            this.getRedStarTrek().addEnd(character);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the greenStarWars
     */
    public Lista getGreenStarWars() {
        return greenStarWars;
    }

    /**
     * @param greenStarWars the greenStarWars to set
     */
    public void setGreenStarWars(Lista greenStarWars) {
        this.greenStarWars = greenStarWars;
    }

    /**
     * @return the yellowStarWars
     */
    public Lista getYellowStarWars() {
        return yellowStarWars;
    }

    /**
     * @param yellowStarWars the yellowStarWars to set
     */
    public void setYellowStarWars(Lista yellowStarWars) {
        this.yellowStarWars = yellowStarWars;
    }

    /**
     * @return the redStarWars
     */
    public Lista getRedStarWars() {
        return redStarWars;
    }

    /**
     * @param redStarWars the redStarWars to set
     */
    public void setRedStarWars(Lista redStarWars) {
        this.redStarWars = redStarWars;
    }

    /**
     * @return the greenStarTrek
     */
    public Lista getGreenStarTrek() {
        return greenStarTrek;
    }

    /**
     * @param greenStarTrek the greenStarTrek to set
     */
    public void setGreenStarTrek(Lista greenStarTrek) {
        this.greenStarTrek = greenStarTrek;
    }

    /**
     * @return the yellowStarTrek
     */
    public Lista getYellowStarTrek() {
        return yellowStarTrek;
    }

    /**
     * @param yellowStarTrek the yellowStarTrek to set
     */
    public void setYellowStarTrek(Lista yellowStarTrek) {
        this.yellowStarTrek = yellowStarTrek;
    }

    /**
     * @return the redStarTrek
     */
    public Lista getRedStarTrek() {
        return redStarTrek;
    }

    /**
     * @param redStarTrek the redStarTrek to set
     */
    public void setRedStarTrek(Lista redStarTrek) {
        this.redStarTrek = redStarTrek;
    }

}
