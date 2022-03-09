package com.games.user.service.client;

import com.games.user.service.model.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "statistic.service", url = "${statistic.service.url}")
public interface StatisticServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    Greeting getGreetingMessage();
}