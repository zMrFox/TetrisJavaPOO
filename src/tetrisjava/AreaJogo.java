package tetrisjava;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class AreaJogo extends JPanel{
    /*Respectivamente, quantas linhas, colunas tem a area de jogo
    e qual o tamanho de cada célula na área de jogo
    */
    private int gradeLinhas;
    private int gradeColunas;
    private int gradeTamCel;
    
    private TetrisBloco bloco;
    
    public AreaJogo(JPanel placeholder, int colunas){
       //Cria a área de jogo, diferentemente da area da janela
       /*Placeholder é usado no FormatoJogo.java, como uma forma de
       achar coordenadas de posições mais facilmente, como um preview
       de como sera a janela
       */
       placeholder.setVisible(false);
       this.setBounds(placeholder.getBounds());
       this.setBackground(placeholder.getBackground());
       this.setBorder(placeholder.getBorder());
       
       gradeColunas = colunas;
       gradeTamCel = this.getBounds().width / gradeColunas;
       gradeLinhas = this.getBounds().height / gradeTamCel;
       
       criarBloco();
    }
    
    public void criarBloco(){
        bloco = new TetrisBloco(new int[][]{{1,0},{1,0},{1,1}}, Color.blue);
    }
    
    private void drawBloco(Graphics g){
        int alt = bloco.getAlt();
        int larg = bloco.getLarg();
        int[][] form = bloco.getFormato();
        Color c = bloco.getColor();
        
        for(int lin = 0; lin < alt; lin++)
        {
            for(int col = 0; col < larg; col++)
            {
                if(form[lin][col] == 1)
                {
                    int x = (bloco.getX() + col) * gradeTamCel;
                    int y = (bloco.getY() + lin) * gradeTamCel;
                    /*
                    ****Ordem importa****
                    Primeiro é utilizado o set color para colorir o bloco
                    Segundo é instanciado as linhas da Area do jogo
                    Logo, somente as linhas do bloco são coloridas de preto
                    Quarto, o bloco é instanciado
                    */
                    g.setColor(c);
                    g.fillRect(x, y, gradeTamCel, gradeTamCel);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, gradeTamCel, gradeTamCel);
                }
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        /*Apesar da classe Teste estar instanciando um objeto da classe Sub,
        sempre sera chamado o construtor da superclasse (paintComponent)
        */
        super.paintComponent(g);
        
        drawBloco(g);
    }
}
