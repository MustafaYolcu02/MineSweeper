import java.util.Scanner;
import java.util.Random;

public class MayinTarlasi {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int rowNumber, colNumber, size;
    int userRow, userColumn;
    int[][] map;
    int[][] board;
    boolean game = true;

    MayinTarlasi(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void run() {
        prepareGame();
        System.out.println("Oyun Basladi...");
        int count = 0;
        while (game) {
            print(board);
            System.out.println("Satir numarasini girin:");
            userRow = input.nextInt();
            System.out.println("Sutun numarasini girin:");
            userColumn = input.nextInt();
            if (map[userRow - 1][userColumn - 1] == -1) {
                System.out.println("Mayina bastiniz!!!");
                System.out.println("OYUN BITTI!!!");
                game = false;
            }else{
                isMine();
                count++;
            }
            if (count == 19) {
                System.out.println("Tebrikler oyunu Kazandiniz!!!!");
                game = false;
            }
        }
    }

    public void prepareGame() {
        int randRow, randCol;
        int count = 0;
        while (count != (size/4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }

        }
    }

    public void isMine() {
        if (userRow - 2 >= 0 && map[userRow - 2][userColumn - 1] == -1) {
            board[userRow - 1][userColumn - 1]++;
        }
        if (userRow < rowNumber && map[userRow][userColumn - 1] == -1) {
            board[userRow - 1][userColumn - 1]++;
        }
        if (userColumn - 2 >= 0 && map[userRow - 1][userColumn - 2] == -1) {
            board[userRow - 1][userColumn - 1]++;
        }
        if (userColumn < colNumber && map[userRow - 1][userColumn] == -1) {
            board[userRow - 1][userColumn - 1]++;
        }
    }

    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
