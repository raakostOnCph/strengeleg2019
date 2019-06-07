import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {


        String fileNavn = "tekstfil.txt";


        StringBuilder stringBuilder1 =
                new StringBuilder("hej med dig, jeg ville lige høre hvordan " +
                        "det går med dig. det her ser sgu da fedt ud ");



            skriv(stringBuilder1.toString(),fileNavn);



        System.out.println(changeWord(stringBuilder1.toString(), "dig", "eder"));


        String[] strings = splitString(stringBuilder1);

        for (String s : strings) {
            System.out.println(s);
        }


        System.out.println(maxWordIndex(strings));

        System.out.println(strings[maxWordIndex(strings)]);

        String konsonanter = "qwrtpsdfghjklzxcvbnm";
        String vokaler = "aeyuioåæø";



//        String test = "nikolaj";
//        StringBuilder testOrd = new StringBuilder(test);
//        System.out.println(findeLetters(vokaler, "bibliotek"));

        System.out.println(isOfLetterType(konsonanter, 'r'));

        System.out.println(findeLettersOfTyoe(konsonanter, "bibliotek"));

    }

    // er et bogstav en vokal eller en konsonant.
    public static boolean isOfLetterType(String bogstavTyper, char c ) {

        StringBuilder bogstaver = new StringBuilder(bogstavTyper);

        if(bogstaver.indexOf(String.valueOf(c)) > -1  ) {
            return true;
        }
        return false;
    }

    private static String findeLettersOfTyoe(String bogstaverType, String ord) {

        StringBuilder bogstaver = new StringBuilder(bogstaverType);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ord.length(); i++) {

//            if (bogstaver.indexOf(String.valueOf(ord.charAt(i))) > -1)
            if (isOfLetterType(bogstaverType,ord.charAt(i)))
            {
//                System.out.println(String.valueOf(ord.charAt(i)));
                stringBuilder.append(ord.charAt(i));
            }
        }
        return stringBuilder.toString();


    }



    private static String læsFraFil(String sti) throws IOException {
        return new String ( Files.readAllBytes( Paths.get("samplefile2.txt") ) );
    }

    private static void skriv(String indhold, String sti ) throws IOException {


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(sti);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.write(indhold);
        fileWriter.close();
    }



    public static int maxWordIndex(String[] strings) {

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

    public static String changeWord(String s, String word, String nyt) {

        StringBuilder stringBuilder = new StringBuilder(s);

        int startIndex = stringBuilder.indexOf(word);
        int slutIndex = startIndex + word.length();

//        stringBuilder.delete(startIndex, slutIndex );
//
//        stringBuilder.insert(startIndex,nyt);

        stringBuilder.replace(startIndex, slutIndex, nyt);
        return stringBuilder.toString();
    }

    public static char[] changeChars(String s) {
        char[] chars = s.toCharArray();

        char[] charRes = new char[s.length()];

        for (char c : chars) {

            if (c == 'i') c = 'x';
            ;

            charRes = chars.clone();
        }
        return charRes;
    }

    public static String changeChar(String s, char o, char n) {

        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < stringBuilder.length(); i++) {

            if (stringBuilder.charAt(i) == o) {
                stringBuilder.setCharAt(i, n);
            }


        }
        return stringBuilder.toString();
    }

    public static int charCount(String s, char c) {

        char[] chars = s.toCharArray();

        int antal = 0;

        for (char CinS : chars) {

            if (CinS == 'i') antal++;
        }
        return antal;
    }
}
