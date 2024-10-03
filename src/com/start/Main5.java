package com.start;

import java.util.Scanner;

public class Main5 {

    //переводимо бали в національну шкалу
    public static int[] translateScore(int [] array){

        for (int i = 0; i < array.length; i++){
            if (array[i]<60){
                array[i] = 2;
            } else if (array[i]>=60 & array[i]<75) {
                array[i] = 3;
            } else if (array[i]>=75 & array[i]<90) {
                array[i] = 4;
            } else  {
                array[i] = 5;
            }
        }
        return array;
    }

    //розраховуємо середній бал
    public static void averageCounter(double averageScore){
        if (averageScore>=4 & averageScore<5){
            System.out.println("Студент отримує basic стипендію");
        }else if (averageScore == 5) {
            System.out.println("Студент отримує  hightс типендію");
        }else {
            System.out.println("Студент не отримує not стипендію");
        }
}
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ваше імя: ");
        String name = scanner.nextLine();

        System.out.println("Введіть ваш статус (контракт/бюджет): ");
        String status = scanner.nextLine();


        System.out.print("Введіть кількість предметів: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Введіть ваші оцінки:");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        //переводимо бали в національну шкалу
        translateScore(array);

        //розраховуємо середній бал
        int sum = 0;
            for (int i : array) {
                sum += i;
            }

        double averageScore = sum/ array.length;

            //перевіряємо чи може отримати студет стипендію
        if (status.equalsIgnoreCase("бюджет")){
                averageCounter(averageScore);
        }




        System.out.println("Введений масив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}
