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
  public int addchip(int c , int player){
    r = findRow(c);
    if(r==10){
      return -1;
    }
    board[r][c] = player;
    return r;
  }
//------------------------------------------------------------------------------------------------------------------------------//
  public boolean isFinished(int p, int x, int y){ //x and y are the positions for the chip last placed on the field, isFinished
    //main end chain checks                       //checks after every move. x is row _ , y is column |
    if(x < 3 && y < 3){                           
      if(down(x,y,p) || right(x,y,p) || downRight(x,y,p)) return true;
      if(x == 1 && y == 1){
        if(UL1DR2(x,y,p)) return true;
      }
    } 
    if(x < 3 && y > 3){
      if(down(x,y,p) || left(x,y,p) || downLeft(x,y,p)) return true;
      if(x == 1 && y == 5){
        if(DL2UR1(x,y,p)) return true;
      }
    }
    if(x > 2 && y > 3){
      if(left(x,y,p) || upLeft(x,y,p)) return true;
      if(x == 4 && y == 5){
        if(UL2DR1(x,y,p)) return true;
      }
    }
    if(x > 2 && y < 3){
      if(right(x,y,p) || upRight(x,y,p)) return true;
      if(x == 4 && y == 1){
        if(DL1UR2(x,y,p)) return true;
      }
    }
    if(x < 3 && y == 3){
      if(left(x,y,p) || right(x,y,p) || downLeft(x,y,p) || downRight(x,y,p)) return true;
    }
    if(x > 2 && y == 3){
      if(left(x,y,p) || right(x,y,p) || upRight(x,y,p) || upLeft(x,y,p)) return true;
    }
    //additional horizontal checks
    if(y > 1 && y < 5){
      if(L1R2(x,y,p) || L2R1(x,y,p)) return true;
    }
    if(y == 1){
      if(L1R2(x,y,p)) return true;
    }
    if(y == 5){
      if(L2R1(x,y,p)) return true;
    }
    //additional diagonal checks
    for(int row = 2; row < 4; row++){
      if(x == row && y > 1 && y < 5){
        if(UL1DR2(x,y,p) || UL2DR1(x,y,p) || DL1UR2(x,y,p) || DL2UR1(x,y,p)) return true;
      }
    }
    if(x == 1 && y > 1 && y < 5){
      if(DL2UR1(x,y,p) || UL1DR2(x,y,p))return true;
    }
    if(x == 4 && y > 1 && y < 5){
      if(UL2DR1(x,y,p) || DL1UR2(x,y,p))return true;
    }
    if(y == 1 && x > 1 && x < 4){
      if(DL1UR2(x,y,p) || UL1DR2(x,y,p))return true;
    }
    if(y == 5 && x > 1 && x < 4){
      if(DL2UR1(x,y,p) || UL2DR1(x,y,p))return true;
    }
    return false;                                          
  }
//------------------------------------------------------------------------------------------------------------------------------//
  //side is player or CPU. 1 = player, 2 = CPU
  public boolean down(int x,int y, int side){return (board[x+1][y] == side && board[x+2][y] == side && board[x+3][y] == side);}
  public boolean upRight(int x,int y, int side){return (board[x-1][y+1] == side && board[x-2][y+2] == side && board[x-3][y+3] == side);}
  public boolean upLeft(int x,int y, int side){return (board[x-1][y-1] == side && board[x-2][y-2] == side && board[x-3][y-3] == side);}
  public boolean left(int x,int y, int side){return (board[x][y-1] == side && board[x][y-2] == side && board[x][y-3] == side);}
  public boolean right(int x,int y, int side){return (board[x][y+1] == side && board[x][y+2] == side && board[x][y+3] == side);}
  public boolean downRight(int x,int y, int side){return (board[x+1][y+1] == side && board[x+2][y+2] == side && board[x+3][y+3] == side);}
  public boolean downLeft(int x,int y, int side){return (board[x+1][y-1] == side && board[x+2][y-2] == side && board[x+3][y-3] == side);}
  public boolean L1R2(int x,int y, int side){return (board[x][y-1] == side && board[x][y+1] == side && board[x][y+2] == side);}
  public boolean L2R1(int x,int y, int side){return (board[x][y-1] == side && board[x][y-2] == side && board[x][y+1] == side);}
  public boolean UL1DR2(int x,int y, int side){return (board[x-1][y-1] == side && board[x+1][y+1] == side && board[x+2][y+2] == side);}
  public boolean UL2DR1(int x,int y, int side){return (board[x-1][y-1] == side && board[x-2][y-2] == side && board[x+1][y+1] == side);}
  public boolean DL1UR2(int x,int y, int side){return (board[x-1][y+1] == side && board[x+1][y-1] == side && board[x-2][y+2] == side);}
  public boolean DL2UR1(int x,int y, int side){return (board[x-1][y+1] == side && board[x+2][y-2] == side && board[x+1][y-1] == side);}
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
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//
 FOR ISFINISHED, I REALIZE I WOULD NEED TO MAKE ANOTHER PARAMETER FOR
 TO TAKE A CERTAIN ARRAY. BECAUSE RIGHT NOW IT IS ONLY
FOR THE BOARD ARRAY. I DIDN'T DO ANYTHING THOUGH BECAUSE YOU MIGHT
 HAVE WANTED TO MAKE A DIFFERENT ISFINISHED METHOD.
  
  public static AIMove(){
    for(int i = 0; i < board[0].length; i++){
      if(findRow(i) != 10){
        int cloneOffense[][] = board.clone(); //part for the robot winning the game by matching 4 
        int r = addChipClone(i,2,cloneOffense);
        if(isFinished(2,r,i)){   
          int unused = addChip(i,2);
          return;
        }
        int cloneDefense[][] = board.clone(); //part for robot preventing user from matching 4
        int ro = addChipClone(i,1,cloneDefense);
        if(isFinished(1,ro,i){
          int unused2 = addChip(i,2);
          return;
        }
        //insert something for putting the chip ontop of the last player's chip 
      }
    }
  }
  
  public int addchipClone(int c , int player, int[][] arr){
    r = findRow(c);
    if(r==10){
      return -1;
    }
    arr[r][c] = player;
    return r;
  }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/  
}
