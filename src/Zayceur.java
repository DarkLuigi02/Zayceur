import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Collectors;

public class Zayceur {

    String[][] salle;
    int tours;
    int n;
    int nbrinfecte;
    List<Integer> infecte=new List<Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Integer integer) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Integer get(int index) {
            return null;
        }

        @Override
        public Integer set(int index, Integer element) {
            return null;
        }

        @Override
        public void add(int index, Integer element) {

        }

        @Override
        public Integer remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            return null;
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    List<int[]> ints = new List<int[]>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<int[]> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(int[] ints) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends int[]> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends int[]> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public int[] get(int index) {
            return new int[0];
        }

        @Override
        public int[] set(int index, int[] element) {
            return new int[0];
        }

        @Override
        public void add(int index, int[] element) {

        }

        @Override
        public int[] remove(int index) {
            return new int[0];
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<int[]> listIterator() {
            return null;
        }

        @Override
        public ListIterator<int[]> listIterator(int index) {
            return null;
        }

        @Override
        public List<int[]> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

        public void init(){//initialise l'application
            tours =0;
            nbrinfecte=0;
            infecte.clear();
            ints.clear();
            System.out.println("Initialiser le plateau");
            System.out.println("Saisir la dimension du plateau");
            n=Fonction.saisirInt();
            while (n<3){
                System.out.println("le plateau n'est pas valide");
                n=Fonction.saisirInt();
            }
            salle = new String[n][n];
            for (int i=0; i<salle.length;i++){
                for (int j=0; j<salle.length;j++){
                        salle[i][j]="'";
                }
            }
        }

        public void initCoordonnées(){ //Code Principal
            int y = 0,x=0;
            boolean debut=false;
            boolean fin=false;
            init();
            System.out.println("Saisisez La Position du/des patient 0");
            sortirPlateau(this.salle);
            while (debut==false){
                System.out.println("Veuillez Saisir x (entre 0 et "+ (salle.length-1)+")");
                x=saisirXY(salle);
                System.out.println("Veuillez Saisir y (entre 0 et "+ (salle.length-1)+")");
                y=saisirXY(salle);
                if (salle[y][x].equals("*")){
                    System.out.println("Il est deja infecté");
                }else{
                    assigner(salle,x,y);
                ints.add(new int[]{x, y});
                nbrinfecte++;
                }
                sortirPlateau(salle);
                debut=stop();
            }
            System.out.println("Etape 0");
            sortirPlateau(this.salle);
            infecte.add(nbrinfecte);
            while(fin==false){
                tours++;
                générationSuivante(salle);
                System.out.println("Etape "+ tours);
                sortirPlateau(this.salle);
                fin=arret();
            }
            System.out.print("Resultat : ");
            for (int intValue : infecte) {
                System.out.println(intValue);
            }
        }

        public static List<Integer> virus(List<int[]> patients0, int n){
            return null;
        }



        public void sortirPlateau(String[][] plateau) { //afficher le plateau
            for (int i=0; i< plateau.length;i++){
                for (int j=0; j<plateau.length;j++){
                    System.out.print(plateau[i][j]);
                }
                System.out.println();
            }
        }
        public void voisin(String[][] plateau, Integer x, Integer y){ //modifier les voisin de la valeur
            if (x==0){
                if (y==0){
                    assigner(plateau,x+1,y);
                    assigner(plateau,x,y+1);
                }
                else if(y==(plateau.length-1)){
                    assigner(plateau,x+1,y);
                    assigner(plateau,x,y-1);
                }
                else{
                    assigner(plateau,x+1,y);
                    assigner(plateau,x,y+1);
                    assigner(plateau,x,y-1);
                }
            }
            else if (x==(plateau.length-1)){
                if (y==0){
                    assigner(plateau,x-1,y);
                    assigner(plateau,x,y+1);
                }
                else if (y==(plateau.length-1)){
                    assigner(plateau,x-1,y);
                    assigner(plateau,x,y-1);
                }
                else{
                    assigner(plateau,x-1,y);
                    assigner(plateau,x,y+1);
                    assigner(plateau,x,y-1);
                }
            }
            else{
                if (y==0){
                    assigner(plateau,x-1,y);
                    assigner(plateau,x+1,y);
                    assigner(plateau,x,y+1);
                }
                else if(y==(plateau.length-1)){
                    System.out.println("g");
                    assigner(plateau,x-1,y);
                    assigner(plateau,x+1,y);
                    assigner(plateau,x,y-1);
                }
                else{
                    System.out.println("h");
                    assigner(plateau,x,y-1);
                    assigner(plateau,x,y+1);
                    assigner(plateau,x-1,y);
                    assigner(plateau,x+1,y);
                }
            }
        }

        public void assigner(String[][] plateau, Integer x, Integer y){//assigner une valeur a l'endroit voulue
                plateau[x][y]="*";
        }

        public void générationSuivante(String[][] plateau){ //permet de passez d'une etape a une autre //fonction restant a modifiée
            String [][] temp = plateau;
            for (int i=0;i<plateau.length;i++){
                for (int j=0;j<plateau.length;j++){
                    if (temp[i][j].equals("*")){
                        voisin(plateau,i,j);// tous ce qui est infèrieux est modifièe
                        ints.add(new int[]{i, j});
                        nbrinfecte++;
                    }
                }
            }
            infecte.add(nbrinfecte);
        }

        public Integer saisirXY(String[][] damier) {//saisir la valeur
            Scanner input = new Scanner(System.in);
            Integer i;
            try {
                i = input.nextInt();
                if(i<0 || i>=damier.length){
                    System.out.println("Vous devez saisir une valeur entre 0 et "+(damier.length-1)+". Recommencez");
                    i = saisirXY(damier);
                }
            } catch (Exception e) {
                System.out.println("Erreur dans la saisie. Recommencez.");
                i = saisirXY(damier);
            }
            return i;
        }


        // fonction pour arreter l'initialisation manuelle
        public Boolean stop(){
            Scanner input = new Scanner(System.in);
            String fin;
            Boolean finInit;
            System.out.println("Voulez ajouter un patient (o/n)");
            fin = input.next();
            if(fin.equals("o")){
                finInit=false;
            }else if (fin.equals("n")){
                finInit=true;
            }else {
                System.out.println("Erreur dans la réponse");
                finInit = stop();
            }
            return finInit;
        }
        //fonction pour arreter le code de se lancer jusqu'a qu'une chaine de caractère soit envoyé
        public boolean arret(){
            boolean boo = true;
            Scanner input = new Scanner(System.in);
            String fin;
            System.out.println("");
            fin = input.next();
            for (int a=0; a<salle.length; a++){
                for (int b=0; b<salle.length; b++){
                    if (salle[b][a].equals("'")) {
                        boo=false;
                    }
                }
            }return boo;
        }

        public static void main(String[] args) throws InterruptedException {//lancer l'application
            afficheTitre();
            Zayceur jeu=new Zayceur();
            jeu.initCoordonnées();
        }

        private static void afficheTitre() {//afficher le titre en tag
            // http://patorjk.com/software/taag/

            System.out.println(
                            "__________                                                \n"+
                            "\\____    /_____    ___.__.  ____    ____   __ __  _______  \n"+
                            "  /     / \\__  \\  <   |  |_/ ___\\ _/ __ \\ |  |  \\ \\_  __ \\ \n"+
                            " /     /_  / __ \\_ \\___  |\\  \\___ \\  ___/ |  |  /  |  | \\/ \n"+
                            "/_______ \\(____  / / ____| \\___  > \\___  >|____/   |__|    \n"+
                            "        \\/     \\/  \\/          \\/      \\/                 \n");




        }
}
