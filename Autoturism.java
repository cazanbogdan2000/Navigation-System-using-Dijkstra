/**
 * Clasa care defineste un autoturism. Detine tot ce detine si clasa sa parinte,
 * Vehciul
 */
public class Autoturism extends Vehicul {
    /**
     * Constructorul se foloseste de constructorul parintelui
     */
    public Autoturism() {
        super("Autovehicul", 2, 4);
    }

    /**
     * Metoda care trebuie neaparat suprascrisa din clasa parinte, fiind una
     * abstracta
     *
     * @return mesaj despre un autoturism
     */
    @Override
    public String toString() {
        return "Autovehiculul are un cost de " + this.cost + " si un gabarit" +
                "de " + this.gabarit;
    }
}
