import java.util.Scanner;

public class Fonction {

    public static int saisirInt(){
        Scanner input = new Scanner(System.in);
        Integer i = input.nextInt();
        return i;
    }

    public static double saisirDouble(){
        Scanner input = new Scanner(System.in);
        double d = input.nextDouble();
        return d;
    }

    public static boolean saisirBoolean(){
        Scanner input = new Scanner(System.in);
        boolean b = input.nextBoolean();
        return b;
    }

    public static String saisirString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }


    public static int random(int min, int max){
        int r;
        r=  min + (int)(Math.random() * ((max - min) + 1));
        return r;
    }

    public static double arrondir (double chiffre, int nbChiffreApresVirgule){
        double chiffreArrond;
        String nbC = "1";
        for (int i=0; i<nbChiffreApresVirgule; i++){
            nbC+="0";
        }
        Integer arrond = Integer.parseInt(nbC);
        chiffreArrond = (double)Math.round(chiffre * arrond) / arrond;
        return chiffreArrond;
    }
}
