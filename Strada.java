import java.util.ArrayList;

/**
 * Clasa care are rolul de a retine detaliile despre o strada, cum ar fi:
 * costul strazii respective, limita de gabarit admisa pe acea strada, costul
 * total al ambuteiajelor, precum si o lista cu toate ambuteiajele ce au avut
 * loc pe respectiva strada
 */
public class Strada {
    private int costStrada;
    private int limitaGabarit;
    private int costAmbuteiaje = 0;
    private ArrayList<Ambuteiaj> ambuteiaje = new ArrayList<Ambuteiaj>();

    /**
     * Constructor fara parametri
     */
    public Strada() {
    }

    /**
     * Constructor cu parametri
     *
     * @param costStrada initializeaza costul de pe strada curenta
     * @param limitaGabarit seteaza limita de gabarit acceptata pe strada
     */
    public Strada(int costStrada, int limitaGabarit) {
        this.costStrada = costStrada;
        this.limitaGabarit = limitaGabarit;
    }

    /**
     * Metoda care mareste costul total al ambuteiajelor cu un nou cost
     *
     * @param costNou noul cost pe care vrem sa il adaugam la costul total al
     *                ambuteiajelor
     */
    public void maresteCostAmbuteiaj(int costNou) {
        this.costAmbuteiaje += costNou;
    }

    /**
     * Metoda care adauga un nou ambuteiaj la lista de ambuteiaje de pe strada
     * curenta. In plus, face actualizare automata a costului total al
     * ambuteiajelor de pe strada.
     *
     * @param tipAmbuteiaj tipul noului ambuteiaj
     * @param cost costul pe care il va avea acest ambuteiaj
     */
    public void adaugaAmbuteiaj(String tipAmbuteiaj, int cost) {
        Ambuteiaj aux = new Ambuteiaj(tipAmbuteiaj, cost);
        this.ambuteiaje.add(aux);
        this.costAmbuteiaje += aux.getCost();
    }

    /**
     * Getter pentru costul strazii.
     *
     * @return costul strazii
     */
    public int getCostStrada() {
        return costStrada;
    }

    /**
     * Setter pentru costul strazii
     * @param costStrada valoarea pe care vrem sa o punem in campul costStrada
     */
    public void setCostStrada(int costStrada) {
        this.costStrada = costStrada;
    }

    /**
     * Getter pentru limita de gabarit a strazii.
     *
     * @return limita de gabarit de pe acea strada
     */
    public int getLimitaGabarit() {
        return limitaGabarit;
    }

    /**
     * Setter pentru limita de gabarit a strazii.
     *
     * @param limitaGabarit limita de gabarit de pe acea strada
     */
    public void setLimitaGabarit(int limitaGabarit) {
        this.limitaGabarit = limitaGabarit;
    }

    /**
     * Getter pentru costul total al ambuteiajelor de pe strada curenta.
     *
     * @return costul total al ambuteiajelor
     */
    public int getCostAmbuteiaje() {
        return this.costAmbuteiaje;
    }

    /**
     * Setter pentru costul total al ambuteiajelor de pe strada curenta.
     *
     * @param costAmbuteiaje costul total al ambuteiajelor
     */
    public void setCostAmbuteiaje(int costAmbuteiaje) {
        this.costAmbuteiaje = costAmbuteiaje;
    }

    /**
     * Getter pentru lista de ambuteiaje de pe strada curenta
     *
     * @return o lista de ambuteiaje, care sunt pe strada asta
     */
    public ArrayList<Ambuteiaj> getAmbuteiaje() {
        return ambuteiaje;
    }

    /**
     * Setter pentru lista de ambuteiaje de pe strada curenta; nu are prea mult
     * sens, dar am zis sa fie :))
     *
     * @param ambuteiaje o lista de ambuteiaje, care sunt pe strada asta
     */
    public void setAmbuteiaje(ArrayList<Ambuteiaj> ambuteiaje) {
        this.ambuteiaje = ambuteiaje;
    }
}
