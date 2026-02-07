package sqch113.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import sqch113.model.Payment;

@Component
public class PaymentsProxy {
    private final WebClient webClient;
    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }
    @Value("${name.service.url}")
    private String url;

    public Mono<Payment> getPayment(String id, Payment payment) {
        return webClient.post()
                .uri(url+"/payment")
                .header("requestId",id)
                .body(Mono.just(payment),Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
