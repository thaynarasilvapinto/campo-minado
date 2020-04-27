package Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Troll {
    public JFrame janela;
    public Troll(){
        janela = new JFrame("Campo Minado");
        JButton fim = new JButton("Exit");
        JLabel fundo = new JLabel(new ImageIcon("Imagens/achou.png"));
        JPanel painel = new JPanel();
        janela.setSize(600,800);
        painel.setBackground(Color.black);
        fim.setBackground(Color.LIGHT_GRAY);
        painel.add(fundo);
        painel.add(fim,BorderLayout.PAGE_END);
        ActionListener acabou = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        janela.add(painel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fim.addActionListener(acabou);
    }
}
