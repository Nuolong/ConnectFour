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
      int lastChipRow = Connect.addchip(need, 1, Connect.getBoard()); 
      while(lastChipRow == -1){
        System.out.println("This is not a valid spot, pick another column");
        int newc = kb.nextInt();
        lastChipRow=Connect.addchip(newc,1,Connect.getBoard());
      }
      Connect.AIMove(need);
      if(Connect.isFinished(1, lastChipRow, need, Connect.getBoard()) == true){ //if the player wins
        Connect.printArray();
        System.out.println("Yay! You won!");
        break; 
      }
      if(Connect.isFinished(2, Connect.getAIRow(), Connect.getAIColumn(), Connect.getBoard()) == true){  //if the CPU wins 
        Connect.printArray();
        System.out.println("Oh no, the computer won!");
        break;
      }
      if(Connect.isDraw()){
        Connect.printArray();
        System.out.println("It's a draw!");
        break;
      }
        
    }
   kb.close();
  }
}
  
