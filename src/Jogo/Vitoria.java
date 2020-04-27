package Jogo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Vitoria {
    public JFrame janela;
    public Vitoria(){
        janela = new JFrame("Campo Minado");
        JButton fim = new JButton("Exit");
        JLabel fundo = new JLabel(new ImageIcon("Imagens/vitoria.png"));
        JPanel painel = new JPanel();
        janela.setSize(700,500);
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
