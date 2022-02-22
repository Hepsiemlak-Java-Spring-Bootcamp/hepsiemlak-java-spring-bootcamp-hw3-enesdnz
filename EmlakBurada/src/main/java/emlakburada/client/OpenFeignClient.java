package emlakburada.client;

import emlakburada.client.request.BannerRequest;
import emlakburada.client.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="client", url = "http://localhost:8081")
public interface OpenFeignClient {

    @PostMapping(value = "/banners")
    public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request);
}
