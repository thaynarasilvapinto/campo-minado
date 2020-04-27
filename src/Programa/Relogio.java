package Programa;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Relogio {
    Icon a0 = new ImageIcon("Imagens/0.png");
    Icon a1 = new ImageIcon("Imagens/1.png");
    Icon a2 = new ImageIcon("Imagens/2.png");
    Icon a3 = new ImageIcon("Imagens/3.png");
    Icon a4 = new ImageIcon("Imagens/4.png");
    Icon a5 = new ImageIcon("Imagens/5.png");
    Icon a6 = new ImageIcon("Imagens/6.png");
    Icon a7 = new ImageIcon("Imagens/7.png");
    Icon a8 = new ImageIcon("Imagens/8.png");
    Icon a9 = new ImageIcon("Imagens/9.png");
    int secondspassad=0;
    public JButton getContador1() {
        return contador1;
    }
    JButton contador1;
    public JButton getContador2() {
        return contador2;
    }
    JButton contador2;
    public JButton getContador3() {
        return contador3;
    }
    JButton contador3;
    Timer mytimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondspassad++;
            int a = (secondspassad%100)%10;
            int b = (secondspassad%100)/10;
            int c = secondspassad/100;
            set(contador1,a);
            set(contador2,b);
            set(contador3,c);
        }
    };
    public void set(JButton a, int b){
        if(b==0)
            a.setIcon(a0);
        if(b==1)
            a.setIcon(a1);
        if(b==2)
            a.setIcon(a2);
        if(b==3)
            a.setIcon(a3);
        if(b==4)
            a.setIcon(a4);
        if(b==5)
            a.setIcon(a5);
        if(b==6)
            a.setIcon(a6);
        if(b==7)
            a.setIcon(a7);
        if(b==8)
            a.setIcon(a8);
        if(b==9)
            a.setIcon(a9);
    }
    public void start(){
        contador1 =new JButton();
        contador2 =new JButton();
        contador3 =new JButton();
        mytimer.scheduleAtFixedRate(task,1000,1000);
    }
}
