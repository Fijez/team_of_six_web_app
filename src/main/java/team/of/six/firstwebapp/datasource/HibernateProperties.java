package ru.rt.it.bonuslab.configuration.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jpa")
@PropertySource(value = "classpath:hibernate.properties", encoding = "UTF-8")
public class HibernateProperties extends Properties
{

}
