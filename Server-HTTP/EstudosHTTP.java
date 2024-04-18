import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 Possivel usar o Thunderclint para fazer a mesma coisa 
 */
public class EstudosHTTP{
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://jsonplaceholder.typicode.com/todos/1")) //qualquer erro
        .GET() //tipo de requisicao para buscar o elemento dentro do site
        .build(); //retorna um novo HttpRequest

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(response -> response.body())
        .thenAccept(body -> System.out.println(body)); //?printa no terminal antes do print teste
        //-> faz com que nao bloqueie todo o código, tipo o async do JS
        // HttpResponse<String> httpresponse = client.send(request, HttpResponse.BodyHandlers.ofString());



        // System.out.println(httpresponse.body()); //informacao do site 
        // System.out.println(httpresponse.statusCode()); //status daa resposta - 200 igual a OK
        // System.out.println(httpresponse.version()); //tipo de protocolo

        System.out.println("Teste");
        Thread.sleep(3000);
    }
}