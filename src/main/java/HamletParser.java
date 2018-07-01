import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeWord(String search, String replace){
        String upperCaseS = search.toUpperCase();
        String upperCaseR = replace.toUpperCase();
        String lowerCaseSwapped = replaceWord(search, replace, hamletData);
        return replaceWord(upperCaseS, upperCaseR, lowerCaseSwapped);
    }

    public String replaceWord(String search, String replace, String text){
        Pattern patt = Pattern.compile("\\b" +search + "\\b");
        Matcher m = patt.matcher(text);
        return m.replaceAll("" + replace + "");
    }


    public int findWord(String hamletData, String search) {
        Pattern patt = Pattern.compile( search , Pattern.CASE_INSENSITIVE);
        Matcher m = patt.matcher(hamletData);
        int count = 0;
     while (m.find()) {
         count++;
     }
     return count;
    }

}
