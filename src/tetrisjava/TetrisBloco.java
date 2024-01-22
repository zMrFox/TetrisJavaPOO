package tetrisjava;

import java.awt.Color;

public class TetrisBloco {
    private int[][] formato;
    private Color color;
    private int x, y;

    public TetrisBloco(int[][] formato, Color color) {
        this.formato = formato;
        this.color = color;
        
        x=8;
        y=1;
    }

    // Getters de variáveis privadas
    public int[][] getFormato() {
        return formato;
    }

    public Color getColor() {
        return color;
    }
    
    public int getAlt() {
        return formato.length;
    }
    
    public int getLarg() {
        return formato[0].length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    // Movimentos dos blocos
    public void Baixo(){
        y++;
    }
    
    public void Direita(){
        x++;
    }
    
    public void Esquerda(){
        x--;
    }
}
