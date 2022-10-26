package com.example.provider.serviceImpl;

import com.example.common.redisConfig.RedisClient;
import com.example.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private RedisClient redisClient;
    @Override
    public String sayHello2Consumer(String s) {
        System.out.println("provider s: " + s);
        return s;
    }

    @Override
    public void setValue(String key, Object value, long time) {
        redisClient.set(key, value, time);
    }

    @Override
    public String getValue(String key) {
        return redisClient.get(key) == null ? "time out or not existed key!" : redisClient.get(key);
    }
}
