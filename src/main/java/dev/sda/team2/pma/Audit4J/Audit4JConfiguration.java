package dev.sda.team2.pma.Audit4J;


import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.CustomizableLayout;
import org.audit4j.core.layout.Layout;
import org.audit4j.integration.spring.AuditAspect;
import org.audit4j.integration.spring.SpringAudit4jConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
public class Audit4JConfiguration {

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect();
    }

    private Map<String, String> getProperties() {
        Map<String, String> props = new HashMap<>();
        props.put("log.file.location", ".");
        return props;
    }

    @Bean
    public Layout layout() {

        CustomizableLayout layout = new CustomizableLayout();
        // layout.setTemplate("${eventDate}|${uuid}|actor=${actor}|${action}|origin=${origin} => ${foreach fields field}${field.name} ${field.type}:${field.value}, ${end}");
        layout.setTemplate("${eventDate}|${uuid}|${actor}|${action}|${origin} => ${foreach fields field}${field.name} ${field.type}:${field.value}, ${end}");
        return layout;

/*        return new SimpleLayout();*/
    }

    @Bean
    public FileAuditHandler fileAuditHandler() {
        return new FileAuditHandler();
    }

    @Bean
    public SpringAudit4jConfig springAudit4jConfig() {
        SpringAudit4jConfig audit4jConfig = new SpringAudit4jConfig();
        List<Handler> handlers = new ArrayList<>();
        handlers.add(fileAuditHandler());
        audit4jConfig.setHandlers(handlers);
        audit4jConfig.setLayout(layout());
        audit4jConfig.setMetaData(new AuditMetaData());
        audit4jConfig.setProperties(getProperties());
        return audit4jConfig;
    }
}
