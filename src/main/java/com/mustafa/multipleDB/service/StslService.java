package com.mustafa.multipleDB.service;

import com.mustafa.multipleDB.entity.DefStsl;
import com.mustafa.multipleDB.utils.JdbcOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StslService {
    private BeanPropertyRowMapper<DefStsl> defStslBeanPropertyRowMapper = new BeanPropertyRowMapper<>(DefStsl.class);

    @Autowired
    @Qualifier("jdbcOperatorMysql")
    private JdbcOperator jdbcOperatorMysql;

    //-------------------------------------------------Constructor
    public StslService(JdbcOperator jdbcOperatorMysql) {
        this.jdbcOperatorMysql = jdbcOperatorMysql;
    }

    //-------------------------------------------------Methods
    public List<DefStsl> stslList() {
        return this.jdbcOperatorMysql.query("select * from def_stsl", defStslBeanPropertyRowMapper);
    }
}
