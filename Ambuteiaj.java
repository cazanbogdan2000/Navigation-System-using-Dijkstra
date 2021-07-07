/**
 * Clasa care defineste un ambuteiaj; prea simpla si prea evidenta pentru a
 * spune prea multe despre ea
 */
public class Ambuteiaj {
    private String tipAmbuteiaj;
    private int cost;

    /**
     * Constructor fara parametri
     */
    public Ambuteiaj() {
    }

    /**
     * Constructor cu parametri
     * @param tipAmbuteiaj initializeaza tipul de ambuteiaj
     * @param cost atribuie costul cu care vine respectivul ambuteiaj
     */
    public Ambuteiaj(String tipAmbuteiaj, int cost) {
        this.tipAmbuteiaj = tipAmbuteiaj;
        this.cost = cost;
    }

    /**
     * Metoda care ne da costul ambuteiajului
     * @return costul ambuteiajului definit
     */
    public int getCost() {
        return cost;
    }

    /**
     * Metoda care seteaza costul ambuteiajului
     * @param cost este noul cost pe care vrem sa il aiba ambuteiajul
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Un getter pentru tipul de ambuteiaj
     * @return tipul de ambuteiaj, sub forma de String
     */
    public String getTipAmbuteiaj() {
        return tipAmbuteiaj;
    }

    /**
     * Seteaza tipul de ambuteiaj
     * @param tipAmbuteiaj noul tip de ambuteiaj pe care vrem sa il avem
     */
    public void setTipAmbuteiaj(String tipAmbuteiaj) {
        this.tipAmbuteiaj = tipAmbuteiaj;
    }
}
