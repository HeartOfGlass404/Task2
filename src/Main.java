import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String text = readFile("./src/text.txt");
        System.out.println(text);
        String[] lineList = text.split("\n");

        System.out.println("Введите подстроку для поиска");

        String substring = sc.nextLine();
        System.out.println(substring);
       // System.out.println(lineList.length);
       //System.out.println(Arrays.toString(prefixFunction(substring)));
       // System.out.println(search(line,substring));

        for (int i = 0; i< lineList.length;i++){
            if (search(lineList[i],substring)) {
                System.out.println(lineList[i]);
            }
            else System.out.println("Совпадений не найдено");
        }
    }

    private static String readFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        // создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        // создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считываем сначала первую строку
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);

            //lines.add(line);
            sb.append(line).append('\n');
            // считываем остальные строки в цикле
            line = reader.readLine();
        }

        return sb.toString();
    }

    private  static boolean search(String line, String substring){
        boolean found = false;
        int[] prefFunc= prefixFunction(substring);
        int i = 0;
        int j = 0;
        while (i<line.length()){
            if (substring.charAt(j) == line.charAt(i)){
                j++;
                i++;
            }
            if(j == substring.length()){
                found = true;
                j = prefFunc[j-1];
            }
            else if (i<line.length() && substring.charAt(j) != line.charAt(i)){
                if (j != 0){
                    j = prefFunc[j-1];
                }
                else {
                    i = i + 1;
                }
            }
        }

        return found;
    }

    static int[] prefixFunction(String substring){
        int[] values = new int[substring.length()];
        for (int i=1; i<substring.length();i++){
            int j=0;
            while (i + j < substring.length() && substring.charAt(j) == substring.charAt(i + j)) {
                values[i + j]=Math.max(values[i + j], j + i);
                j++;
            }
        }
        return values;
    }

}