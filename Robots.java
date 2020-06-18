package chessgame;

public class Robots extends Player {
    private int eatNumMax=0;
    private int column=0;
    private int row =0;
    private int[][] bestPlace={{0,0},{0,7},{7,0},{7,7}};
    public Robots(Chess game,int player){
        super.game=game;
        super.player=player;
    }
    @Override
    public boolean sysin() {
        for (int i = 0; i <4; i++) {
            int postion=game.detect(bestPlace[i][0],bestPlace[i][1],player,true);
            if(postion!=0) return true;
        }
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                int postion=game.detect(i,j,player,false);
                if(postion>eatNumMax){
                    eatNumMax=postion;
                    column=j;
                    row =i;
                }
            }
        }
        if (eatNumMax==0)
            return false;
        game.detect(row,column,player,true);
        System.out.println("机器人落子位置"+row+" "+column);
        return true;
    };

}
