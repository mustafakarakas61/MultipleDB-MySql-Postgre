package com.mustafa.multipleDB.config;

import com.mustafa.multipleDB.utils.JdbcOperator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    //-------------------------------------------------SqlDataSource
    @Bean("mysqlDataSource")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/superlig_db");
        dataSource.setUsername("root");
        dataSource.setPassword("180200");
        return (DataSource) dataSource;
    }

    @Bean("postgreDataSource")
    @Primary
    public DataSource postgreDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/trabzon_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("180200");
        return (DataSource) dataSource;
    }

    //-------------------------------------------------JdbcOperatorSql
    @Bean("jdbcOperatorMysql")
    public JdbcOperator jdbcOperatorMysql(@Qualifier("mysqlDataSource") DataSource dataSource) {
        JdbcOperator jdbcOperator = new JdbcOperator(dataSource);
        jdbcOperator.setIsPostgre(false);
        return jdbcOperator;
    }

    @Bean("jdbcOperatorPostgre")
    @Primary
    public JdbcOperator jdbcOperatorPostgre(@Qualifier("postgreDataSource") DataSource dataSource) {
        JdbcOperator jdbcOperator = new JdbcOperator(dataSource);
        jdbcOperator.setIsPostgre(true);
        return jdbcOperator;
    }

    //-------------------------------------------------TransactionManagerSql
    @Bean("transactionManagerMysql")
    public DataSourceTransactionManager transactionManagerMysql(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("transactionManagerPostgre")
    public DataSourceTransactionManager transactionManagerPostgre(@Qualifier("postgreDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
