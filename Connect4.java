public class Connect4{
  private int[][] board;
  private int AIRow;
  private int AIColumn;
  public Connect4(){
    board = new int[6][7];
  }
  public int findRow(int c){  // Finds the row of the chip for a certain column
    for(int i=board.length-1; i>=0;i--){
      if(board[i][c] == 0){
        return i;
      }
    }
    return 10;
  }
  public int addchip(int c , int player, int[][] arr){
    int r = findRow(c);
    if(r==10){
      return -1;
    }
    arr[r][c] = player;
    return r;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean isFinished(int p, int x, int y, int[][] arr){ //x and y are the positions for the chip last placed on the field, isFinished
    //main end chain checks                       //checks after every move. x is row _ , y is column |
    if(x < 3 && y < 3){                           
      if(down(x,y,p,arr) || right(x,y,p,arr) || downRight(x,y,p,arr)) return true;
      if(x == 1 && y == 1){
        if(UL1DR2(x,y,p,arr)) return true;
      }
    } 
    if(x < 3 && y > 3){
      if(down(x,y,p,arr) || left(x,y,p,arr) || downLeft(x,y,p,arr)) return true;
      if(x == 1 && y == 5){
        if(DL2UR1(x,y,p,arr)) return true;
      }
    }
    if(x > 2 && y > 3){
      if(left(x,y,p,arr) || upLeft(x,y,p,arr)) return true;
      if(x == 4 && y == 5){
        if(UL2DR1(x,y,p,arr)) return true;
      }
    }
    if(x > 2 && y < 3){
      if(right(x,y,p,arr) || upRight(x,y,p,arr)) return true;
      if(x == 4 && y == 1){
        if(DL1UR2(x,y,p,arr)) return true;
      }
    }
    if(x < 3 && y == 3){
      if(left(x,y,p,arr) || right(x,y,p,arr) || downLeft(x,y,p,arr) || downRight(x,y,p,arr)) return true;
    }
    if(x > 2 && y == 3){
      if(left(x,y,p,arr) || right(x,y,p,arr) || upRight(x,y,p,arr) || upLeft(x,y,p,arr)) return true;
    }
    //additional horizontal checks
    if(y > 1 && y < 5){
      if(L1R2(x,y,p,arr) || L2R1(x,y,p,arr)) return true;
    }
    if(y == 1){
      if(L1R2(x,y,p,arr)) return true;
    }
    if(y == 5){
      if(L2R1(x,y,p,arr)) return true;
    }
    //additional diagonal checks
    for(int row = 2; row < 4; row++){
      if(x == row && y > 1 && y < 5){
        if(UL1DR2(x,y,p,arr) || UL2DR1(x,y,p,arr) || DL1UR2(x,y,p,arr) || DL2UR1(x,y,p,arr)) return true;
      }
    }
    if(x == 1 && y > 1 && y < 5){
      if(DL2UR1(x,y,p,arr) || UL1DR2(x,y,p,arr))return true;
    }
    if(x == 4 && y > 1 && y < 5){
      if(UL2DR1(x,y,p,arr) || DL1UR2(x,y,p,arr))return true;
    }
    if(y == 1 && x > 1 && x < 4){
      if(DL1UR2(x,y,p,arr) || UL1DR2(x,y,p,arr))return true;
    }
    if(y == 5 && x > 1 && x < 4){
      if(DL2UR1(x,y,p,arr) || UL2DR1(x,y,p,arr))return true;
    }
    return false;                                          
  }
//------------------------------------------------------------------------------------------------------------------------------//
  //side is player or CPU. 1 = player, 2 = CPU
  public boolean down(int x,int y, int side, int[][] arr){return (arr[x+1][y] == side && arr[x+2][y] == side && arr[x+3][y] == side);}
  public boolean upRight(int x,int y, int side, int[][] arr){return (arr[x-1][y+1] == side && arr[x-2][y+2] == side && arr[x-3][y+3] == side);}
  public boolean upLeft(int x,int y, int side, int[][] arr){return (arr[x-1][y-1] == side && arr[x-2][y-2] == side && arr[x-3][y-3] == side);}
  public boolean left(int x,int y, int side, int[][] arr){return (arr[x][y-1] == side && arr[x][y-2] == side && arr[x][y-3] == side);}
  public boolean right(int x,int y, int side, int[][] arr){return (arr[x][y+1] == side && arr[x][y+2] == side && arr[x][y+3] == side);}
  public boolean downRight(int x,int y, int side, int[][] arr){return (arr[x+1][y+1] == side && arr[x+2][y+2] == side && arr[x+3][y+3] == side);}
  public boolean downLeft(int x,int y, int side, int[][] arr){return (arr[x+1][y-1] == side && arr[x+2][y-2] == side && arr[x+3][y-3] == side);}
  public boolean L1R2(int x,int y, int side, int[][] arr){return (arr[x][y-1] == side && arr[x][y+1] == side && arr[x][y+2] == side);}
  public boolean L2R1(int x,int y, int side, int[][] arr){return (arr[x][y-1] == side && arr[x][y-2] == side && arr[x][y+1] == side);}
  public boolean UL1DR2(int x,int y, int side, int[][] arr){return (arr[x-1][y-1] == side && arr[x+1][y+1] == side && arr[x+2][y+2] == side);}
  public boolean UL2DR1(int x,int y, int side, int[][] arr){return (arr[x-1][y-1] == side && arr[x-2][y-2] == side && arr[x+1][y+1] == side);}
  public boolean DL1UR2(int x,int y, int side, int[][] arr){return (arr[x-1][y+1] == side && arr[x+1][y-1] == side && arr[x-2][y+2] == side);}
  public boolean DL2UR1(int x,int y, int side, int[][] arr){return (arr[x-1][y+1] == side && arr[x+2][y-2] == side && arr[x+1][y-1] == side);}
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
  public void AIMove(int playerC){
    int[][] cloneOffense = new int[6][7];
    int[][] cloneDefense = new int[6][7];
    for(int i = 0; i < board[0].length; i++){
      if(findRow(i) != 10){
        for(int j=0;j<cloneOffense.length;j++){
          for(int k=0; k<cloneOffense[0].length;k++){
            cloneOffense[j][k] = board[j][k];
          }
        }
        int r = addChip(i,2,cloneOffense);
        if(isFinished(2,r,i,cloneOffense)){   
          AIRow = addChip(i,2,board);
          AIColuumn = i;
          return;
        }
        for(int j=0;j<cloneDefense.length;j++){
          for(int k=0; k<cloneDefense[0].length;k++){
            cloneDefense[j][k] = board[j][k];
          }
        }
        r = addChip(i,1,cloneDefense);
        if(isFinished(1,r,i,cloneDefense)){
          AIRow = addChip(i,2, board);
          AIColumn = i;
          return;
        } 
      }
    }
    int needr = addChip(playerC, 2, board );
    while(needr == -1){
      if(playerC == 6){
        playerC = 0;
      }
      else{
        playerC++;
      }
      needr=addChip(playerC, 2, board);
    }
    AIRow = needr;
    AIColumn=playerC;
  }
  public int getAIRow(){
    return AIRow;
  }
  public int getAIColumn(){
    return AIColumn;
  }
}
