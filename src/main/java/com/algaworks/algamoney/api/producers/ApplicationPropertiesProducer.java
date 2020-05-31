package com.algaworks.algamoney.api.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationPropertiesProducer {

    @Value("${spring.datasource.hikari.connection-timeout}")
    private Long connectionTimeOut;

    @Value("${spring.datasource.hikari.minimum-idle}")
    private Integer minimumIdle;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer maximumPoolSize;

    @Value("${spring.datasource.hikari.idle-timeout}")
    private Long idleTimeOut;

    @Value("${spring.datasource.hikari.max-lifetime}")
    private Long maxLifeTime;

    @Value("${spring.datasource.hikari.pool-name}")
    private String PoolName;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    //@Value("${spring.datasource.driver-class-name}")
    private String driveClassName;

    public Long getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public Integer getMinimumIdle() {
        return minimumIdle;
    }

    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public Long getIdleTimeOut() {
        return idleTimeOut;
    }

    public Long getMaxLifeTime() {
        return maxLifeTime;
    }

    public String getPoolName() {
        return PoolName;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDriveClassName() {
        return driveClassName;
    }
}
