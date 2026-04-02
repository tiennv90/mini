package shipping.mini.order.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shipping.mini.order.dto.ParcelDTO;

@FeignClient(name = "parcel-rest-client", url = "http://localhost:8081/v1")
public interface ParcelRestClient {
	
	@GetMapping("/parcels")
	List<ParcelDTO> getParcelsByShipmentIds(@RequestParam("shipmentIds") List<Long> shipmentIds);
}
