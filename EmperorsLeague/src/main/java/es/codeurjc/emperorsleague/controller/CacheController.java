package es.codeurjc.emperorsleague.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    private CacheManager cacheManager;

    @GetMapping(value = "/equipos/cache")
    public Map<Object, Object> getEquiposCacheContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("equipos");

        return cache.getNativeCache();
    }

    @GetMapping(value = "/jugadores/cache")
    public Map<Object, Object> getJugadoresCacheContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("jugadores");

        return cache.getNativeCache();
    }

    @GetMapping(value = "/partidos/cache")
    public Map<Object, Object> getPartidosCacheContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("partidos");

        return cache.getNativeCache();
    }
}