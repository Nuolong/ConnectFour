public class Connect4{
  private String[][] board;
  public Connect4(){
    board = new int[6][7];
  }
  public void addchip(int r, int c , int player){
    if(player==1){
      board[r][c] = "X";
    }
    if(player==0){  //Computer
      board[r][c] = "O";
    }
  }
  
  
  public void printArray{
    for(int k=0; k< board.length; k++){
      System.out.println("");
      for(int j=0; j< board.length[1]; j++){
        System.out.print(" " + board[k][j]+ " ");
      }
    }
  }
}
