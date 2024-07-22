import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile {
    //Hàm đọc file
    public static List<Double> readFile(String filePath){
        String[] tokens;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line= br.readLine();
            tokens = line.trim().split("\\s");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        List<Double> numbers = new ArrayList<>();
        for(int i=0; i< tokens.length; i++){
            if(!tokens[i].isEmpty()){
                numbers.add(Double.parseDouble(tokens[i]));
            }
        }
        return numbers;
    }
    //Hàm viết file
    public static void writeFile(String filePath, String n){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(filePath))){
            br.write(n);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
