package com.example.demo.mult;

import com.alibaba.druid.pool.DruidDataSource;
import org.omg.CORBA.ObjectHelper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : DataSourceConfig
 * @Author : ljx
 * @Date: 2021/4/21 11:19
 * @Description :
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.remote")
    public DataSource remoteDataSource(){
        return DataSourceBuilder.create().build();
//        return new DruidDataSource(); //使用Druid数据库连接池
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
//        return new DruidDataSource(); //使用Druid数据库连接池
    }

    @Bean(name="dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource remoteDataSource, DataSource localDataSource){
        Map<Object,Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.REMOTE.name(),remoteDataSource);
        targetDataSource.put(DataSourceType.LOCAL.name(),localDataSource);

        return new DynamicDataSource(remoteDataSource, targetDataSource);
    }

}
