public class Main {

    /**
     * Metoda main in clasa principala Main. Pe cat de simplu arata, pe atat de
     * complexa este; creeaza un graf care reprezinta harta strazilor, si
     * citeste actiunile si le prelucreaza. Am numit actiune tot ce poate
     * modifica graful sau afisa cel mai bun drum intre 2 noduri
     *
     * @param args nu foloseste la nimic in tema noastra
     */
    public static void main(String[] args) {
        MyMap map = new MyMap();
        map.CitesteHarta();
        map.CitesteActiuni();
    }
}
