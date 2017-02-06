

import java.util.Scanner;

public class JyankenTester {
    public static void main(String[] args){
        
        Scanner stdIn = new Scanner(System.in);
        
        System.out.print("名前を入力してください。:");
                String name = stdIn.next();
        HumanPlayer p1 = new HumanPlayer(name);
        ComputerPlayer p2 = new ComputerPlayer("CPU1");
        ComputerPlayer p3 = new ComputerPlayer("CPU2");
        
        String[] hand = {"グー","チョキ","パー"};
        
        int c,phund;    /**c:もう一度繰り返すか。  phund:自分のhundの値  */
        do{
            
                System.out.printf("1.グー 2.チョキ 2.パー\n");
            
            
            System.out.println();
            
            /**自分のhundの値を入力 */
            do{
                System.out.print("入力してください。:");
                phund = stdIn.nextInt();
                System.out.println();
            }while(phund < 0 || phund > 2);
            
            
            /**自分とコンンピュータのhundの値をセットする。*/
            p1.setHund(phund);
            p2.setHund(p2.Random());
            p3.setHund(p3.Random());
            
            System.out.println(p1.getName()+"は"+ hand[p1.getHund()] + "\n"+p2.getName()+"は" + hand[p2.getHund()] + "\n"+p3.getName()+"は" + hand[p3.getHund()] + "を出しました。");
            
            /*
            judgeメソッドで出た数字を用いてswitch文で勝負を判定する。
            */
            switch(p1.judge2(p1, p2, p3)){
                case 0: System.out.println("引き分けです。"); break;
                    
                /**P1だけ手が違う場合の処理、CPUの手で勝ち負けを判定*/
                case 1:            
                        switch(Player.judge(p1.getHund(),p2.getHund())){
                            
                            case 1:System.out.println(p2.getName() + "と" + p3.getName() + "が勝ちです。");
                                   System.out.println("あなたの負けです。");
                                   break;
                                
                            case 2:System.out.println("あなたの勝ちです。");
                                   System.out.println(p2.getName() + "と" + p3.getName() + "が負けです。");
                                   break;
                        }
                break;
                    
                /**P2だけ手が違う場合の処理、プレイヤーとCPU2の手で勝ち負けを判定*/
                case 2:                 
                        switch(Player.judge(p2.getHund(),p3.getHund())){
                            
                            case 1:System.out.println("あなたと" + p3.getName() + "の勝ちです。");
                                   System.out.println(p2.getName() + "の負けです。");
                                   break;
                                
                            case 2:System.out.println(p2.getName() + "の勝ちです。");
                                   System.out.println("あなたと" + p3.getName() + "の負けです。");
                                   break;
                        }
                break;
                    
                /**P3だけ手が違う場合の処理、プレイヤーとCPU1の手で勝ち負けを判定*/
                case 3:                  
                        switch(Player.judge(p3.getHund(),p1.getHund())){
                            
                            case 1:System.out.println("あなたと" + p2.getName() + "の勝ちです。");
                                   System.out.println(p3.getName() + "の負けです。");
                                   break;
                                
                            case 2:System.out.println(p2.getName() + "の勝ちです。");
                                   System.out.println("あなたと" + p2.getName() + "の勝ちです。");
                                   break;
                        }
                break;
                    
                
            }
            
            
            System.out.print("1.続ける  0.やめる  \n");
            c = stdIn.nextInt();
            System.out.println();
            
        }while(c != 0);    /**0入力で終了*/
        
    }
}
