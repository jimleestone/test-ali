package com.izayoi.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("storage-service")
public interface StorageFeignClient {

	@GetMapping("/deduct")
	void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
