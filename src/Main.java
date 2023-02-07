import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> sameFirstAsLast = new ArrayList<String>();
        ArrayList<String> sameFirstAsLastDecimal = new ArrayList<String>();
        ArrayList<Integer> RisingNumbers = new ArrayList<Integer>();

        String path = "C:\\Users\\Kuba\\IdeaProjects\\zad6matura\\src\\dane.txt";
        File dane = new File(path);
        Scanner read = new Scanner(dane);
        while (read.hasNextLine()) {
            int amountOfRising = 0;
            String data = read.nextLine();
            int length = data.length();
            int decimal = Integer.parseInt(data,8);
            String decimalString = Integer.toString(decimal);
            if(data.charAt(0)==data.charAt(length-1)){
                sameFirstAsLast.add(data);
            };
            if(decimalString.charAt(0)==decimalString.charAt(decimalString.length()-1)){
                sameFirstAsLastDecimal.add(decimalString);
            }
            for(int i=0; i < length; i++){
                if(amountOfRising==length-1){
                    int dataInt = Integer.parseInt(data);
                    RisingNumbers.add(dataInt);
                    break;
                }
                else if(i==length && amountOfRising!=length-1){
                    break;
                }
                else if(data.charAt(i+1) >= data.charAt(i)){
                    amountOfRising++;
                }
                else{
                    amountOfRising=0;
                    break;
                }
            }
        }
        System.out.println("Numbers where the first and the last number is the same from dane.txt");
        System.out.println(sameFirstAsLast);
        System.out.println("amount of these numbers:");
        System.out.println(sameFirstAsLast.size());
        System.out.println("Numbers where the first and the last number is the same from the first numbers after being converted to decimal");
        System.out.println(sameFirstAsLastDecimal);
        System.out.println("amount of these numbers:");
        System.out.println(sameFirstAsLastDecimal.size());
        System.out.println("Biggest number that always has a letter that is bigger or the same: " +  Collections.max(RisingNumbers));
        System.out.println("Smallest number that always has a letter that is bigger or the same: " + Collections.min(RisingNumbers));
        read.close();
    }
}