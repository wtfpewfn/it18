package thread;

import java.util.Date;

public class DaemonDemo {
    public static void main(String[] args) {
    Box b1=new Box("no-1",2000);
    Box b2=new Box("no-2",4000);
    Waiter w=new Waiter();
    w.setDaemon(true);
    b1.start();
    b2.start();
    w.start();

    }


}
class Box extends Thread{
    private String no;
    private int time;

    Box(String  no, int time) {
        this.no = no;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(no+"开始消费");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(no+"结束消费，花费多长"+time+"时间");
    }
}
class Waiter extends Thread{

    @Override
    public void run() {
         while (true){
        System.out.println(new Date());
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
