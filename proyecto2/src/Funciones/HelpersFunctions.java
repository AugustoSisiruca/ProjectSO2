/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import proyecto2.Administrator;
import proyecto2.IA;
import proyecto2.App;

/**
 *
 * @author
 */

public class HelpersFunctions {

    public final static String[] priority = {"Yellow", "Green", "Red"};

    public static void loadParams() {
        App app = App.getInstance();
        FileFunctions fileFunctions = new FileFunctions();
        fileFunctions.read(App.getSelectedFile());

        app.setIa(new IA());

        Administrator admin = new Administrator(
                app.getIa(),
                app.getMutex(),
                fileFunctions.getGreenStarWars(), fileFunctions.getYellowStarWars(), fileFunctions.getRedStarWars(),
                fileFunctions.getGreenStarTrek(), fileFunctions.getYellowStarTrek(), fileFunctions.getRedStarTrek());

        app.setAdmin(admin);
        app.getAdmin().getIa().setAdministrator(admin);
        app.getAdmin().startSimulation();

    }
}
