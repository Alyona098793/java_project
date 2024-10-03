package com.start;
import java.util.Arrays;
import java.util.Random;


public class Main {
    /*
    static double myMethod() {

        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101); // Випадкове число від 0 до 100
        }

        double length = array.length;
        int sum = 0;
        int dob = 1;

        for (int i = 0; i < array.length; i++){
             sum +=array[i];
             dob *=array[i];
        }

        //визначаємо середнє геометричне та арифметичне
        double sGeom = Math.pow(dob, 1.0 / length);
        double sAryf = sum/length;

        //визначаємо sAryf різницю між та sGeom
        double result = sAryf - sGeom;

        // Виводимо масив
        System.out.println("Масив: " + Arrays.toString(array));


        //створюємо новий масив без одного елемента
        int array1 [] = new int[array.length-1];

        int numDelete = random.nextInt(20);// Генерує випадкове число від 0 до 20 який елемент буде видалено

        for (int i = 0; i < array.length; i++) {
            if (i == numDelete) {continue;}
            else if (i > numDelete) {
                array1[i-1] = array[i];
            }
            else {array1[i] = array[i];}
        }
        // Виводимо масив 1
        System.out.println("Масив: " + Arrays.toString(array1));

        return result;

    }*/
    public static void main(String[] args) {

        CreateMatrix.declareMatrix();

    }
}

 class CreateMatrix{
    public static int[][] generateRandomMatrix(int rows, int cols) {

        int [][] arrayMatrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for( int x = 0; x < cols; x++){
                arrayMatrix[i][x] = random.nextInt(101);
            }
        }

        return arrayMatrix;
    }

    public static void declareMatrix() {

        int rows = 5; // Кількість рядків
        int cols = 4; // Кількість стовпців
        int[][] matrix = generateRandomMatrix(rows, cols);

        //виводимо згенеровану матрицю
        System.out.println("Згенерована матриця:");
        for (int i = 0; i < rows; i++) {
            System.out.print("рядок" + i + " ");
            for( int x = 0; x < cols; x++){
                System.out.print(matrix[i][x] + " ");
            }
            System.out.println();
        }

        //створюємо  масив, елементи якого дорівнюють сумі цифр чисел, розташованих по кромці випадково заповненої матриці.

        int[] arrSumm = new int[4];

        for(int i = 0; i < rows; i++) {
            for (int x = 0; x < cols; x++) {
                if (x == 0) {
                    arrSumm[3] += matrix[i][x];
                }
                else continue;
            }
        }
        for(int i = 0; i < rows; i++) {
           for (int x = 0; x < cols; x++) {
               if (i == (rows - 1)) {
                   arrSumm[2] += matrix[i][x];}
               else continue;
           }
        }
        for(int i = 0; i < rows; i++) {
           for (int x = 0; x < cols; x++) {
               if (x == (cols - 1)) {
                   arrSumm[1] += matrix[i][x];
               }
               else continue;
           }
        }
        for(int i = 0; i < rows; i++) {
           for (int x = 0; x < cols; x++) {
               if (i == 0) {
                   arrSumm[0] += matrix[i][x];
               }
               else continue;
           }
        }

        //виводимо згенеровану матрицю
        for (int k = 0; k < arrSumm.length;k++){
            System.out.println(arrSumm[k] + " ");
        }

        //перевертаємо матрицю навколо вертикальної осі
        int[][] reversedMatrix = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int k = 0, x = cols - 1; k < cols && x >= 0; k++, x--) {
                reversedMatrix[i][x] = matrix[i][k];
            }
        }

        //виводимо згенеровану матрицю
        System.out.println("Перевернута згенерована матриця:");
        for (int i = 0; i < rows; i++) {
            System.out.print("рядок" + i + " ");
            for( int x = 0; x < cols; x++){
                System.out.print(reversedMatrix[i][x] + " ");
            }
            System.out.println();
        }
    }


}



