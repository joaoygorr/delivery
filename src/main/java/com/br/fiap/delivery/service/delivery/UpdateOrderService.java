package com.br.fiap.delivery.service.delivery;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.br.fiap.delivery.exceptions.Exception404;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UpdateOrderService {
    private final HttpClient httpClient;

    public UpdateOrderService (){
        this.httpClient = HttpClient.newHttpClient();
    }

    public void updateOrderStatus (String orderId, String newOrderStatus) throws IOException, InterruptedException, Exception404 {
        String pedidosUrl = System.getenv("PEDIDOS_URL");

        if (pedidosUrl == null || pedidosUrl.isEmpty()) {
            System.out.println("A variável de ambiente 'PEDIDOS_URL' não está configurada.");
            return;
        }

        log.info(pedidosUrl);

        String requestBody = String.format("""
                {
                    "orderId": "%s",
                    "paymentStatus": "%s"
                }
                """, orderId, newOrderStatus);
        
        log.info(requestBody);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(pedidosUrl))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()!=200){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Pedido não encontrado!");
            }

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            throw e;
        }
    }

}