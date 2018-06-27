package thread;


public class YieldDemo {
    public static void main(String[] args) {
        MyThread m1=new MyThread("thread-1");
        MyThread m2=new MyThread("thread-2");
        m1.start();
        m2.start();

    }

}
class MyThread  extends  Thread{
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (;;){
            System.out.println(name);
            //Thread.yield();
        }
    }
}

