package Programa;

import Jogo.Derrota;
import Jogo.Vitoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.random;

public class Campo {
    public int m[][];
    int i,j;
    int B;
    public JButton contb1=new JButton();
    public JButton contb2=new JButton();
    public JButton contb3=new JButton();
    public JButton princesa = new JButton();
    Icon prince = new ImageIcon("Imagens/princesa procurando.png");
    Icon prinvevit= new ImageIcon("Imagens/princevit.png");
    Icon princesacry = new ImageIcon("Imagens/princesacry.png");
    Icon band=new ImageIcon("Imagens/banderiasss.png");
    public Icon explosao = new ImageIcon("Imagens/BobombNSMBU.png");
    ArrayList<Cordenadas> vic1 = new ArrayList<Cordenadas>();
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
    public Campo(int i, int j, int bombas){
        this.m=new int[i][j];
        princesa.setBackground(Color.WHITE);
        princesa.setIcon(prince);
        this.i=i;
        this.j=j;
        B=bombas;
        for(int k=0;k<i;k++)
            for (int l=0;l<j;l++)
                this.m[k][l]=0;
    }
    public int quantBombas(){
        float bombas;
        bombas = ((j*i)*B)/100;
        return (int)bombas;
    }
    public void posicionarBombas(){
        int n=0;
        int x,x1;
        int bombas=quantBombas();
        while(n<bombas){
            x = (int)(random()*this.i);
            x1 = (int)(random()*this.j);
            if(m[x][x1]!=-1){
                this.m[x][x1]= -1;
                n++;
            }
        }
    }
    //Adiciona numero de bombas em volta de cada posicao
    public void verificaPosicoes(){
        int aux = 0;
        for(int i = 0; i<this.i; i++){
            for(int j = 0; j<this.j;j++){
                //verifico se a posição analisada não tem bomba
                if(this.m[i][j] == 0){
                    //verifica a posição esta na borda superior
                    if(i==0){
                        //verifica se a posição esta na borda superior e esta na lateral esquerda
                        if(j==0){
                            if(this.m[i][j+1] == -1)
                                aux++;
                            if(this.m[i+1][j] == -1)
                                aux++;
                            if(this.m[i+1][j+1] == -1)
                                aux++;
                            m[i][j] = aux;
                            aux = 0;
                        }else{
                            //verifica se a posição esta na borda superior e esta na lateral esquerda
                            if(j==(this.j-1)){
                                if(this.m[i][j-1] == -1)
                                    aux++;
                                if(this.m[i+1][j] == -1)
                                    aux++;
                                if(this.m[i+1][j-1] == -1)
                                    aux++;
                                m[i][j] = aux;
                                aux = 0;

                            }else{ //A posição esta na borda mas não esta em enhuma lateral
                                if(this.m[i][j-1] == -1)
                                    aux++;
                                if(this.m[i][j+1] == -1)
                                    aux++;
                                if(this.m[i+1][j] == -1)
                                    aux++;
                                if(this.m[i+1][j+1]== -1)
                                    aux++;
                                if(this.m[i+1][j-1]== -1)
                                    aux++;
                                m[i][j] = aux;
                                aux = 0;
                                //POSIÇÃO VERIFICADAS
                            }
                        }

                    }else{
                        //verifica se a posição esta na borda inferior
                        if(i==(this.i-1)){
                            //verifica se a posição esta na borda inferior e esta na lateral esquerda
                            if(j==0){
                                if(this.m[i][j+1] == -1)
                                    aux++;
                                if(this.m[i-1][j] == -1)
                                    aux++;
                                if(this.m[i-1][j+1] == -1)
                                    aux++;
                                m[i][j] = aux;
                                aux = 0;
                            }else{
                                //verifica se a posição esta na borda inferior e esta na lateral direita
                                if(j==(this.j-1)){
                                    if(this.m[i][j-1] == -1)
                                        aux++;
                                    if(this.m[i-1][j] == -1)
                                        aux++;
                                    if(this.m[i-1][j-1] == -1)
                                        aux++;
                                    m[i][j] = aux;
                                    aux = 0;
                                }else{ //A posição esta na borda inferior mas não esta em nehuma lateral

                                    if(this.m[i][j-1] == -1)
                                        aux++;
                                    if(this.m[i][j+1] == -1)
                                        aux++;
                                    if(this.m[i-1][j] == -1)
                                        aux++;
                                    if(this.m[i-1][j-1]== -1)
                                        aux++;
                                    if(this.m[i-1][j+1]== -1)
                                        aux++;
                                    m[i][j] = aux;
                                    aux = 0;
                                    ///VERIFICADO
                                }
                            }
                        }else{
                            //verifica se a posição esta na lateral esquerda
                            if(j==0){
                                if(this.m[i-1][j] == -1)
                                    aux++;
                                if(this.m[i+1][j] == -1)
                                    aux++;
                                if(this.m[i][j+1] == -1)
                                    aux++;
                                if(this.m[i+1][j+1]== -1)
                                    aux++;
                                if(this.m[i-1][j+1]== -1)
                                    aux++;
                                m[i][j] = aux;
                                aux = 0;
                            }else{

                                //verifica se a posição esta na lateral direita
                                if(j==(this.j-1)){
                                    if(this.m[i][j-1] == -1)
                                        aux++;
                                    if(this.m[i-1][j] == -1)
                                        aux++;
                                    if(this.m[i+1][j] == -1)
                                        aux++;
                                    if(this.m[i-1][j-1]== -1)
                                        aux++;
                                    if(this.m[i+1][j-1]== -1)
                                        aux++;
                                    m[i][j] = aux;
                                    aux = 0;
                                }else{
                                    if(this.m[i-1][j] == -1)
                                        aux++;
                                    if(this.m[i+1][j] == -1)
                                        aux++;
                                    if(this.m[i][j-1] == -1)
                                        aux++;
                                    if(this.m[i][j+1] == -1)
                                        aux++;

                                    if(this.m[i+1][j+1] == -1)
                                        aux++;
                                    if(this.m[i+1][j-1]== -1)
                                        aux++;
                                    if(this.m[i-1][j+1]== -1)
                                        aux++;
                                    if(this.m[i-1][j-1]== -1)
                                        aux++;
                                    m[i][j] = aux;
                                    aux = 0;

                                    //Se ele estiver no meio e não em uma das lateriais
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void imprime(){
        for(int j=0;j<this.i;j++){
            for(int n = 0;n<this.j;n++){
                if(this.m[j][n] == -1)
                    System.out.print("["+this.m[j][n] + "]");
                else
                    System.out.print("[ "+this.m[j][n] + "]");
            }
            System.out.println("");
        }
    }
    public void montatabuleiro(){
        this.posicionarBombas();
        this.verificaPosicoes();
        this.imprime();
        System.out.print("\n\n");
        this.imprime();
    }//abrir teclas
    public void abrir(int I, int J, int m[][], JButton[][] campominas){
        int bum= quantBombas();
        int olha=0;
        if(m[I][J]==-1 && campominas[I][J].isValid()){
            campominas[I][J].invalidate();
            campominas[I][J].setBackground(Color.WHITE);
            campominas[I][J].setIcon(explosao);
            abretudo(I,J,m,campominas);
            princesa.setBackground(Color.WHITE);
            princesa.setIcon(princesacry);
            Derrota D =new Derrota();
        }
        if (m[I][J]==0 && campominas[I][J].isValid()){
            campominas[I][J].invalidate();
            campominas[I][J].setEnabled(false);
            m[I][J]=-3;
            abre0(I,J,m,campominas);
        }
        if(m[I][J]>0 && campominas[I][J].isValid()){
            campominas[I][J].setEnabled(false);
            String a=String.valueOf(m[I][J]);
            campominas[I][J].setText(a);
            campominas[I][J].invalidate();
            m[I][J]=-3;
        }
        for(int i=0;i<this.i;i++){
            for(int j=0;j<this.j;j++){
                if(m[i][j]==-3||m[i][j]==-1)
                    olha++;
                if(olha==(this.i*this.j)) {
                    new Vitoria();
                    princesa.setIcon(prinvevit);
                    princesa.setBackground(Color.WHITE);
                    contador(0);
                    for(int q=0;q<this.i;q++){
                        for (int w=0; w<this.j;w++){
                            if(m[q][w]==-1){
                                campominas[q][w].setIcon(band);
                            }
                        }
                    }
                }
            }
        }

    }
    public void abre0(int i,int j, int m[][],JButton[][] campominas) {
        try{
            if(m[i][j+1]==0 && campominas[i][j+1].isValid() && m[i][j+1]!=-3){
                campominas[i][j+1].setEnabled(false);
                campominas[i][j+1].invalidate();
                m[i][j+1]=-3;
                abre0(i,j+1,m,campominas);
            }
            else if(m[i][j+1]!=0 && m[i][j+1]!=-3){
                campominas[i][j+1].setEnabled(false);
                String a=String.valueOf(m[i][j+1]);
                campominas[i][j+1].setText(a);
                m[i][j+1]=-3;
                campominas[i][j+1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i][j-1]==0 && campominas[i][j-1].isValid() && m[i][j-1]!=-3){
                campominas[i][j-1].setEnabled(false);
                campominas[i][j-1].invalidate();
                m[i][j-1]=-3;
                abre0(i,j-1,m,campominas);
            }
            else if(m[i][j-1]!=0 && m[i][j-1]!=-3){
                campominas[i][j-1].setEnabled(false);
                String a=String.valueOf(m[i][j-1]);
                campominas[i][j-1].setText(a);
                m[i][j-1]=-3;
                campominas[i][j-1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i+1][j]==0 && campominas[i + 1][j].isValid() && m[i+1][j]!=-3){
                campominas[i+1][j].setEnabled(false);
                campominas[i+1][j].invalidate();
                m[i+1][j]=-3;
                abre0(i+1,j,m,campominas);
            }
            else if(m[i+1][j]!=0 && m[i+1][j]!=-3){
                campominas[i+1][j].setEnabled(false);
                String a=String.valueOf(m[i+1][j]);
                campominas[i+1][j].setText(a);
                m[i+1][j]=-3;
                campominas[i+1][j].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i-1][j]==0 && campominas[i-1][j].isValid() && m[i-1][j]!=-3){
                campominas[i-1][j].setEnabled(false);
                campominas[i-1][j].invalidate();
                m[i-1][j]=-3;
                abre0(i-1,j,m,campominas);
            }
            else if(m[i-1][j]!=0 && m[i-1][j]!=-3){
                campominas[i-1][j].setEnabled(false);
                String a=String.valueOf(m[i-1][j]);
                campominas[i-1][j].setText(a);
                m[i-1][j]=-3;
                campominas[i-1][j].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i+1][j+1]==0 && campominas[i+1][j+1].isValid() && m[i+1][j+1]!=-3){
                campominas[i+1][j+1].setEnabled(false);
                campominas[i+1][j+1].invalidate();
                m[i+1][j+1]=-3;
                abre0(i+1,j+1,m,campominas);
            }
            else if(m[i+1][j+1]!=0 && m[i+1][j+1]!=-3){
                campominas[i+1][j+1].setEnabled(false);
                String a=String.valueOf(m[i+1][j+1]);
                campominas[i+1][j+1].setText(a);
                m[i+1][j+1]=-3;
                campominas[i+1][j+1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i+1][j-1]==0 && campominas[i+1][j-1].isValid() && m[i+1][j-1]!=-3){
                campominas[i+1][j-1].setEnabled(false);
                campominas[i+1][j-1].invalidate();
                m[i+1][j-1]=-3;
                abre0(i+1,j-1,m,campominas);
            }
            else if(m[i+1][j-1]!=0 && m[i+1][j-1]!=-3){
                campominas[i+1][j-1].setEnabled(false);
                String a=String.valueOf(m[i+1][j-1]);
                campominas[i+1][j-1].setText(a);
                m[i+1][j-1]=-3;
                campominas[i+1][j-1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i-1][j+1]==0 && campominas[i-1][j+1].isValid() && m[i-1][j+1]!=-3){
                campominas[i-1][j+1].setEnabled(false);
                campominas[i-1][j+1].invalidate();
                m[i-1][j+1]=-3;
                abre0(i-1,j+1,m,campominas);
            }
            else if(m[i-1][j+1]!=0 && m[i-1][j+1]!=-3){
                campominas[i-1][j+1].setEnabled(false);
                String a=String.valueOf(m[i-1][j+1]);
                campominas[i-1][j+1].setText(a);
                m[i-1][j+1]=-3;
                campominas[i-1][j+1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(m[i-1][j-1]==0 && campominas[i-1][j-1].isValid() && m[i-1][j-1]!=-3){
                campominas[i-1][j-1].setEnabled(false);
                campominas[i-1][j-1].invalidate();
                m[i-1][j-1]=-3;
                abre0(i-1,j-1,m,campominas);
            }
            else if(m[i-1][j-1]!=0 && m[i-1][j-1]!=-3){
                campominas[i-1][j-1].setEnabled(false);
                String a=String.valueOf(m[i-1][j-1]);
                campominas[i-1][j-1].setText(a);
                m[i-1][j-1]=-3;
                campominas[i-1][j-1].invalidate();
            }
        }catch (ArrayIndexOutOfBoundsException a){}
    }
    public void abretudo(int i,int j, int m[][],JButton[][] campominas) {
        try{
            if(campominas[i][j+1].isValid()){
                campominas[i][j+1].invalidate();
                if(m[i][j+1]==-1){
                    campominas[i][j+1].setBackground(Color.WHITE);
                    campominas[i][j+1].setIcon(explosao);
                }
                if(m[i][j+1]>0){
                    campominas[i][j+1].setEnabled(false);
                    String a=String.valueOf(m[i][j+1]);
                    campominas[i][j+1].setText(a);
                }
                if(m[i][j+1]==0)
                    campominas[i][j+1].setEnabled(false);
                abretudo(i,j+1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i][j-1].isValid()){
                campominas[i][j-1].invalidate();
                if(m[i][j-1]==-1) {
                    campominas[i][j-1].setBackground(Color.WHITE);
                    campominas[i][j-1].setIcon(explosao);
                }
                if(m[i][j-1]>0){
                    campominas[i][j-1].setEnabled(false);
                    String a=String.valueOf(m[i][j-1]);
                    campominas[i][j-1].setText(a);
                }
                if(m[i][j-1]==0)
                    campominas[i][j-1].setEnabled(false);
                abretudo(i,j-1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i+1][j].isValid()){
                campominas[i+1][j].invalidate();
                if(m[i+1][j]==-1) {
                    campominas[i+1][j].setBackground(Color.WHITE);
                   campominas[i+1][j].setIcon(explosao);
                }
                if(m[i+1][j]>0){
                    campominas[i+1][j].setEnabled(false);
                    String a=String.valueOf(m[i+1][j]);
                    campominas[i+1][j].setText(a);
                }
                if(m[i+1][j]==0)
                    campominas[i+1][j].setEnabled(false);
                abretudo(i+1,j,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i-1][j].isValid()){
                campominas[i-1][j].invalidate();
                if(m[i-1][j]==-1) {
                    campominas[i-1][j].setBackground(Color.WHITE);
                    campominas[i-1][j].setIcon(explosao);
                }
                if(m[i-1][j]>0){
                    campominas[i-1][j].setEnabled(false);
                    String a=String.valueOf(m[i-1][j]);
                    campominas[i-1][j].setText(a);
                }
                if(m[i-1][j]==0)
                    campominas[i-1][j].setEnabled(false);
                abretudo(i-1,j,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i+1][j+1].isValid()){
                campominas[i+1][j+1].invalidate();
                if(m[i+1][j+1]==-1) {
                    campominas[i+1][j+1].setBackground(Color.WHITE);
                   campominas[i+1][j+1].setIcon(explosao);
                }
                if(m[i+1][j+1]>0){
                    campominas[i+1][j+1].setEnabled(false);
                    String a=String.valueOf(m[i+1][j+1]);
                    campominas[i+1][j+1].setText(a);
                }
                if(m[i+1][j+1]==0)
                    campominas[i+1][j+1].setEnabled(false);
                abretudo(i+1,j+1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i+1][j-1].isValid()){
                campominas[i+1][j-1].invalidate();
                if(m[i+1][j-1]==-1) {
                    campominas[i+1][j-1].setBackground(Color.WHITE);
                   campominas[i+1][j-1].setIcon(explosao);
                }
                if(m[i+1][j-1]>0){
                    campominas[i+1][j-1].setEnabled(false);
                    String a=String.valueOf(m[i+1][j-1]);
                    campominas[i+1][j-1].setText(a);
                }
                if(m[i+1][j-1]==0)
                    campominas[i+1][j-1].setEnabled(false);
                abretudo(i+1,j-1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i-1][j+1].isValid()){
                campominas[i-1][j+1].invalidate();
                if(m[i-1][j+1]==-1) {
                    campominas[i-1][j+1].setBackground(Color.WHITE);
                   campominas[i-1][j+1].setIcon(explosao);
                }
                if(m[i-1][j+1]>0){
                    campominas[i-1][j+1].setEnabled(false);
                    String a=String.valueOf(m[i-1][j+1]);
                    campominas[i-1][j+1].setText(a);
                }
                if(m[i-1][j+1]==0)
                    campominas[i-1][j+1].setEnabled(false);
                abretudo(i-1,j+1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
        try{
            if(campominas[i-1][j-1].isValid()){
                campominas[i-1][j-1].invalidate();
                if(m[i-1][j-1]==-1) {
                    campominas[i-1][j-1].setBackground(Color.WHITE);
                    campominas[i-1][j-1].setIcon(explosao);
                }
                if(m[i-1][j-1]>0){
                    campominas[i-1][j-1].setEnabled(false);
                    String a=String.valueOf(m[i-1][j-1]);
                    campominas[i-1][j-1].setText(a);
                }
                if(m[i-1][j-1]==0)
                    campominas[i-1][j-1].setEnabled(false);
                abretudo(i-1,j-1,m,campominas);
            }
        }catch (ArrayIndexOutOfBoundsException a){}
    }
    public void vitoria1 (int a, int b, JButton[][] campobombas){
        campobombas[a][b].setIcon(band);
        campobombas[a][b].invalidate();
        campobombas[a][b].setBackground(Color.WHITE);
        Cordenadas c = new Cordenadas(a,b);
        vic1.add(c);
        if(vic1.size()==quantBombas()){
            int cont=0;
            for(int i=0;i<vic1.size();i++){
                if(m[vic1.get(i).i][vic1.get(i).j]==-1)
                    cont++;
            }
            if(cont==quantBombas()){
                princesa.setIcon(prinvevit);
                princesa.setBackground(Color.WHITE);
                new Vitoria();
            }
        }
    }
    public void contador(int bb){
        int a = (bb%100)%10;
        int b = (bb%100)/10;
        int c = bb/100;
        set(contb1,a);
        set(contb2,b);
        set(contb3,c);
    }
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

}
