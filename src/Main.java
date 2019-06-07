import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {


        String fileNavn = "tekstfil.txt";


        String s = "hej med dig, jeg ville lige høre hvordan " +
                        "det går med dig. det her ser sgu da fedt ud ";


        StringBuilder stringBuilder = new StringBuilder(s);

//
//            skriv(stringBuilder1.toString(),fileNavn);
//
//
//
//        System.out.println(changeWord(stringBuilder1.toString(), "dig", "eder"));
//
//
//        String[] strings = splitString(stringBuilder1);
//
//        for (String s : strings) {
//            System.out.println(s);
//        }
//
//
//        System.out.println(maxWordIndex(strings));
//
//        System.out.println(strings[maxWordIndex(strings)]);

        String konsonanter = "qwrtpsdfghjklzxcvbnm";
        String vokaler = "aeyuioåæø";

//        s = udskiftOrdIStreng(s,"dig","palle");

        System.out.println(s.contains("a"));

        System.out.println(udskiftBogstaverSmart("bibbi", 'b', 'k'));


    }


    public static void bogstavHistogram(String bogstavType, String string ) {

        // denne her var oprindelig en del af kaldet, da vi ellers fik index out of bounds
        // for at gøre det lettere flyttede jeg det her ind, men man kan godt vise udgangspunktet
        String s = findeBogstaverAfTypen(bogstavType,string);


        int[] bogstavcount = new int[bogstavType.length()];



        for (int i = 0; i < s.length(); i++) {

            bogstavcount[bogstavType.indexOf(s.charAt(i))]++;

        }

        for (int i = 0; i < bogstavcount.length; i++) {
            System.out.println(bogstavType.charAt(i) + " findes antal " + bogstavcount[i]);

        }







    }


    // er et bogstav en vokal eller en konsonant.
    public static boolean erBogstavAfTypen(String bogstavTyper, char c) {

        StringBuilder bogstaver = new StringBuilder(bogstavTyper);

        if (bogstaver.indexOf(String.valueOf(c)) > -1) {
            return true;
        }
        return false;
    }

    private static String findeBogstaverAfTypen(String bogstaverType, String ord) {

        StringBuilder bogstaver = new StringBuilder(bogstaverType);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ord.length(); i++) {

//            if (bogstaver.indexOf(String.valueOf(ord.charAt(i))) > -1)
            if (erBogstavAfTypen(bogstaverType, ord.charAt(i))) {
//                System.out.println(String.valueOf(ord.charAt(i)));
                stringBuilder.append(ord.charAt(i));
            }
        }
        return stringBuilder.toString();


    }








    private static String læsFraFil(String sti) throws IOException {
        return new String(Files.readAllBytes(Paths.get("samplefile2.txt")));
    }

    private static void skrivTilFil(String indhold, String sti) throws IOException {


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(sti);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.write(indhold);
        fileWriter.close();
    }


    public static int maxOrdlængde(String[] strings) {

        int maxLength = 0;
        int index = 0;

        for (int i = 0; i < strings.length; i++) {

            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                index = i;
            }

        }

        return index;
    }

    public static String[] splitString(StringBuilder stringBuilder) {

        String[] output = stringBuilder.toString().split(" ");
        return output;
    }

    public static String udskiftOrd(String s, String word, String nyt) {

        StringBuilder stringBuilder = new StringBuilder(s);

        int startIndex = stringBuilder.indexOf(word);
        int slutIndex = startIndex + word.length();

//        stringBuilder.delete(startIndex, slutIndex );
//
//        stringBuilder.insert(startIndex,nyt);

        stringBuilder.replace(startIndex, slutIndex, nyt);
        return stringBuilder.toString();
    }


    public static String udskiftOrdIStreng(String s, String oprindelig, String nyt) {


        return s.replaceAll(oprindelig, nyt);
    }



    public static String udskiftBogstaverSmart(String s, char opr, char nyt) {



        return s.replace(opr, nyt);
    }


    public static String udskiftBogstav(String s, char o, char n) {

        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < stringBuilder.length(); i++) {

            if (stringBuilder.charAt(i) == o) {
                stringBuilder.setCharAt(i, n);
            }


        }
        return stringBuilder.toString();
    }

    public static int TælForekomst(String s, char c) {

        char[] chars = s.toCharArray();

        int antal = 0;

        for (char CinS : chars) {

            if (CinS == 'i') antal++;
        }
        return antal;
    }
}
