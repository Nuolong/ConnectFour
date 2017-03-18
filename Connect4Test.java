import java.util.Scanner;

public class Connect4Test{
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    System.out.println("Welcome to Connect4!\n In this game, you must get four in a row to win\nGood Luck!");
    Connect4 Connect = new Connect4();
    while(true){
      Connect.printArray();
      System.out.println("What column would you like your chip in?(0-6)");
      int need = kb.nextInt();
      while (need>6){
        System.out.println("That is an invalid column, or the column has already been filled. Please pick another");
        need = kb.nextInt();
      }
      int lastChipRow = Connect.addChip(need, 1. Connect.board); //ADDED
      if(lastChipRow == -1){
        System.out.println("This is not a valid spot");
      }
      else{
        Connect.AImove(need);
        //int AIRow = Connect.getAIRow();
        //int AIColumn = Connect.getAIColumn();
      }
      if(Connect.isFinished(1, lastChipRow, need) == true){ //if the player wins
        System.out.println("Yay! You won!");
        break; 
      }
      if(Connect.isFinished(2, Connect.getAIRow(), Connect.getAIColumn()) == true){  //if the CPU wins 
        System.out.println("Oh no, the computer won!");
        break;
      }
    }
  }
}
