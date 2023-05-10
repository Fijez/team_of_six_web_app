package team.of.six.firstwebapp.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application-postgresql.properties")
public class PostgresqlDataSource
{

}
