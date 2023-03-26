/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangman_game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sakib Sadri
 */
public class Hangman_game {
    static boolean guessletter(String planet_len,char letter , char[] letters,int len){
        boolean right  = false;
        for(int i = 0;i<len;i++){
            char I = planet_len.charAt(i);
            if(I == letter){
                letters[i] = I;
                right = true;
            }
        }
        return right;
    }
    static boolean checkwin(int len,char[] letters){
        boolean finished = true;
        System.out.println("Words :");
        for(int i = 0 ;i<len;i++){
            if(letters[i] == '.'){
                finished = false;
            }
            System.out.print(letters[i]);
        }
        System.out.println();
        return finished;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Let's Go !!!");
        String [] planet = {"mercury","venus","earth","mars","jupiter","saturn","uranus","neptune"};
        int ind = r.nextInt(9);

        String planet_len = planet[ind];
        int len = planet_len.length();
        System.out.println("This Planet have "+len+" words ");
        char letters[];
        letters = new char[len];
        for(int i = 0;i<len;i++){
            letters[i] = '.';}
        int lives = 3;
        while (lives>0) {
            System.out.println( "Lives:");
            for (int i = 0; i < lives; i++) {
                System.out.print("o");
            }


            System.out.println();
            System.out.println("Input: ");
            String input = sc.nextLine();
            char letter = input.charAt(0);

          if (!guessletter(planet_len, letter, letters, len)){
              lives--;

            }
            System.out.println("__________________________");
            if (checkwin(len, letters)) {

                System.out.println("You Won!");
            break;
            }
        }
        if(lives==0){
            System.out.println("You Lost! The Planet is "+planet_len);
        }
        System.out.println("Exit!");

    }


}