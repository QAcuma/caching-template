package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Cat;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringCatService {

    public static final String CATS = "CATS";
    public static final String DOGS = "DOGS";

    @Cacheable(cacheNames = CATS, key = "#id")
    public Cat findCat(Long id) {
        log.info("Finding cat processing");
        return new Cat();
    }

    @CachePut(cacheNames = CATS, key = "#cat.getId()")
    public Cat findCat(Cat cat) {
        log.info("Puting cat processing");
        return new Cat();
    }

    @CacheEvict(cacheNames = CATS, key = "#id")
    public void dropCat(Long id) {
        log.info("Dropping cat processing");
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = CATS, allEntries = true),
            @CacheEvict(cacheNames = DOGS, allEntries = true)
    })
    public void dropAll() {
        log.info("Dropping cat processing");
    }
}
