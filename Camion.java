/**
 * Clasa care defineste un camion. Detine tot ce detine si clasa sa parinte,
 * Vehciul
 */
public class Camion extends Vehicul {
    /**
     * Constructorul se foloseste de constructorul parintelui
     */
    public Camion() {
        super("Autoutilitar", 3, 6);
    }

    /**
     * Metoda care trebuie neaparat suprascrisa din clasa parinte, fiind una
     * abstracta
     *
     * @return mesaj despre un camion
     */
    @Override
    public String toString() {
        return "Camionul are un cost de " + this.cost + " si un gabarit" +
                "de " + this.gabarit;
    }
}
