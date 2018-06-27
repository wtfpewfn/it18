package thread;

import java.util.ArrayList;
import java.util.List;

public class ProductorConsumerDemo {
    public static void main(String[] args) {
    List list=new ArrayList();
    Productor p=new Productor("生产者",list);
    Consumer c=new Consumer("消费者",list);
    p.start();
    c.start();

    }
}
class Productor extends Thread{
    private String name;
    private List list;

    Productor(String name, List list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            list.add(new Integer(i++));
            System.out.println(name+"："+i);
        }

    }
}
class Consumer extends Thread{
    private String name;
    private List list;

    Consumer(String name, List list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            if(list.size()>0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object i= list.remove(0);
                System.out.println(name+"："+i);
            }
        }

    }
}



