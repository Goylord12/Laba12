package com.company;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
//Необходимо доделать приложение из 11 работы, таким образом
//чтобы сведения о введенном ip-адресе записывались в файл, который создается программно в папке с проектом.

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String ip = in.nextLine();


        boolean find;
        int mathcesCount = 0;

        Pattern pattern = Pattern.compile("((^|\\s)(([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.){3}([1-9]+\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d))");
        Matcher m = pattern.matcher(ip);

        try( FileWriter f = new FileWriter("IP.txt")){
            do{
                find = m.find();
                if (find) {
                    f.write(m.group().replace(" ", "") + "\n");
                    System.out.println("IP записан");
                    f.flush();
                    mathcesCount++;
                }
                if(!find & mathcesCount == 0) {
                    System.out.println("Ip адресов не найдено");
                    f.write("IP адресов не найдено :_(");
                }
            }while (find);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());

        }
    }
}
