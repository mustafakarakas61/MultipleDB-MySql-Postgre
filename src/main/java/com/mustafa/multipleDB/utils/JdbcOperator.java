package com.mustafa.multipleDB.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

public class JdbcOperator extends JdbcTemplate {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;
    private DataSourceTransactionManager dataSourceTransactionManager;
    private Boolean isPostgre;

    //-------------------------------------------------Constructor
    public JdbcOperator() {

    }

    public JdbcOperator(DataSource dataSource) {
        super(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this);
    }

    public JdbcOperator(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this);
    }

    //-------------------------------------------------Getter-Setter
    public DataSource getDataSource() {
        return this.getDataSourceTransactionManager() != null ? this.dataSourceTransactionManager.getDataSource() : super.getDataSource();
    }

    public DataSourceTransactionManager getDataSourceTransactionManager() {
        return this.dataSourceTransactionManager;
    }

    public void setDataSourceTransactionManager(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    public TransactionTemplate getTransactionTemplate() {
        if (this.transactionTemplate == null) {
            this.transactionTemplate = new TransactionTemplate(this.getDataSourceTransactionManager());
        }

        return this.transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        if (this.namedParameterJdbcTemplate == null) {
            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    public void setPostgre(Boolean postgre) {
        this.isPostgre = postgre;
    }

    public void setIsPostgre(Boolean isPostgre) {
        this.isPostgre = isPostgre;
    }

    public Boolean isPostegre() {
        return this.isPostgre;
    }

    public Boolean getIsPostgre() {
        return this.isPostgre;
    }


}
