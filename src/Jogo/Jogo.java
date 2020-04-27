package Jogo;



import Programa.Campo;
import Programa.Relogio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Jogo {
    MouseListener click;
    JFrame janela;
    Relogio a= new Relogio();
    public Jogo(int i, int D){
        Campo C = new Campo(i,i,D);
        final int[] F = {C.quantBombas()};
        janela= new JFrame("Campo minado");
        JPanel painel1 = new JPanel();
        JPanel painel=new JPanel(new GridLayout(i,i));
        JButton[][] campobombas = new JButton[i][i];
        C.montatabuleiro();
        a.start();
        C.contador(C.quantBombas());
        click=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton botaoclicado=(JButton)e.getSource();
                int I=botaoclicado.getX();
                int J=botaoclicado.getY();
                int g=0,t=0;
                for(int k=0;k<i;k++){
                    for(int l=0;l<i;l++){
                        if(campobombas[k][l].getX()==I && campobombas[k][l].getY()==J){
                            g=k;
                            t=l;
                        }
                    }
                }
                if(e.getButton()==MouseEvent.BUTTON1){
                    C.abrir(g,t,C.m,campobombas);
                }
                if(e.getButton()==MouseEvent.BUTTON3){
                    if(F[0] >0) {
                        C.vitoria1(g,t,campobombas);
                        F[0]--;
                        C.contador(F[0]);
                    }
                }
                else if(e.getButton()==MouseEvent.BUTTON3&&!(campobombas[g][t].isValid())){
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        for(int n=0;n<i;n++){
            for(int k=0;k<i;k++){
                campobombas[n][k]= new JButton();
                campobombas[n][k].addMouseListener(click);
                painel.add(campobombas[n][k]);
            }
        }
        C.contb1.setBackground(Color.BLACK);
        C.contb2.setBackground(Color.BLACK);
        C.contb3.setBackground(Color.BLACK);
        a.getContador1().setBackground(Color.BLACK);
        a.getContador2().setBackground(Color.BLACK);
        a.getContador3().setBackground(Color.BLACK);
        painel1.add(C.contb3);
        painel1.add(C.contb2);
        painel1.add(C.contb1);
        painel1.add(C.princesa);
        painel1.add(a.getContador3());
        painel1.add(a.getContador2());
        painel1.add(a.getContador1());
        janela.setSize(((i*35)+200),((i*25)+150));//colocando na janela e setando tamanho e local dos objetos
        janela.add(painel1,BorderLayout.NORTH);
        janela.add(painel,BorderLayout.CENTER);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}