package chessgame;

public class Chess {
    public int[][] chess=new int[8][8];
    int dir[][]={{1,0},{0,1},{0,-1},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
    public Chess(){
        chess[3][4]=1;//1表示选手1的棋子
        chess[4][3]=1;
        chess[3][3]=2;//2表示棋手2的棋子
        chess[4][4]=2;
    }
    public void getWinner(){
        int num1=0;
        int num2=0;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                if(chess[i][j]==1)
                {
                    System.out.print("*");
                    num1++;
                }
                if(chess[i][j]==2)
                {
                    System.out.print("@");
                    num2++;
                }
                if(chess[i][j]==0)
                    System.out.print("#");
            }
            System.out.println();
        }
        int winner=(num1>num2)?1:2;
        if(winner==1){
            System.out.println("你赢了！你的总棋子数为"+num1);
        }
        if(winner==2){
            System.out.println("你输了！你的总棋子数为"+num1);
        }
    }
    public void printer() {
        int num1=0;
        int num2=0;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                if(chess[i][j]==1)
                {
                    System.out.print("*");
                    num1++;
                }
                if(chess[i][j]==2)
                {
                    System.out.print("@");
                    num2++;
                }
                if(chess[i][j]==0)
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("选手1（*）:"+num1+" 选手2（@）:"+num2);
    }
    public int detect(int row,int column,int player,boolean eatChess){
        int eatNum=0;
        int tempX=row;
        int tempY=column;
        if(chess[tempX][tempY]!=0){
            return 0;
        }
        for (int i = 0; i <8 ; i++) {
//            System.out.println(i);
            tempX+=dir[i][0];
            tempY+=dir[i][1];
            while((tempX<8)&&(tempX>=0)&&(tempY<8)&&(tempY>=0)) {
                if(chess[tempX][tempY]==0)
                    break;
                if(chess[tempX][tempY]==player){
//                System.out.println("eat!!");
                    if(eatChess==true){
                        chess[row][column]=player;
                        tempX-=dir[i][0];
                        tempY-=dir[i][1];
                        while((tempX != row )||(tempY != column))	 // 只要没有回到开始的位置就执行
                        {
                            chess[tempX][tempY] = player;   // 标志为自己的棋子
                            tempX -= dir[i][0]; tempY -= dir[i][1];   // 继续后退一步
                            eatNum++;  // 累计
                        }
                    }
                    else    // 不吃子，只是判断这个位置能不能吃子
                    {
                        tempX -= dir[i][0];
                        tempY -= dir[i][1];   // 后退一步
//                        System.out.println(tempX+" "+tempY);
                        while((tempX != row)||(tempY != column))        // 只计算可以吃子的个数
                        {
//                            System.out.println(tempX+" "+tempY);
                            tempX -= dir[i][0];
                            tempY -= dir[i][1];// 继续后退一步
                            eatNum++;
                        }
                    }
                    break;  // 跳出循环
                }
//            System.out.println("++");
                tempX += dir[i][0];
                tempY += dir[i][1];
//            System.out.println(tempX+" "+tempY);
            };
            tempX=row;
            tempY=column;
        }
//        System.out.println("end");
        return eatNum;
    }
}
