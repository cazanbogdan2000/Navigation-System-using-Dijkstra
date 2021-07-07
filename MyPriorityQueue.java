/**
 * Aceasta clasa a fost realizata cu precadere pentru a servi doar acestei teme;
 * nu se garanteaza ca va putea fi folosita si in alte cazuri, nefiind generica.
 * Functioneaza perfect cu implementarea algoritmului Dijkstra din clasa MyMap,
 * cu precadere in metoda drive
 */

public class MyPriorityQueue {
    /**
     * Variabile definitorii pentru o coada (fie ea de prioritati sau nu, e un
     * must have)
     */
    private Nod varf;
    private Nod coada;
    private int contor;

    /**
     * Constructor pentru un obiect de tip MyPriorityQueue, care initializeaza
     * inceputul, sfarsitul, dar si numarul de elemente
     */
    public MyPriorityQueue() {
        this.varf = null;
        this.coada = null;
        this.contor = 0;
    }

    /**
     * Metoda care ne da numarul de elemente ale cozii
     *
     * @return dimensiunea cozii
     */
    public int dimensiune() {
        return this.contor;
    }

    /**
     * Metoda care face inserarea in coada dupa prioritate; in cazul nostru,
     * unica prioritate este aceea legata de cost -> costul cel mai mic are cea
     * mai mare prioritate; din nou, este special facuta pentru aceasta tema, si
     * nu poate fi adaptata (momentan), pentru altfel de cazuri
     *
     * @param cost costul dupa care se va face inserarea in coada
     * @param pozitieGraf pozitia punctului in cadrul grafului din care face parte
     */
    public void adaugareCuPrioritate(int cost, int pozitieGraf) {
        // cazul in care coada este vida
        if (this.contor == 0) {
            Nod aux = new Nod(cost, pozitieGraf);
            this.varf = aux;
            this.coada = this.varf;
            this.contor++;
            return;
        }
        // ajungem la nodul inaintea caruia trebuie sa inseram noul nod
        Nod cursor = this.varf;
        Nod previous = null;
        while (cursor != null && cost > cursor.cost) {
            previous = cursor;
            cursor = cursor.urm;
        }
        //daca trebuie sa inseram la inceputul cozii
        Nod aux = new Nod(cost, pozitieGraf);
        if (previous == null) {
            aux.urm = this.varf;
            this.varf = aux;
            this.contor++;
            return;
        }
        // daca trebuie sa inseram la finalul cozii
        if (cursor == null) {
            this.coada.urm = aux;
            this.coada = this.coada.urm;
            this.contor++;
            return;
        }
        // adugare in rest
        aux.urm = cursor;
        previous.urm = aux;
        this.contor++;
    }

    /**
     * Metoda care elimina un nod din coada, adica de la inceput; echivalent cu
     * dequeue
     *
     * @return nodul care a fost eliminat
     */
    public Nod elimina() {
        this.contor--;
        Nod result = this.varf;
        this.varf = this.varf.urm;
        return result;
    }

    /**
     * Clasa interna, care reprezinta un nod ce se insereaza sau elimina din
     * coada de prioritati pe care am creat-o; detine 3 campuri principale, care
     * descriu un punct de pe harta de strazi: costul, pozitia sa in graf, si
     * de asmenea, campul "urm", care face legatura cu urmatorul nod
     */
    class Nod {
        private int cost; // val nu este nimic altceva decat valoarea costului
        // pozitieGraf este de fapt index-ul nodului in graful dat de harta;
        // este folosit cu precadere pentru a avea posibiliatatea de a afisa si
        // calea catre un anumit nod, si nu doar costul
        private int pozitieGraf;
        private Nod urm;

        /**
         * Constructor Nod
         * @param cost initieaza costul respectivului nod
         * @param pozitieGraf initieaza pozitia pe care il are punctul in graf
         */
        public Nod(int cost, int pozitieGraf) {
            this.pozitieGraf = pozitieGraf;
            this.cost = cost;
            this.urm = null;
        }

        /**
         * Constructor fara parametri
         */
        public Nod() {
            this.urm = null;
        }

        /**
         * Getter pentru costul retinut in Nod
         *
         * @return campul cost din Nod
         */
        public int getCost() {
            return cost;
        }

        /**
         * Metoda care seteaza valoarea costului din campul lui Nod
         *
         * @param cost valoarea costului pe care vrem sa il aiba campul cost
         *             din Nod
         */
        public void setCost(int cost) {
            this.cost = cost;
        }

        /**
         * Getter pentru pozitia din graf a punctului reprezentat prin Nod
         *
         * @return pozitia din graf, pozitieGraf
         */
        public int getPozitieGraf() {
            return pozitieGraf;
        }

        /**
         * Setter pentru pozitia din graf a unui punct
         *
         * @param pozitieGraf valoarea pe care vrem sa o atribuim campului
         *                    pozitieGraf din clasa Nod
         */
        public void setPozitieGraf(int pozitieGraf) {
            this.pozitieGraf = pozitieGraf;
        }
    }
}
