package com.mysz.cloud.service;

import com.mysz.cloud.entities.Consumer;

public interface ConsumerService {
    int insert(Consumer consumer);

    Consumer getById(Long id);
}
