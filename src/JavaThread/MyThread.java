package JavaThread;

public class MyThread extends Thread{
    private int count=5;

    public MyThread(String name ) {
        super();
        this.setName(name);
    }
    @Override
    public void run(){

        while(count>0){

            System.out.println("this is "+count+"name:"+getName());
            count--;
        }

    }
    public  static void main(String[] args){
//        MyThread thread=new MyThread("A");
//        MyThread b=new MyThread("B");
//        try{
//        b.sleep(3000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        thread.start();
//        b.start();
        RunnAble runnAble=new RunnAble();
        Thread thread3=new Thread(runnAble,"A");
        thread3.start();



    }
}
