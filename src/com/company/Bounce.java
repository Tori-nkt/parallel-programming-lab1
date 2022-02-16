package com.company;

import com.company.Pool.BounceFrame;
import com.company.VerticalAndDashes.SymbolThread;
import com.company.VerticalAndDashes.SymbolThreadDash;
import com.company.VerticalAndDashes.SymbolThreadVertical;
import com.company.VerticalAndDashes.SymbolWriter;

import javax.swing.*;

public class Bounce {
    public static void main(String[] args) throws InterruptedException {
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread: " + Thread.currentThread().getName());
        //5
        /*
        for(int i = 0; i<100;i++)
        {
            try{
                task1();
            }catch (InterruptedException ex){ }
        }
         */
        //5.2
        //task2();
    }

    private static void task1() throws InterruptedException {
        SymbolThread st1 = new SymbolThread("-");
        SymbolThread st2 = new SymbolThread("|");
        st1.start();
        st2.start();
        st1.join();
        st2.join();

    }

    private static void task2(){
        SymbolWriter symbolWriter = new SymbolWriter();

        SymbolThreadDash st1 = new SymbolThreadDash(symbolWriter);
        SymbolThreadVertical st2 = new SymbolThreadVertical(symbolWriter, "|");
        st1.start();
        st2.start();
    }
}
