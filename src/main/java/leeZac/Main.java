package leeZac;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    String output = "";
    int totalErrors = 0;

    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public String makeErrorMessage(String str) {
        totalErrors = findErrors(str);
        String message = String.format("%s %17s %s", "Errors", "seen: ", totalErrors + " times");
        return message;
    }


    public String makeOutput(String string) {
        output += new GroceryItem("Milk").makeOutputString(string);
        output += new GroceryItem("Bread").makeOutputString(string);
        output += new GroceryItem("Cookies").makeOutputString(string);
        output += new GroceryItem("Apples").makeOutputString(string);
        output += makeErrorMessage(string);
        return output;
    }

    public int findErrors(String str) {
        String regex = "(:;)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception{

        Main main = new Main();
        String rawData = main.readRawDataToString();
        System.out.println(main.makeOutput(rawData));

    }
}
