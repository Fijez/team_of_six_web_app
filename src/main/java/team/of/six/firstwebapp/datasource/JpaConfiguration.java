package ru.rt.it.bonuslab.configuration.datasource;

import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.rt.it.bonuslab.repository.AdminRepository;
import ru.rt.it.bonuslab.repository.AdminRepositoryImpl;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableTransactionManagement
@AllArgsConstructor
public class JpaConfiguration implements WebMvcConfigurer
{
  private final HibernateProperties hibernateProperties;

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Primary
  @Bean
  public DataSource dataSource(DataSourceProperties properties)
  {
    return properties.initializeDataSourceBuilder().build();
  }

  @Bean
  public AdminRepository adminRepository()
  {
    return new AdminRepositoryImpl();
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
  {
    argumentResolvers.add(new SpecificationArgumentResolver());
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    var em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan(new String[] { "ru.rt.it.bonuslab.model", "ru.rt.it.bonuslabcommons.model.entities" });
    em.setJpaProperties(hibernateProperties);

    var vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    return em;
  }
}
