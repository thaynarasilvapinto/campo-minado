package Jogo;

import Programa.Campo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//janela simples com action listener que incia o jogo, ps Campo é criado dentro do jogo pois aqui recebe parametros para cria-lo
public class Menu {
    public Menu(){
        JFrame janela= new JFrame("Campo Minado");
        JTextField Tamanho=new JTextField(10);
        JButton jogar=new JButton("Jogar");
        JLabel tamanho =new JLabel("  Tamanho  ");
        JLabel dificuldade = new JLabel("          Dificuldade:");
        JRadioButton Facil=new JRadioButton("Facil",false);
        JRadioButton Medio=new JRadioButton("Medio",false);
        JRadioButton Dificil= new JRadioButton("Dificil",false);
        JPanel painel = new JPanel();
        painel.add(tamanho);
        painel.add(Tamanho);
        painel.add(dificuldade);
        painel.add(Facil);
        painel.add(Medio);
        painel.add(Dificil);
        painel.add(jogar);
        janela.setSize(300,150);
        janela.getContentPane().add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//dificuldade e demais parametros do jogo sendo recebidos,
                int i;
                try {
                    i = Integer.parseInt(Tamanho.getText());// com jogo pronto ha coisas a se adicionar para deixar mais legal
                }catch (NumberFormatException t){
                    new Troll();
                    return;
                }
                int D;
                if(Facil.isSelected()&&!(Medio.isSelected())&&!(Dificil.isSelected())) {
                    D = 13;
                    new Jogo(i,D);
                }
                else if(Medio.isSelected()&&!(Facil.isSelected())&&!(Dificil.isSelected())) {
                    D = 20;
                    new Jogo(i,D);
                }
                else if(Dificil.isSelected()&&!(Medio.isSelected())&&!(Facil.isSelected())) {
                    D = 30;
                    new Jogo(i,D);
                }
                else if(Facil.isSelected()&&Medio.isSelected()||Medio.isSelected()&&Dificil.isSelected()||Dificil.isSelected()&&Facil.isSelected()||Facil.isSelected()&&Medio.isSelected()&&Dificil.isSelected())
                    new Troll();
                else
                    new Troll();
                janela.setVisible(false);
            }
        });
    }
}
