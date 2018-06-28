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

    public String changeHamletToLeon(String search, String replace){
        Pattern patt = Pattern.compile("\\b" +search + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = patt.matcher(hamletData);
        return m.replaceAll(replace);
    }

    public int findWord(CharSequence hamletData ,String search) {
        int count = 0;
        Pattern patt = Pattern.compile("\\b" +search + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = patt.matcher(hamletData);
     while (m.find())
            count++;
     return count;
    }

}
