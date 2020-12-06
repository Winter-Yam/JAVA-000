package my.homework.dynamic.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class DynamicJDBConfig {

    @Bean("masterDatasource")
    @ConfigurationProperties("datasource.master")
    public HikariDataSource masterDatasource() {
        return new HikariDataSource();
    }

    @Bean("masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate() {
        return new JdbcTemplate(masterDatasource());
    }


    @Bean("slaveDatasource")
    @ConfigurationProperties("datasource.slave")
    public HikariDataSource slaveDatasource() {
        return new HikariDataSource();
    }

    @Bean("slaveJdbcTemplate")
    public JdbcTemplate slave1JdbcTemplate() {
        return new JdbcTemplate(slaveDatasource());
    }
}
