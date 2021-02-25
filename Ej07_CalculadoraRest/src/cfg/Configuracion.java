package cfg;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
@Configuration
@ComponentScan(basePackages = { "modelo" })
@EnableTransactionManagement // Para buscar etiquetas @Transaction
public class Configuracion {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/operaciones?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
			new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		// Le digo d�nde tengo que ir a buscar mis anotaciones Entity
		entityManagerFactoryBean.setPackagesToScan("modelo.entidades");

		Properties jpaProperties = new Properties();
		
		// Trabajamos con mysql, por eso vamos a poner su dialecto
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		/*
		 * Va a mirar si las tablas estan en la base de datos. 
		 * Con create-drop va a generar todas las tablas cada vez que arranquemos perdiendo los datos
		 * Con update te actualiza las tablas sin borrar su contenido.
		 */
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");//create-drop update
		
		/*
		 * Me sacar� por traza de log las sentencias sql que se vayan lanzando
		 * en la bbdd
		 */
		jpaProperties.put("hibernate.show_sql", "true");
		
		/*
		 * Para que las consultas anteriores esten formateadas
		 */
		jpaProperties.put("hibernate.format_sql", "true");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}

/*
 * -------- EntityManager de encarga: --------
 * De gestionar todo lo relacionado con la BBDD. 
 * El n�mero de conexiones que tenemos con la base de datos.
 * De gestionar el ORM que vamos a utilizar (en este caso hibernate)
 * 
 * 
 * -------- DataSouce: --------
 * Va a realizar las conexiones con la bbdd
 *
 *
 *
 *-------- Transacciones: --------
 * Son operaciones at�micas: O se ejecutan todas las operaciones o no se ejecuta ninguna.
 * Si abro una transacci�n, no se va a hacer un commit hasta que no se cierre la transacci�n.
 * Puedo hacer rollback de este modo, puesto que no hago commit hasta que no acabe la transacci�n.
 * 
 * @Transaction: si no hay una transacci�n abierta, te la abre.
 * Pero si ya hay una abierta, te la recupera.
 */
