package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MoneyCalculator {

    /* WARNING in this version, i can't reach the line where the calculated amount is written in the website */
    
    public static void main(String[] args) throws Exception {

        System.out.println("Introduce a quantity in dollars: ");
        Scanner scanner= new Scanner(System.in);
        double amount = Double.parseDouble(scanner.next());
        String amountString= String.valueOf(amount);
        double exchangeRate= getExchangeRate("USD","EUR", amountString );
        System.out.println(amount + " USD equivalent to " + amount*exchangeRate+ "EUR");
       
    }
    
    
    
    private static double getExchangeRate(String from, String to, String amount) throws IOException{
            
        URL url= new URL("https://www.xe.com/it/currencyconverter/convert/?Amount=" + amount + "&From=" + from + "&To="+ to); 
        URLConnection connection = url.openConnection();
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            StringBuilder sb= new StringBuilder();
            while((line= reader.readLine()) != null){
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println("la linea è " + line);
            //String line1= line.substring(line.indexOf(to)+12, line.indexOf("}"));
            //System.out.println("la linea 2 è " + line1);
        return 2.0; 

        }
    }
  
}
