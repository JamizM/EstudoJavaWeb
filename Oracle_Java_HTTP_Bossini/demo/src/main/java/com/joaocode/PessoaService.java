package com.joaocode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
//? a uma classe, o Lombok gera automaticamente um construtor que recebe como parâmetros todos os campos que são final ou que não foram explicitamente inicializados com @NonNull ou algum valor padrão.
public class PessoaService {
        HttpClient httpClient = HttpClient.newHttpClient();

        //construtor gerado apenas para campos que requerem tratamento
        //por ser final, precisa ser inicializado
        private final String url; //? inicializado por conta do @requiredargsconstructor

    public void listar() throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build(); //retorna uma HttpRequest
        
        var res = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(res.body());
    }
}
    