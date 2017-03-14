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
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean isFinished(int p, int x, int y){ //x and y are the positions for the chip last placed on the field, isFinished
    //down, right, downRight only                 //checks after every move. x is row _ , y is column |
    if(x < 3 && y < 3){ 
      if(down(x,y,p) == true || right(x,y,p) == true || downRight(x,y,p) ==  true) return true;
    }
    //down, left, downLeft only  
    if(x < 3 && y > 3){
      if(down(x,y,p) == true || left(x,y,p) == true || downLeft(x,y,p) == true) return true;
    }
    //left, upLeft only
    if(x > 2 && y > 3){
      if(left(x,y,p) == true || upLeft(x,y,p) == true) return true;
    }
    //right, upRight only  
    if(x > 2 && y < 3){
      if(right(x,y,p) == true || upRight(x,y,p) return true;
    }
    //left, right, downLeft, downRight only
    if(x < 3 && y == 3){
      if(left(x,y,p) == true || right(x,y,p) == true || downLeft(x,y,p) == true || downRight(x,y,p) == true) return true;
    }
    //left, right, upRight, upRight only
    if(x > 2 && y == 3){
      if(left(x,y,p) == true || right(x,y,p) == true || upRight(x,y,p) == true || upLeft(x,y,p) == true) return true;
    }
    return false;                                            
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean down(int x,int y, int side){ //side is player or CPU. 1 = player, 2 = CPU
    if(board[x+1][y] == side && board[x+2][y] == side && board[x+3][y] == side){return true;} return false; 
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean upRight(int x,int y, int side){
    if(board[x-1][y+1] == side && board[x-2][y+2] == side && board[x-3][y+3] == side){return true;} return false;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean upLeft(int x,int y, int side){
    if(board[x-1][y-1] == side && board[x-2][y-2] == side && board[x-3][y-3] == side){return true;} return false;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean left(int x,int y, int side){
    if(board[x][y-1] == side && board[x][y-2] == side && board[x][y-3] == side){return true;} return false;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean right(int x,int y, int side){
    if(board[x][y+1] == side && board[x][y+2] == side && board[x][y+3] == side){return true;} return false;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean downRight(int x,int y, int side){
    if(board[x+1][y+1] == side && board[x+2][y+2] == side && board[x+3][y+3] == side){return true;} return false; 
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean downLeft(int x,int y, int side){
    if(board[x+1][y-1] == side && board[x+2][y-2] == side && board[x+3][y-3] == side){return true;} return false;
  }
//------------------------------------------------------------------------------------------------------------------------------//
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
