package ru.innopolis.my.server.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.innopolis.my.server.repository")
public class JPAConfig {

    private static final String URL_BASE = "jdbc:h2:~/publicator";

    private static final String DRIVER_DB = "org.h2.Driver";

    private static final String USERNAME_DB = "sa";

    private static final String PASSWORD_DB = "";

    public static final String DATE_FORMAT = "dd.MM.yyyy";

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(getDataSource());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lcemfb.setPackagesToScan("ru.innopolis.my.entity");
        return lcemfb;
    }

    /**
     * Создаем DataSource - MySQL используем пулл apache.commons.dbcp
     *
     * @return dataSource
     */
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_DB);
        dataSource.setUrl(URL_BASE);
        dataSource.setUsername(USERNAME_DB);
        dataSource.setPassword(PASSWORD_DB);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }
}