package thread;

public class Join_daemonDemo {
    public static void main(String[] args) {

     Player t1=new Player("t1",2000);
     Player t2=new Player("t2",1000);
     Player t3=new Player("t3",3000);
     Player t4=new Player("t4",500);
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            t4.start();
            t4.join();
            System.out.println("开局");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Player extends Thread{
    private String name;
    private int time;

    Player(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(name+" 玩家到");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
