// 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
// 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. 
// Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
// 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. 
// Фамилии, имена, отчества, возрас и пол в отдельных списках.
// 4.Отсортировать по возрасту используя дополнительный список индексов.





package Java.HW.JHW4;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();


        String text = "";
        try {
            FileWriter fw = new FileWriter("bd.sql", true);
            fw.append("Иванов Иван Иванович 48 М \r\n");
            fw.append("Петрова Валерия Павловна 24 Ж \r\n");
            fw.flush();
            fw.close();

            FileReader fr = new FileReader("bd.sql");
            while (fr.ready()) {
                text += (char) fr.read();

            }
//            System.out.println(fr);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] textarr = text.split(" \r\n");
        for (int i = 0; i < textarr.length; i++) {
            String[] ts = textarr[i].split(" ");
            System.out.println(ts[0] + " " + ts[1].charAt(0) + "." + ts[2].charAt(0) + "." + " " + ts[3] + " " + ts[4]);

            family.add(ts[0]);
            name.add(ts[1]);
            soname.add(ts[2]);
            age.add(Integer.valueOf(ts[3]));
            gender.add(ts[4].equals("М") ? true : false);
            index.add(i);

        }
        System.out.println();
        System.out.println(family);
        System.out.println(name);
        System.out.println(soname);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(index);


//        List<? extends ArrayList<? extends Serializable>> ages = Arrays.asList(family, age);
//        Collections.sort(ages, Collections.reverseOrder());
//        System.out.println(ages);


//        for (int i = 0; i < age.size() - 1; i++) {
//            for (int j = 0; j < age.size() - i - 1; j++) {
//                if (age.get(j + 1) < age.get(j)) {
//                    int swap = index.get(j);
//                    index.get(j) = index.get(j + 1);
//                    index.get(j + 1) = swap;
//                }
//            }
//        }
        
        
//        for (int i = 0; i < index.size(); i++) {
//            Collections.sort(age);
//            System.out.println(index.get(i) + " " + name.get(index.get(i)) + ", " + age.get(index.get(i)));
//        }

        for (int j = 0; j < index.size(); j++) {
            System.out.printf(family.get(index.get(j)));
            System.out.printf(name.get(index.get(j)));
            System.out.printf(soname.get(index.get(j)));
            System.out.printf(age.get(index.get(j)).toString());
            System.out.printf(gender.get(index.get(j)) ? " М" : " Ж");
            System.out.println();

        }
    }

}