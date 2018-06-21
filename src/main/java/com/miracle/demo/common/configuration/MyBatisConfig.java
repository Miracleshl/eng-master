package com.miracle.demo.common.configuration;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/*@Configuration
 *//*启用事务*//*
@EnableTransactionManagement
*//*引入配置文件，参数为配置文件路径*//*
@PropertySource("classpath:/dev.yml")*/
public class MyBatisConfig implements TransactionManagementConfigurer{

    @Autowired
    DataSource dataSource;

    @Value("${pagePlugin.dialect}")
    private String dialect;

    @Value("${pagePlugin.pageSqlId}")
    private String pageSqlId;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        //分页插件
        //PagePlugin pagePlugin = new PagePlugin();

        PageHelper pagePlugin = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", dialect);
        //properties.setProperty("pageSqlId", pageSqlId);
        pagePlugin.setProperties(properties);
        System.out.println("mysql".equals(dialect) + "====" + pageSqlId.toString());

        //添加插件
        //bean.setPlugins(new PageHelper[]{pagePlugin});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
