/**
 * Clasa care defineste o motocicleta. Detine tot ce detine si clasa sa parinte,
 * Vehciul
 */
public class Motocicleta extends Vehicul {
    /**
     * Constructorul se foloseste de constructorul parintelui
     */
    public Motocicleta() {
        super("Moped", 1, 2);
    }

    /**
     * Metoda care trebuie neaparat suprascrisa din clasa parinte, fiind una
     * abstracta
     *
     * @return mesaj despre o motocicleta
     */
    @Override
    public String toString() {
        return "Motocicleta are un cost de " + this.cost + " si un gabarit" +
                "de " + this.gabarit;
    }
}
