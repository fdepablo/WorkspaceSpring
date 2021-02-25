package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//Esta anotacion decimos que esta clase va a llevar la 
//configuración de nuestro proyecto de spring
//como si fuera un bean.xml
@Configuration
@ComponentScan(basePackages={"modelo"})
public class Configuracion {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		//la configuracion para conectarse a mysql 8
		/*
		dataSource.
			setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bbdd07?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");*/
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:c:/h2/pruebaJdbcTemplate");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}





