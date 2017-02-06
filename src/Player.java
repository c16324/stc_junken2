
public abstract class Player {
    static int counter = 1;
    
    /**名前*/
    private String name;
    /**ID*/
    private int id;
    /**どの手かを表す*/
    private int hund;          
    
    Player(String name){
        this.name = name;
        id = counter++;
    }
    
    /**hundの値をSETする。*/
    public void setHund(int hund){
        this.hund = hund;
    }
    /**IDの値を返す。*/
    public int getId(){
        return id;
    }
    
    /**名前を返す。*/
    public String getName(){
        return name;
    }
   
    /**hundの値を返す。*/
    public int getHund(){
        return hund;
    }
    
        /**それぞれのhundの値を取り、結果を返す。*/
    static public int judge(int a,int b){
        return (a - b + 3) % 3;
    }
    /**アイコになる場合は0を返し、それ以外の場合は一人だけ手の違う人のIDの値を返す。*/
    public int  judge2(Player a,Player b,Player c){
        if(a.getHund() == b.getHund()){
            if(b.getHund() == c.getHund())
                return 0;
        }
        
        if(a.getHund() == b.getHund()){
            return c.getId();
        }
        
        else if(b.getHund() == c.getHund()){
            return a.getId();
        }
        
        else if(c.getHund() == a.getHund()){
            return b.getId();
        }
        return 0;
    }

    
    
}
