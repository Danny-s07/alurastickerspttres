import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.InputStream;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    //metodo para criar, agora adicionando o inputstream nos parentes vem passado de um link externo 
   public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

     //leitura da imagem - pegar a imagem 
    //  BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filmemaior.jpg")); lendo via arquivo baixado e armazenado na pasta do projeto
    //lendo de arquivo  que esta na pasta de uma outra maneira
    // InputStream inputStream =  new FileInputStream(new File("entrada/filmemaior.jpg"));
    //  BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //agora inputstream vindo de uma url 
    // InputStream inputStream =  new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
     BufferedImage imagemOriginal = ImageIO.read(inputStream);

     //criar uma nova imagem com transparencia - transformar a imagem que foi pega em transparente estilo extensao png e com tamanho novo
     int largura = imagemOriginal.getWidth();
     int altura = imagemOriginal.getHeight();
     int novaAltura = altura + 200;
     BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT); //criar uma nova imagem vazia, transparente estilo png

     //copiar a imagem original para nova imagem (fazer a transformação), fazendo a utilizacao de tipo uma 'caneta' no papel
    Graphics2D graphics = (Graphics2D)novaImagem.getGraphics(); //imagem nova que vai emcima da antiga
    graphics.drawImage(imagemOriginal, 0, 0, null);//imagem antiga
    

    //fazendo as configuracoes da fonte da escrita (tamanho,estilo e cor)
    // var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 20); versao antiga 
    // var fonte = new Font("Comic Sans MS",Font.BOLD, 20); versao com miniatura de img
    var fonte = new Font("Comic Sans MS",Font.BOLD, 72);// versao com tamanho grande
     FontMetrics medidasFonte = graphics.getFontMetrics(fonte);
    graphics.setColor(Color.GRAY);// fazendo a caneta escrever na cor selecionada
    graphics.setFont(fonte);//resetando,"limpando a fonte"

     //escrever uma frase na nova imagem -graphics("caneta")
    //  graphics.drawString("VIDA LOKA", 100, novaAltura-100);
    // graphics.drawString("TOPEZERA", 12, novaAltura-100); centralizado com a imagem em formato poster na mao
    graphics.drawString("TOPEZERA", largura/2 - medidasFonte.stringWidth("TOPEZERA")/2 , novaAltura - 100);//centralizando o texto a partir da imagem

     //escrever a nova imagem em um arquivo(fazer com que ela fique visivel)
    //  ImageIO.write(novaImagem, "png", new File("saida/figurinha.png")); apenas com uma imagem
    ImageIO.write(novaImagem, "png", new File(nomeArquivo)); //saindo resultado na pasta principal
    // var saida = "saidanv/"; //variavel criada para ser consumida na linha de baixo para direcionar a saida das figs numa nv pasta
    // ImageIO.write(novaImagem, "png", new File( saida + nomeArquivo)); // saindo numa pasta expecifica
    


    }

    //utilizado para teste
    // public static void main(String[] args) throws Exception {
    //    var geradora =  new GeradoraDeFigurinhas();
    //    geradora.cria();
    // }
}
