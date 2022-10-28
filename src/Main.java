import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
            String text = readFile("./src/text.txt");
            System.out.println(text);
            String[] linelList = text.split("\n");

            System.out.println("Введите подстроку для поиска");

            String substring = sc.nextLine();
            System.out.println(substring);

            for (int i = 0; i < linelList.length; i++) {
                if (linelList[i].contains(substring)) {
                    System.out.println(linelList[i]);
                } else {
                    System.out.println("Такой подстроки нет");
                    break;
                }
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

    private static void saveWords(Map<String, Integer> words, String str) {
        // перебираем строки
        String[] wordsList = str.split("\\s+");
        // перебираем слова строки
        for (String currentWord : wordsList) {
            // приводим текущее слово в нижний регистр
            currentWord = currentWord.toLowerCase();
            // 1 раз это слово встретилось сейчас
            int count = 1;
            // если слово уже встречалось (добавлено в мапу)
            if (words.containsKey(currentWord)) {
                // то прибавляем кол-во встреч с этим словом к общему кол-ву
                count += words.get(currentWord);
            }

            // сохраняем слово в словарь(если уже встречалось, то обновляем информацию)
            words.put(currentWord, count);
        }
    }

    private static void printResult(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\n");
        }
        System.out.println();
    }

}