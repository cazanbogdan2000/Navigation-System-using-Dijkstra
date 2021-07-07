import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Cea mai mare si mai importanta clasa din intreaga tema; aici se creeaza
 * graful de strazi, se prelucreaza datele citite din map.in si se prelucreaza
 * actiunile posibile. Prin actiuni intelegem ceea ce se afla dupa initierea
 * grafului anume ambuteiajele (de oricare tip) si drive-ul.
 *
 * Harta este formata dintr-o matrice de obiecte instante ale clasei Strada.
 * Deci, pentru o intelegere mai exacta a "ce face codul acesta" se recomanda
 * o parcurgere in paralel cu clasa Strada :)))
 */
public class MyMap {
    private int numarTotalStrazi;
    private int numarTotalNoduri;
    Strada[][] harta;
    private Scanner scan = Input_Output.input();
    private FileWriter output = Input_Output.output();

    /**
     * Constructorul fara parametri, care initializeaza toate datele in functie
     * de inputul primit din fisierul map.in; se creeaza pana si harta, fiecare
     * element fiind initializat cu null. O sa vedem mai incolo ca acele pozitii
     * din matricea noastra care nu stocheaza niciun fel de date se va diferentia
     * de celelalte pozitii prin valoarea sa de null
     */
    public MyMap() {
        this.numarTotalStrazi = this.scan.nextInt();
        this.numarTotalNoduri = this.scan.nextInt();
        this.harta = new Strada[this.numarTotalNoduri][this.numarTotalNoduri];
        for(int i = 0; i < this.numarTotalNoduri; i++) {
            for(int j = 0; j < this.numarTotalNoduri; j++) {
                this.harta[i][j] = null;
            }
        }
    }

    /**
     * Metoda care are rolul de a adauga o strada in matricea noastra (harta)
     *
     * @param start punctul de plecare al strazii
     * @param end punctul in care strada se termina
     * @param cost costul pe care il impune respectiva strada
     * @param size gabaritul maxim pe care il poate avea un vehciul pentru a
     *             intra pe aceasta strada
     */
    public void addStreet(int start, int end, int cost, int size) {
        this.harta[start][end] = new Strada(cost, size);
    }

    /**
     * Metoda care nu face altceva decat sa citeasca strazile din fisierul dat,
     * map.in, apeland de fiecare data addStreet pentru a o adauga si in harta
     * noastra; la final, matricea hartii va avea un nrTotalStrazi care contin
     * elemente instante pentru Strada, restul elementelor fiind egale cu null
     */
    public void CitesteHarta() {
        for(int i = 0; i < this.numarTotalStrazi; i++) {
            // o parsare corespunzatoare din map.in
            String aux = scan.next();
            aux = aux.substring(1);
            int xAxis = Integer.parseInt(aux);
            aux = scan.next();
            aux = aux.substring(1);
            int yAxis = Integer.parseInt(aux);
            int cost = scan.nextInt();
            int limitaGabarit = scan.nextInt();
            scan.nextLine();
            // adaugarea strazii formate in harta noastra
            addStreet(xAxis, yAxis, cost, limitaGabarit);
        }
    }

    /**
     * Aceasta metoda este destinata citirii restului de text din map.in, adica
     * actiunile care se pot efectua pe parcurs: pot aparea ambuteiaje sau se
     * poate dori aflarea drumului optim intre doua puncte, daca acesta exista
     */
    public void CitesteActiuni() {
        try {
            FileWriter output = new FileWriter("map.out", true);
            while (scan.hasNextLine()) {
                String actiune = scan.next();
                // cazul in care avem un ambuteiaj, nu e necesara vreo afisare
                // in fisierul map.out
                if (actiune.equals("accident") || actiune.equals("trafic") ||
                        actiune.equals("blocaj")) {
                    CitesteAmbuteiaj(actiune);
                }
                // daca insa avem un "drive", atunci suntem nevoiti si sa afisam
                // calea dintre cele 2 puncte dorite (sau null in caz contrar)
                else {
                    CitesteDrive(output);
                }
            }
            output.close();
        }
        catch (IOException e) {
            System.out.println();
        }
    }

    /**
     * Metoda care are rolul de a adauga o noua restrictie pentru o anumita
     * strada. Prin restrictie se intelege cel mai bine un tip de ambuteiaj
     *
     * @param type tipul ambuteiajului
     * @param start punctul de inceput al strazii pe care se impune restrictia
     * @param end punctul de final al strazii pe care se impune restrictia
     * @param cost costul aditional care se va acumula pe respectiva strada
     */
    public void addRestriction(String type, int start, int end, int cost) {
        this.harta[start][end].adaugaAmbuteiaj(type, cost);
    }

    /**
     * Aceasta metoda are un nume destul de sugestiv, si anume nu face altceva
     * decat sa citeasca ambuteiajul, urmand sa actualizeze costul total pentru
     * respectiva strada, cost bazat pe formula din cerinta
     * @param actiune nu reprezinta altceva decat tipul de ambuteiaj
     */
    public void CitesteAmbuteiaj(String actiune) {
        // o parsare corespunzatoare din map.in
        String aux = scan.next();
        aux = aux.substring(1);
        int xAxis = Integer.parseInt(aux);
        aux = scan.next();
        aux = aux.substring(1);
        int yAxis = Integer.parseInt(aux);
        int cost = scan.nextInt();
        // adaugarea restrictiei pe strada data
        addRestriction(actiune, xAxis, yAxis, cost);
        scan.nextLine();
    }

    /**
     * La fel ca metoda de mai sus, se realizeaza parsarea din map.in, numai ca
     * de aceasta data se urmareste cazul in care dorim afisarea drumului de la
     * un punct de start catre un punct final dorit
     *
     * @param output este folosit pentru afisarea drumului in map.out
     */
    public void CitesteDrive(FileWriter output) {
        Vehicul vehicle;
        // se verifica tipul de vehicul, pentru a crea obiectul respectiv
        char mijlocTransport = scan.next().charAt(0);
        if(mijlocTransport == 'a') {
            vehicle = new Autoturism();
        }
        else if(mijlocTransport == 'b') {
            vehicle = new Bicicleta();
        }
        else if(mijlocTransport == 'c') {
            vehicle = new Camion();
        }
        else {
            vehicle = new Motocicleta();
        }
        // din nou, o parsare corespunzatoare din map.in
        String aux = scan.next();
        aux = aux.substring(1);
        int xAxis = Integer.parseInt(aux);
        aux = scan.next();
        aux = aux.substring(1);
        int yAxis = Integer.parseInt(aux);
        if(scan.hasNextLine()) {
            scan.nextLine();
        }
        // apelam metoda drive, care nu face nimic altceva decat sa aplice
        // Dijkstra cu o coada de prioritati self-made (pentru bonus, se stie)
        // urmand ca apoi sa afiseze drumul cu costul cel mai mic
        drive(vehicle, xAxis, yAxis, output);
    }

    /**
     * Metoda care implementeaza algoritmul Dijkstra cu cozi. Afla drumul de cost
     * minim de la un punct dat la alt punct. De asemenea, este afisata si calea
     * de la punctul de inceput la cel de sfarsit, cale specifica costului.
     *
     * @param vehicle tipul de vehicul cu care se realizeaza deplasarea de la
     *                punctul de start la cel de final; influenteaza costul
     * @param start punctul de inceput
     * @param stop punctul de final
     * @param output avem nevoie de acest obiect pentru a scrie rezultatul in
     *               fisierul map.out
     */
    public void drive(Vehicul vehicle, int start, int stop, FileWriter output) {
        // vector care detine distanta(costul) fiecarui punct la cel de start
        int[] distante = new int[this.numarTotalNoduri];
        // punctul anterior pentru fiecare punct de pe harta
        int[] anterior = new int[this.numarTotalNoduri];
        // coada noastra de prioritati, care retine index-ul punctului de pe harta
        // (numarul de la P9, de exp) si costul punctului fata de punctul de start
        MyPriorityQueue coada = new MyPriorityQueue();
        // initializare cu "infinit"
        for(int i = 0; i < this.numarTotalNoduri; i++) {
            distante[i] = Integer.MAX_VALUE;
        }
        // costul punctului de start este mereu 0
        distante[start] = 0;
        // punctul de start nu are un anterior
        anterior[start] = -1;
        // mereu se adauga nodul de start in coada la inceput
        coada.adaugareCuPrioritate(0, start);
        // cat timp coada nu este vida, luam vecinii nodului curent
        while(coada.dimensiune() != 0) {
            MyPriorityQueue.Nod nod = coada.elimina();
            int pozitieGraf = nod.getPozitieGraf();
            // verificam vecinii nodului curent
            for(int j = 0; j < this.numarTotalNoduri; j++) {
                // daca nu exista acel nod sau limita de gabarit este depasita,
                // se trece mai departe
                if(this.harta[pozitieGraf][j] == null ||
                    vehicle.gabarit > this.harta[pozitieGraf][j].
                            getLimitaGabarit()) {
                    continue;
                }
                int costVecin = this.harta[pozitieGraf][j].getCostStrada() *
                    vehicle.getCost() +
                    this.harta[pozitieGraf][j].getCostAmbuteiaje();
                // daca exista un drum de la punctul de start la cel curent mai
                // scurt decat cel deja existent, il actualizam
                if(distante[j] > distante[pozitieGraf] + costVecin) {
                    distante[j] = distante[pozitieGraf] + costVecin;
                    anterior[j] = pozitieGraf;
                    // introducem acest cod in coada, pentru a continua algoritmul
                    coada.adaugareCuPrioritate(distante[j], j);
                }
            }
        }
        // Aici se realizeaza afisarea drumului de cost minim
        try {
            output = new FileWriter("map.out", true);
            if(distante[stop] == Integer.MAX_VALUE) {
                output.write("P" + start + " P" + stop + " null\n");
                output.close();
                return;
            }

            Afiseaza(anterior, stop, output);
            output.write("P" + stop + " " + distante[stop] + "\n");
            output.close();
        }
        catch (IOException e) {
            System.out.println("Nu gasesc fisier in pana mea");
            e.getStackTrace();
        }

    }

    /**
     * Metoda care afiseaza drumul de cost minim de la sfarsit catre inceput,
     * adica de la punctul de stop la cel de start. Prin urmare se foloseste
     * un apel recursiv, pentru a nu ne mai defini un tip stiva
     *
     * @param anterior vectorul de puncte anterioare fiecarui alt punct
     *                 punctul de start are anterior -1 (adica nu are)
     * @param index indexul curent care urmeaza sa fie afisat
     * @param output avem nevoie de acest obiect pentru a scrie rezultatul in
     *               fisierul map.out
     */
    public void Afiseaza(int[] anterior, int index, FileWriter output) {
        if(anterior[index] == -1) {
            return;
        }
        Afiseaza(anterior, anterior[index], output);
        try {
            output = new FileWriter("map.out", true);
            output.write("P" + anterior[index] + " ");
            output.close();
        }
        catch (IOException e) {
            System.out.println("Nu gasesc fisier");
        }
    }

    /**
     * In cele de mai jos avem getteri si setteri pentru campurile private
     * definite la inceputul clasei. De si nu le folosim absolut nicaieri, este
     * de bun augur sa le avem deja definite
     */

    public int getNumarTotalNoduri() {
        return numarTotalNoduri;
    }

    public void setNumarTotalNoduri(int numarTotalNoduri) {
        this.numarTotalNoduri = numarTotalNoduri;
    }

    public int getNumarTotalStrazi() {
        return numarTotalStrazi;
    }

    public void setNumarTotalStrazi(int numarTotalStrazi) {
        this.numarTotalStrazi = numarTotalStrazi;
    }

}
