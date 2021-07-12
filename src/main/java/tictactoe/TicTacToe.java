package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> posisiPlayer = new ArrayList<Integer>();
    static ArrayList<Integer> posisiCpu = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] board = {
            {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '}
        };

        cetakPapan(board);

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Choose your position [1-25] : ");
            int posPlayer = sc.nextInt();
            while (posisiPlayer.contains(posPlayer) || posisiCpu.contains(posPlayer)) {                
                System.out.println("Alredy filled");
                System.out.println("Re Choose your possition");
                posPlayer = sc.nextInt();
            }
            String pemain = "player";
            System.out.println("You Choose Position " + posPlayer);
            giliran(board, posPlayer, pemain);
            String hasil = kondisiMenang();
            if (hasil.length() > 0 ){
                cetakPapan(board);
                System.out.println(hasil);
                break;
            }

            Random random = new Random();
            pemain = "COM";
            int posCpu = random.nextInt(25) + 1;
            while (posisiPlayer.contains(posCpu) || posisiCpu.contains(posCpu)) {                
                posCpu = random.nextInt(25) + 1;
            }
            System.out.println("Computer Choose " + posCpu);
            giliran(board, posCpu, pemain);
            hasil = kondisiMenang();
            if (hasil.length() > 0 ){
                cetakPapan(board);
                System.out.println(hasil);
                break;
            }

            cetakPapan(board);
            System.out.println("");
        }

    }

    public static void cetakPapan(char[][] papan) {
        for (char[] x : papan) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println("");
        }

    }

    public static void giliran(char[][] papan, int pos, String pemain) {
        char simbol = ' ';
        if (pemain.equalsIgnoreCase("player")) {
            simbol = 'X';
            posisiPlayer.add(pos);
        } else if (pemain.equalsIgnoreCase("com")) {
            simbol = 'O';
            posisiCpu.add(pos);
        }

        switch (pos) {
            case 1:
                papan[0][0] = simbol;
                break;
            case 2:
                papan[0][2] = simbol;
                break;
            case 3:
                papan[0][4] = simbol;
                break;
            case 4:
                papan[0][6] = simbol;
                break;
            case 5:
                papan[0][8] = simbol;
                break;
            case 6:
                papan[2][0] = simbol;
                break;
            case 7:
                papan[2][2] = simbol;
                break;
            case 8:
                papan[2][4] = simbol;
                break;
            case 9:
                papan[2][6] = simbol;
                break;
            case 10:
                papan[2][8] = simbol;
                break;
            case 11:
                papan[4][0] = simbol;
                break;
            case 12:
                papan[4][2] = simbol;
                break;
            case 13:
                papan[4][4] = simbol;
                break;
            case 14:
                papan[4][6] = simbol;
                break;
            case 15:
                papan[4][8] = simbol;
                break;
            case 16:
                papan[6][0] = simbol;
                break;
            case 17:
                papan[6][2] = simbol;
                break;
            case 18:
                papan[6][4] = simbol;
                break;
            case 19:
                papan[6][6] = simbol;
                break;
            case 20:
                papan[6][8] = simbol;
                break;
            case 21:
                papan[8][0] = simbol;
                break;
            case 22:
                papan[8][2] = simbol;
                break;
            case 23:
                papan[8][4] = simbol;
                break;
            case 24:
                papan[8][6] = simbol;
                break;
            case 25:
                papan[8][8] = simbol;
                break;
            default:
                break;
        }
    }
    
    public static String kondisiMenang(){
        
        List barisA  = Arrays.asList(1,2,3,4,5);
        List barisB  = Arrays.asList(6,7,8,9,10);
        List barisC  = Arrays.asList(11,12,13,14,15);
        List barisD  = Arrays.asList(16,17,18,19,20);
        List barisE  = Arrays.asList(21,22,23,24,25);
        List column1 = Arrays.asList(1,6,11,16,21);
        List column2 = Arrays.asList(2,7,12,17,22);
        List column3 = Arrays.asList(3,8,13,18,23);
        List column4 = Arrays.asList(4,9,14,19,24);
        List column5 = Arrays.asList(5,10,15,20,25);
        List diag1 = Arrays.asList(1,7,13,19,25);
        List diag2 = Arrays.asList(5,9,13,17,21);

        List<List> menang = new ArrayList<>();
        menang.add(barisA);
        menang.add(barisB);
        menang.add(barisC);
        menang.add(barisD);
        menang.add(barisE);
        menang.add(column1);
        menang.add(column2);
        menang.add(column3);
        menang.add(column4);
        menang.add(column5);
        menang.add(diag1);
        menang.add(diag2);
        
        for(List z : menang){
            if (posisiPlayer.containsAll(z)){
                return "Congratulations !!";
            } else if (posisiCpu.containsAll(z)){
                return "Sorry You Are Lose T.T";
            } else if (posisiPlayer.size()+ posisiCpu.size() == 25){
                return "DRAW!";
            }
        }
        
        return "";
    }
    
    /*
    public static void main (String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("TIC-TAC-TOE Mini Games");
      System.out.println("Choose Mode");
      System.out.println("1. 3x3 ");
      System.out.println("2. 5x5 ");
      System.out.println("3. 9x9 ");
      String option = input.nextLine();
      
      
        switch (option) {
            case "1":
                //TicTacToe TicTacToeobj= new TicTacToe();
                //TicTacToeobj.data();
                System.out.println("1");
                
                System.exit(0);
                break;
            case "2":
                System.exit(0);
                break;
            default:
                break;
        */


}
