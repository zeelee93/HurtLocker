package leeZac;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    String output = "";


    Milk milk = new Milk();
    Bread bread = new Bread();
    Cookies cookies = new Cookies();
    Apples apples = new Apples();

    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public String makeErrorMessage() {
        int totalErrors = milk.getErrors() + bread.getErrors() + apples.getErrors() + cookies.getErrors();
        String totalError = "" + totalErrors + " times";
        String message = String.format("%s %16s %s", "Errors", "seen: ", totalError);
        return message;
    }

    public String makeOutput(String string) {
        output += milk.makeOutputString(string);
        output += bread.makeOutputString(string);
        output += cookies.makeOutputString(string);
        output += apples.makeOutputString(string);
        output += makeErrorMessage();
        return output;
    }


    public static void main(String[] args) throws Exception{

        Main main = new Main();
        String rawData = main.readRawDataToString();

        System.out.println(main.makeOutput(rawData));








    }
}
