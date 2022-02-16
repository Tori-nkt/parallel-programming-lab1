package com.company.Pool;


public class BallThread extends Thread {
    private final Ball b;

    public BallThread(Ball ball){
        b = ball;
    }
    @Override
    public void run(){
            try{
                for(int i = 1; i < 10000; i++){
                    if(b.getX() <= Pocket.x + 15 && b.getX() >= Pocket.x - 5
                            && b.getY() <= Pocket.y + 15 && b.getY() >= Pocket.y - 5){
                        b.setInPocket();
                        //Thread.currentThread().close();
                        return; // ball is in pocket
                    }
                    b.move();
                    System.out.println("Thread: " + Thread.currentThread().getName() + Thread.currentThread().getState());
                    Thread.sleep(5);
                }
            } catch(InterruptedException ex){
                System.out.println("Thread: " + Thread.currentThread().getName() + "interrupted");
            }
    }
}
