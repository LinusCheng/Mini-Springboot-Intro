package MiniSpringBootIntro.config;

import MiniSpringBootIntro.model.CassLogins;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = CassandraProperties.DATASOURCE_PREFIX)
public class CassandraProperties {

    static final String DATASOURCE_PREFIX = "cass";

    private List<CassLogins> cluster;
    private String test;
    private int dbUse;

}
