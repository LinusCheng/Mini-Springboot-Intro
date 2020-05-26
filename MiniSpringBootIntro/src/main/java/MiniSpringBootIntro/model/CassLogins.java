package MiniSpringBootIntro.model;

import lombok.Data;

@Data
public class CassLogins {

    private String contactPoints;
    private String port;
    private String username;
    private String password;
    private Boolean ssl;
    private String keyspace;

}
