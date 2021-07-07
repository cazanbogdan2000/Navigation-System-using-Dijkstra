/**
 * Clasa abstracta care detine specificatiile oricarui tip de vehicul.
 * Orice clasa care mosteneste clasa Vehicul dispune de tot ce ofera clasa
 * parinte, indiferent de pachetul in care aceasta face parte.
 */
public abstract class Vehicul {
    protected static String tip;
    protected int gabarit;
    protected int cost;

    /**
     * Constructor fara parametri, nu face nimic, e bine sa fie
     */
    public Vehicul() {
    }

    /**
     * Constructor cu parametri
     *
     * @param tip tipul vehicului
     * @param gabarit gabaritul pe care il are respectivul vehicul
     * @param cost costul pe care il presupune acel vehicul
     */
    public Vehicul(String tip, int gabarit, int cost) {
        this.tip = tip;
        this.gabarit = gabarit;
        this.cost = cost;
    }

    /**
     * Getter pentru tipul vehicului
     *
     * @return tipul vehciului
     */
    public String getTip() {
        return this.tip;
    }

    /**
     * Setter pentru tipul unui vehicul
     *
     * @param tip tipul vehicului
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Getter pentru gabaritul vehicului
     *
     * @return gabaritul vehciului
     */
    public int getGabarit() {
        return this.gabarit;
    }

    /**
     * Setter pentru gabaritul unui vehicul
     *
     * @param gabarit gabaritul vehicului
     */
    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    /**
     * Getter pentru costul vehicului
     *
     * @return costul vehciului
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Setter pentru costul unui vehicul
     *
     * @param cost costul vehicului
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Metoda abstracta, care ofera un mesaj sugestiv pentru vehicului curent
     *
     * @return un string cu un mesaj despre vehicul
     */
    public abstract String toString();
}
