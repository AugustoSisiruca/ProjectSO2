/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;  // Define el paquete "proyecto2" al que pertenece esta clase.

/**
 *
 * @author sisir
 */

public class Personaje {  // Declaración de la clase "Personaje".

    // Declaración de variables privadas de instancia.
    private String characterId;  // Identificador del personaje.
    private String nameCharacter;  // Nombre del personaje.
    private int hitPoints;  // Puntos de vida del personaje.
    private int speedVelocity;  // Velocidad del personaje.
    private int agility;  // Agilidad del personaje.
    private String hability;  // Habilidad especial del personaje.
    private int priorityLevel;  // Nivel de prioridad del personaje (sin uso en el constructor).
    private String urlSource;  // URL fuente relacionada con el personaje.
    private int counter = 0;  // Contador para algún propósito, inicialmente 0.
    private String status = "";  // Estado del personaje (inicialmente vacío).

    // Constructor que inicializa las propiedades del personaje.
    public Personaje(
            String characterId,  // Identificador del personaje.
            String nameCharacter,  // Nombre del personaje.
            int hitPoints,  // Puntos de vida.
            int speedVelocity,  // Velocidad.
            int agility,  // Agilidad.
            String hability,  // Habilidad especial.
            String urlSource) {  // URL relacionada con el personaje.

        // Asignación de valores a las variables de instancia.
        this.characterId = characterId;
        this.nameCharacter = nameCharacter;
        this.hitPoints = hitPoints;
        this.speedVelocity = speedVelocity;
        this.agility = agility;
        this.urlSource = urlSource;
        this.hability = hability;
    }

    // Método que incrementa el contador (se puede interpretar como un ascenso).
    public void getPromoted() {
        this.counter += 1;  // Incrementa el valor de "counter" en 1.
    }

    // Método que genera una representación en cadena (String) del objeto.
    public String toString() {
        return "Character{"
                + "chapterId=" + getCharacterId()  // Agrega el ID del personaje a la cadena.
                + ", hitPoints=" + getHitPoints()  // Agrega los puntos de vida.
                + ", speedVelocity=" + getSpeedVelocity()  // Agrega la velocidad.
                + ", agility=" + getAgility()  // Agrega la agilidad.
                + ", hability='" + getHability() + '\''  // Agrega la habilidad.
                + ", priorityLevel=" + getPriorityLevel()  // Agrega el nivel de prioridad.
                + ", urlSource='" + getUrlSource() + '\''  // Agrega la URL.
                + '}';  // Cierra la cadena de la representación del personaje.
    }

    // Método que reduce los puntos de vida al recibir daño.
    public void takeDamage(int damage) {
        //  Reduce los puntos de vida a la mitad del daño recibido.
        this.hitPoints -= (damage / 2);

        // Evita que la vida de un valor negativo.
        if (this.hitPoints < 0) {
            this.hitPoints = 0;  // Si los hitPoints son menores a 0, se establecen en 0.
        }
    }

    // Método que incrementa los puntos de vida al curar.
    public void heal(int healthPoints) {
        // Incrementar los hitPoints en la cantidad especificada.
        this.hitPoints += healthPoints;

        int maxHP = 160;  // Máxima cantidad de puntos de vida permitida.
        if (this.hitPoints > maxHP) {  // Si los hitPoints superan el máximo.
            this.hitPoints = maxHP;  // Los hitPoints se limitan al valor máximo (160).
        }
    }

    // Métodos getter y setter para acceder y modificar las propiedades del personaje.

    public String getCharacterId() {  // Devuelve el ID del personaje.
        return characterId;
    }

    public void setCharacterId(String characterId) {  // Establece un nuevo ID para el personaje.
        this.characterId = characterId;
    }

    public String getNameCharacter() {  // Devuelve el nombre del personaje.
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {  // Establece un nuevo nombre para el personaje.
        this.nameCharacter = nameCharacter;
    }

    public int getHitPoints() {  // Devuelve los puntos de vida.
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {  // Establece nuevos puntos de vida.
        this.hitPoints = hitPoints;
    }

    public int getSpeedVelocity() {  // Devuelve la velocidad.
        return speedVelocity;
    }

    public void setSpeedVelocity(int speedVelocity) {  // Establece una nueva velocidad.
        this.speedVelocity = speedVelocity;
    }

    public int getAgility() {  // Devuelve la agilidad.
        return agility;
    }

    public void setAgility(int agility) {  // Establece una nueva agilidad.
        this.agility = agility;
    }

    public String getHability() {  // Devuelve la habilidad.
        return hability;
    }

    public void setHability(String hability) {  // Establece una nueva habilidad.
        this.hability = hability;
    }

    public int getPriorityLevel() {  // Devuelve el nivel de prioridad.
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {  // Establece un nuevo nivel de prioridad.
        this.priorityLevel = priorityLevel;
    }

    public String getUrlSource() {  // Devuelve la URL fuente.
        return urlSource;
    }

    public void setUrlSource(String urlSource) {  // Establece una nueva URL fuente.
        this.urlSource = urlSource;
    }

    public int getCounter() {  // Devuelve el valor del contador.
        return counter;
    }

    public void setCounter(int counter) {  // Establece un nuevo valor para el contador.
        this.counter = counter;
    }

    public String getStatus() {  // Devuelve el estado del personaje.
        return status;
    }

    public void setStatus(String status) {  // Establece un nuevo estado para el personaje.
        this.status = status;
    }
    
}
