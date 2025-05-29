package br.gov.sp.cps.ProjetoSpringIoC.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfig {

    @PostConstruct  // Garante que ao iniciar a app "executa" o timeZoneConfig
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
