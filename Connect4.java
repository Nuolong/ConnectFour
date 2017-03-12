public class Connect4{
  private int[][] board;
  public Connect4(){
    board = new int[6][7];
  }
  public int findRow(int c){  // Finds the row of the chip for a certain column
    for(int i=0; i<board.length;i++){
      if(board[i][c] == 0){
        return i;
      }
    }
    return 10;
  }
  public boolean addchip(int c , int player){
    r = findRow(c);
    if(r==10){
      return false;
    }
    else if(player==1){
      board[r][c] = 1;
    }
    else if(player==2){  //Computer
      board[r][c] = 2;
    }
    return true;
  }
  
  
  public void printArray{
    for(int k=0; k< board.length; k++){
      System.out.println("");
      for(int j=0; j< board.length[1]; j++){
        if(board[k][j]==1){
        System.out.print(" X ");
        }
        if(board[k][j]==2){
        System.out.print(" O ");
        }
        if(board[k][j]==0){
        System.out.print("   ");
        }
      }
    }
  }
}
