import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Toolkit is used as a class to draw variables and subclasses across different classes
 */
public class Toolkit {
    // Create a toolkit using seed passed in
    Toolkit(long seed){
        //System.out.println("[+] Toolkit created.");


        rand = new Random(seed);
        //System.out.println(rand.nextDouble());


    }
    int getPopSize(){
        double r = rand.nextDouble();
        if (r <0.33){
            return popSize[0];
        }
        else if (r <0.67){
            return popSize[1];
        }
        else{
            return popSize[2];
        }
    }

    int getTourSize(){
        double r = rand.nextDouble();
        if (r <0.25){
            return tourSize[0];
        }
        else if (r <0.5){
            return tourSize[1];
        }
        else if (r <0.75){
            return tourSize[2];
        }
        else {
            return tourSize[3];
        }
    }

    String getRandomFunction(){
        double r = rand.nextDouble();
        if (r <0.167){
            return functionSet[0];
        }
        else if (r <0.33){
            return functionSet[1];
        }
        else if (r <0.5){
            return functionSet[2];
        }
        else if (r <0.67){
            return functionSet[3];
        }
        else if (r <0.83){
            return functionSet[4];
        }
        else {
            return functionSet[5];
        }
    }

    String getRandomTerminal(){
        double r = rand.nextDouble();
        if (r <0.2){
            return terminalSet[0];
        }
        else if (r <0.4){
            return terminalSet[1];
        }
        else if (r <0.6){
            return terminalSet[2];
        }
        else if (r <0.8){
            return terminalSet[3];
        }
        else {
            return terminalSet[4];
        }
    }

    List<CovidDataObject> readCSV(String path){
        List<CovidDataObject> toReturn = new ArrayList<CovidDataObject>();
        try {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            row = csvReader.readLine(); //First line. Headings
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                int len = data.length;
                String Province = data[0];
                String Country = data[1];
                String Lat = data[2];
                String Long = data[3];
                for (int i = 4+5; i < len; i++) {
                    toReturn.add(new CovidDataObject(Province, Country, Lat, Long, data[i-5], data[i-4], data[i-3],
                             data[i-2], data[i-1], data[i]));
                }
                //System.out.println(data.length);
                //toReturn.add(data);
                // do something with the data
            }
            csvReader.close();
            return toReturn;
        }
        catch (Exception e){
            System.out.println(e.toString());
            return toReturn;
        }

    }

    int[] popSize = {150, 300, 500};
    int[] tourSize = {2, 4, 6, 8};
    String[] functionSet = {"+", "-", "/", "*", "%", "v/"} ;
    String[] terminalSet = {"x1", "x2", "x3", "x4", "x5"};
    Random rand;
}
