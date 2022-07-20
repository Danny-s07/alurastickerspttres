import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
   public String buscaDados (String url) {
        //esse trecho de codigo estava inicialmente no app.java
        // try e catch - pegar uma esessao que obriga ser verificada e poem numa que nao precisa ser verificada
        try{
         URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //fazendo uma requisicao e dizendo como eu vou ler os dados- ofString ler uma string
        String body = response.body();
        return body;

        } catch(IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
        

    }
}

//essa classe esta ligada diretamente com a classe app,java, e ela quem faz a verificacao e chamada da url para pegar os dados