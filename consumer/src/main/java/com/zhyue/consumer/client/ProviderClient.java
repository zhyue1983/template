package com.zhyue.consumer.client;

import com.zhyue.consumer.client.model.provider.User;
import com.zhyue.consumer.model.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//url = "http://40.73.47.184/"
//url = "${charging.url}"
@FeignClient(value = "provider", url = "http://localhost:8081/", configuration = ClientConfig.class)
public interface ProviderClient {

    @GetMapping(value = "/user/getUser")
    BaseResponse<User> getUserById(@RequestParam int id);

}