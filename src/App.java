import java.io.InputStream;
import java.net.URL;
import java.util.List;
// import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //pegar os dados do imdb, //fazer uma conexao HTTP e buscar os tops 250 filmes
        //_____________________ Inicio Bloco de codigos para utilizar dados do IMDB________________________________
        //  String url = "https://alura-imdb-api.herokuapp.com/movies"; //link de imagens gerando pelo poster img pequena
         //criando o extrator da nasa nesse caso var =  ExtratorDeConteudoDoIMDB
        //  ExtratorDeConteudoDoIMDB extrator =  new  ExtratorDeConteudoDoIMDB(); metodo antigo antes da criacao do contrato(extrator de conteudo)
        // ExtratorDeConteudo extrator =  new  ExtratorDeConteudoDoIMDB();
         //_____________________ Final Bloco de codigos para utilizar dados do IMDB________________________________

         //_____________________ Inicio Bloco de codigos para utilizar dados da NASA________________________________
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
            //criando o extrator da nasa nesse caso var =  ExtratorDeConteudoDaNasa
            //   ExtratorDeConteudoDaNasa extrator =  new  ExtratorDeConteudoDaNasa(); metodo antigo antes da criacao do contrato(extrator de conteudo)
            ExtratorDeConteudo extrator =  new  ExtratorDeConteudoDaNasa();
         //_____________________ Final Bloco de codigos para utilizar dados da NASA________________________________
        
        //chamando a  classe clientehttp para reconhercer o body(json) do parse 
       var http = new ClienteHttp();
       String json = http.buscaDados(url);

       // extrair só os dados que interessam (titulo, poster, classificação)
    //    var parser = new JsonParser(); // classe criada para importar o arquivo jsonparse.java
    //    List<Map<String, String>> listaDeConteudos = parser.parse(json);


        // exibir e manipular os dados , trazendo apenas o titulo,imagem e nota filtro que foi feito perto do array json de todos os dados da api a partir de um mapa(map) criado
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);


       var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            
            InputStream inputStream =  new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = "saida/" + conteudo.getTitulo().replace(":","-") + ".png";

            // String nomeArquivo = titulo.replace(":","-") + ".png";
            
           geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

           //criacao e exibicao da nota colorida e as estrela em baixo da nota ... jeito um 
            // System.out.println("\u001b[45m\u001b[3mClassificação: \u001b[m\u001b[45m\u001b[1m"+ filme.get("imDbRating")+ " \u001b[m");
            // int classificacao = (int) Float.parseFloat(filme.get("imDbRating"));
            // String stars = "";            
            // for(int a = 0; a<classificacao; a++) {
            //     stars = stars + "\u2B50";               
            // }            
            //  System.out.println(stars);
            // System.out.println();
          // fINAL DO CODIGO DA AULA 01 ONDE TINHA QUE POR UNS EFEITOS DE ESTRELA  , COR  ETC ...//
        }

       
    }
}

