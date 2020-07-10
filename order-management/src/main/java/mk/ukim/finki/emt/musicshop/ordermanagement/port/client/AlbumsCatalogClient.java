package mk.ukim.finki.emt.musicshop.ordermanagement.port.client;

import mk.ukim.finki.emt.musicshop.ordermanagement.application.AlbumsCatalog;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.Album;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.AlbumId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
class AlbumsCatalogClient implements AlbumsCatalog {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumsCatalogClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    AlbumsCatalogClient(@Value("http://localhost:8081") String serverUrl,
                         @Value("5000") int connectTimeout,
                         @Value("5000") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    @Override
    public List<Album> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/albums").build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Album>>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving products", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Album findById(AlbumId id) {
        try {
            return restTemplate.exchange(uri().path("/api/albums/"+id.getId()).build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Album>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving product by id", ex);
            return null;
        }
    }
}
