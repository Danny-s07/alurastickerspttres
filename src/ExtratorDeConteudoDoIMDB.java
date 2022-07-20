import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json)
    {
        //codigo originalmente estava em app.java
       // extrair só os dados que interessam (titulo, poster, classificação)
       var parser = new JsonParser(); // classe criada para importar o arquivo jsonparse.java
       //transformando a list em lista de conteudo
      List<Map<String, String>> listaDeAtributos = parser.parse(json);


      List<Conteudo> conteudos = new ArrayList<>();
      //popular a lista de conteudos
      for (Map<String, String> atributos : listaDeAtributos) {
       String titulo = atributos.get("title");
       String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
        var conteudo = new Conteudo(titulo, urlImagem);

        conteudos.add(conteudo);
      }
       return conteudos;
   }
    
}

















//essa classe esta sendo chamada pelo app.java e vai passar os dados do IMBD que serao transmitidos para o conteudo