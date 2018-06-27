package thread;

public class SynchronizedDemov1
{
    public static void main(String[] args) {
    Slave s1=new Slave("s1");
    Slave s2=new Slave("s2");
    s1.start();
    s2.start();

    }

}
class Slave extends Thread{
    private String name;
    private static int tickets=100;
    static Object lock=new Object();

    Slave(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            int t=getTicket();
            if(t==0){
                return ;
            }else{
                System.out.println(name +":"+t);
            }
        }
    }
    public int getTicket(){
        synchronized (lock){
            int t=tickets;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
            return  t>0 ?t:0;
        }

    }

}

