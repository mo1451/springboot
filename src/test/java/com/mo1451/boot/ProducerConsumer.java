package com.mo1451.boot;


public class ProducerConsumer {
    private int ball = 0;

    public static int number=0;//单列模式

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public static void AddNumber() {
         number++;

        System.out.println("number = "+number);
    }


    //同步锁确保资源唯一占用
    public synchronized void addBall(){
        number++;
        System.out.println("number = "+number);

        if(ball<5){
            ball++;
            System.out.println("生产者+1S = "+ball);
        }
        System.out.println("货物充足-----");
        notifyAll();
    }


    public synchronized void subBall(){
        number++;
        System.out.println("number = "+number);

        if(ball>3){
            ball--;
            System.out.println("消费者-1S = "+ball);
        }
        System.out.println("货物不足*****");
        notifyAll();

    }

    static class Producer implements Runnable{
        ProducerConsumer producerConsumer;

        //线程通讯，同步对象
        Producer(ProducerConsumer producerConsumer ){
            this.producerConsumer = producerConsumer;
        }

        @Override
        public void run() {

      //      ProducerConsumer.AddNumber();
            producerConsumer.addBall();
            System.out.println("线程执行次数————"+ProducerConsumer.number);
        }
    }

    static class  Consumer implements  Runnable{
        ProducerConsumer producerConsumer;

        Consumer(ProducerConsumer producerConsumer ){
            this.producerConsumer = producerConsumer;
        }

        @Override
        public void run() {
     //       ProducerConsumer.AddNumber();
            producerConsumer.subBall();
            System.out.println("线程执行次数————"+ProducerConsumer.number);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer =new ProducerConsumer();


/*         Thread thread1 =  new Thread(new Producer(producerConsumer));
         Thread thread2 = new Thread(new Consumer(producerConsumer));*/

         for(int i= 0;i<1000;i++){
             new Thread(new Producer(producerConsumer)).start();
             new Thread(new Consumer(producerConsumer)).start();
         }
/*            int i = 100;
            thread1.start();
            thread2.start();
        while (i<0){
            i--;
            if(i==0){

            }
        }*/

    }
}
