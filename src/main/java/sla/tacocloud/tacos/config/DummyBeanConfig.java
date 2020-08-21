package sla.tacocloud.tacos.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyBeanConfig {

    public DummyBeanConfig() {
        log.warn("Hello from dummy bean");
    }
}
