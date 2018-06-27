package thread;

public class SynchronizedDemov2 {
    public static void main(String[] args) {
        TicketPool pool=new TicketPool();
        Slaver s1=new Slaver("s1",pool);
        Slaver s2=new Slaver("s2",pool);
        Slaver s3=new Slaver("s3",pool);
        Slaver s4=new Slaver("s4",pool);
        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }

}
class Slaver extends Thread{
    private String name;
    private TicketPool ticketPool;

    Slaver(String name, TicketPool ticketPool) {
        this.name = name;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        while (true){
            int no=ticketPool.getTickets();
            if(no==0){
                return;
            }else{
                System.out.println(name+":"+no);
                Thread.yield();
            }
        }
    }
}
class TicketPool{
    private int tickets=9;
    public  synchronized int  getTickets(){
             int t=tickets;
             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             tickets--;
            return t>0 ? t:0;
    }
}


