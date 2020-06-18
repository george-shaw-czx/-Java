package chessgame;

public class game {
    public static void main(String[] args) {
        int Round=1;
        Chess game= new Chess();
        Player player1=new Player(game,1);
        Player player2=new Robots(game,2);

        while(true){
            int canGo=2;
            Round++;
            game.printer();
        if((Round)%2==0)
            while(!player1.sysin());
            if(!player1.canGo())
            {
                Round++;
                canGo--;
            }
        else if ((Round)%2==1)
            while(!player2.sysin());
            if(!player2.canGo())
            {
                Round++;
                canGo--;
            }
            if(canGo==0){
                game.getWinner();
                break;
            }
        }
    }
}
