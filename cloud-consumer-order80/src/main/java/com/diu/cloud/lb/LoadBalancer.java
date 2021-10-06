package com.diu.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoadBalancer {

    /**
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
