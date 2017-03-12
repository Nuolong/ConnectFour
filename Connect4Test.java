import java.util.Scanner;

public class Connect4Test{
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    System.out.println("Welcome to Connect4!\n In this game, you must get four in a row to win\nGood Luck!");
    Connect4 board = new Connect4();
    while(true){
      board.printArray();
      System.out.println("What column would you like your chip in?(0-5)");
      int need = kb.nextInt();
      while (need>5){
        System.out.println("That is an invalid column, or the column has already been filled. Please pick another");
        need = kb.nextInt();
        if(board.addChip(need, 1)== false){
          System.out.println("This is not a valid spot");
        }
        else{
          board.moveCPU();
        }
        if(board.isFinished(1) == true){ //if the player wins
          System.out.println("Yay! You won!");
          break; 
        }
        if(board.isFinished(2) == true){  //if the CPU wins
          System.out.println("Oh no, the computer won!");
          break;
        }
      }
    }
  }
}
