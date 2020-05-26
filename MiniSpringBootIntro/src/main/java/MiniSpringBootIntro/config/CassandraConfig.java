package MiniSpringBootIntro.config;

import MiniSpringBootIntro.model.CassLogins;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


import static com.datastax.driver.core.schemabuilder.SchemaBuilder.createKeyspace;


@Configuration
@EnableConfigurationProperties(CassandraProperties.class)
public class CassandraConfig {

    private static final Logger logger = LoggerFactory.getLogger(CassandraConfig.class);

    private final CassandraProperties cassandraProperties;
    private CassLogins cassLogins;


    public CassandraConfig(CassandraProperties cassandraProperties) {
        this.cassandraProperties = cassandraProperties;
        this.cassLogins = cassandraProperties.getCluster().get(cassandraProperties.getDbUse());
    }

    @Bean
    public CassandraClusterFactoryBean cluster(){
        logger.info("== In Cass Cluster Bean ==");
        logger.debug("Show test text: " + cassandraProperties.getTest());

        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(cassLogins.getContactPoints());
        cluster.setPort(Integer.parseInt(cassLogins.getPort()));
//        cluster.setUsername(cassLogins.getUsername());
//        cluster.setSslEnabled(cassLogins.getSsl());
//        cluster.setPassword(StringUtils.chomp(
//                new String(Base64.getDecoder().decode(cassLogins.getPassword())),
//                String.valueOf(Charset.forName("UTF-8"))
//        ));
        logger.info("cluster set already");
        System.out.println(new Timestamp(System.currentTimeMillis()));

        return cluster;
    }

    @Bean
    public Session session(Cluster cluster) {
        final Session session = cluster.connect();
        setupKeyspace(session, cassLogins.getKeyspace());
        return session;
    }

    private void setupKeyspace(Session session, String keyspace){
        final Map<String, Object> replication = new HashMap<>();
        replication.put("class", "SimpleStrategy");
        replication.put("replication_factor", 1);
        session.execute(createKeyspace(keyspace).ifNotExists().with().replication(replication));
        session.execute("USE " + keyspace);
    }


}
