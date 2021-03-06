package sla.tacocloud.tacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TacoCloudConfiguration {

    @Bean
    @Profile("!prod")
    public DummyBeanConfig getDataSource() {
        return new DummyBeanConfig();
    }

}
