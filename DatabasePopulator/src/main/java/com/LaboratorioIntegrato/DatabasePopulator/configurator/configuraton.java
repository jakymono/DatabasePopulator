package com.LaboratorioIntegrato.DatabasePopulator.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class configuraton {

    /**
     * Metodo di configurazione del Webclient
     * @return WebClient
     */
    @Bean
    public WebClient webclient() {

        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","v3.football.api-sports.io");
        headers.add("x-rapidapi-key","0300e3edab592b023d02b792198506f0");

        return WebClient
                .builder()
                .baseUrl("https://v3.football.api-sports.io/status")
                .defaultCookie("cookieKey", "cookieValue")
                .exchangeStrategies(strategies)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeaders(h -> h.addAll(headers))
                .build();
}



}
