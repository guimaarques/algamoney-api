package com.algaworks.algamoney.api.configs;

import com.algaworks.algamoney.api.producers.ApplicationPropertiesProducer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

//@Configuration: Indicates that a class declares one or more @Bean methods and may be processed by
//the Spring container to generate bean definitions and service requests for those beans at runtime
@Configuration
public class DataSourceConfig implements WebMvcConfigurer {

    //Marking this field as receive or transfer information by Spring dependency injection facilities
    @Autowired
    private ApplicationPropertiesProducer properties;

    //An annotation supports specifying arbitrary initialization
    @Bean
    public DataSource getDataSource() throws IOException{

        //configuration class used to initialize a data source
        HikariConfig config = new HikariConfig();
        //setMinimumIdle: maximum size that the pool is allowed to reach, including both idle and in-use connections.
        config.setMinimumIdle(properties.getMinimumIdle());
        //MaximumPoolSize: controls the maximum number of connections that HikariCP will keep in the pool, including both idle and in-use connection
        config.setMaximumPoolSize(properties.getMaximumPoolSize());
        //PoolName: name of the connection
        config.setPoolName(properties.getPoolName());
        //ConnectionTimeOut: Get the maximum number of milliseconds that a client will wait for a connection from the pool.
        config.setConnectionTimeout(properties.getConnectionTimeOut());
        //IdleTimeout: controls the maximum amount of time (in milliseconds) that a connection is allowed to sit idle in the pool
        config.setIdleTimeout(properties.getIdleTimeOut());
        //MaxLifetime: controls the maximum lifetime of a connection in the pool
        config.setMaxLifetime(properties.getMaxLifeTime());
        //JdbcUrl: set data source url
        config.setJdbcUrl(properties.getDataSourceUrl());
        //UserName: data source user name
        config.setUsername(properties.getUserName());
        //Password: data source password
        config.setPassword(properties.getPassword());

        //return a new connection with data source project connection
        return new HikariDataSource(config);
    }
}
