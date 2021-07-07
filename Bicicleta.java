/**
 * Clasa care defineste o bicicleta. Detine tot ce detine si clasa sa parinte,
 * Vehciul
 */
public class Bicicleta extends Vehicul {
    /**
     * Constructorul se foloseste de constructorul parintelui
     */
    public Bicicleta() {
        super("Moped", 1, 1);
    }

    /**
     * Metoda care trebuie neaparat suprascrisa din clasa parinte, fiind una
     * abstracta
     *
     * @return mesaj despre o bicleta
     */
    @Override
    public String toString() {
        return "Bicicleta are un cost de " + this.cost + " si un gabarit" +
                "de " + this.gabarit;
    }
}
