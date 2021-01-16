package dev.sda.team2.pma.Audit4J;


import org.audit4j.core.MetaData;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.Layout;
import org.audit4j.core.layout.SimpleLayout;
import org.audit4j.integration.spring.AuditAspect;
import org.audit4j.integration.spring.SpringAudit4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
public class Audit4JConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public Layout layout() {
        return new SimpleLayout();
    }

    @Bean
    public MetaData metaData() {
        return new MyMetaData();
    }

    @Bean
    public FileAuditHandler fileAuditHandler() {
        return new FileAuditHandler();
    }

    @Bean
    public SpringAudit4jConfig springAudit4jConfig() {
        SpringAudit4jConfig audit4jConfig = new SpringAudit4jConfig();
        audit4jConfig.setLayout(new SimpleLayout());
        Map<String, String> props = new HashMap<>();
        props.put("log.file.location", "src/main/resources/Audit");
        List<Handler> handlers = new ArrayList<>();
        handlers.add(fileAuditHandler());
        audit4jConfig.setHandlers(handlers);
        audit4jConfig.setLayout(layout());
        audit4jConfig.setMetaData(metaData());
        audit4jConfig.setProperties(props);
        return audit4jConfig;
    }

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect();
    }
}
