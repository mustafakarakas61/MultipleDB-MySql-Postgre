package com.mustafa.multipleDB.service;


import com.mustafa.multipleDB.entity.DefCity;
import com.mustafa.multipleDB.utils.JdbcOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private BeanPropertyRowMapper<DefCity> defCityBeanPropertyRowMapper = new BeanPropertyRowMapper<>(DefCity.class);

    @Autowired
    @Qualifier("jdbcOperatorPostgre")
    private JdbcOperator jdbcOperatorPostgre;

    //-------------------------------------------------Constructor
    public CityService(JdbcOperator jdbcOperatorPostgre) {
        this.jdbcOperatorPostgre = jdbcOperatorPostgre;
    }

    //-------------------------------------------------Methods
    public List<DefCity> cityList() {
        return this.jdbcOperatorPostgre.query("select * from def_city", defCityBeanPropertyRowMapper);
    }

}
