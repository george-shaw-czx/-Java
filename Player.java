package chessgame;

import java.util.Scanner;

public class Player {
    protected Chess game;
    protected int player;
    public Player(Chess game,int player){
        this.game=game;
        this.player=player;
    }
    public Player(){
    }
    public boolean sysin(){
        System.out.println("请输入您落子的位置");
        Scanner in=new Scanner(System.in);
        int row=in.nextInt();
        int column=in.nextInt();
        int postion=game.detect(row-1,column-1,player,true);
        if(row>7||column>7||postion==0||row<1||column<1){
            System.out.println("落子位置不合法");
            return false;
        }
        else{
            System.out.println(row+" "+column);
        }
        return true;
    }
    public boolean canGo(){
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                if(game.chess[i][j]==0)
                    if(game.detect(i,j,player,false)!=0) return true;
            }
        }
        return false;
    }
}
