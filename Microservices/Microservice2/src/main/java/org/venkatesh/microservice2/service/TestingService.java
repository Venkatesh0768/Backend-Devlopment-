package org.venkatesh.microservice2.service;

import org.springframework.stereotype.Service;

@Service
public class TestingService {

    public final FeignService feignService;

    public TestingService(FeignService feignService) {
        this.feignService = feignService;
    }

    public String getInfo2(){
        return feignService.getInfo();
    }
}
