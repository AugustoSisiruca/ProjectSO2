/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Interfaz.MenuInicio;
import java.io.File;
import java.util.concurrent.Semaphore;
import Funciones.FileFunctions;
/**
 *
 * @author sisir
 */
public class App {
    
    private static String selectedPath = "test//params.txt";
    private static File selectedFile = new File(selectedPath);
    private static FileFunctions fileFunctions = new FileFunctions();

    private static Semaphore mutex = new Semaphore(1);
    private static int battleDuration = 10;
    private static Administrador admin;
    private static IA ia;

    private static App app;
    
    
    public void start(){
    MenuInicio home = new MenuInicio();
        home.setVisible(true);
    }
    
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }

    public static String getSelectedPath() {
        return selectedPath;
    }

    public static void setSelectedPath(String selectedPath) {
        App.selectedPath = selectedPath;
    }

    public static File getSelectedFile() {
        return selectedFile;
    }

    public static void setSelectedFile(File selectedFile) {
        App.selectedFile = selectedFile;
    }

    public static FileFunctions getFileFunctions() {
        return fileFunctions;
    }

    public static void setFileFunctions(FileFunctions fileFunctions) {
        App.fileFunctions = fileFunctions;
    }

    public static Semaphore getMutex() {
        return mutex;
    }

    public static void setMutex(Semaphore mutex) {
        App.mutex = mutex;
    }

    public static int getBattleDuration() {
        return battleDuration;
    }

    public static void setBattleDuration(int battleDuration) {
        App.battleDuration = battleDuration;
    }

    public static Administrador getAdmin() {
        return admin;
    }

    public static void setAdmin(Administrador admin) {
        App.admin = admin;
    }

    public static IA getIa() {
        return ia;
    }

    public static void setIa(IA ia) {
        App.ia = ia;
    }

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        App.app = app;
    }

    
    
}
