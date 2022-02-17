//Archivo equivalente a modeloConfig.xml
package configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "dao"/*, entityManagerFactoryRef = "", transactionManagerRef = ""*/)
@EnableTransactionManagement
//Anotacion para vincular las variables con los datos de acceso al archivo application.properties
@PropertySource("classpath:configuration/application.properties")
//Si tenemos que escanear varios componentes => {"service", "controller"}
@ComponentScan(basePackages="service")
@Configuration
public class modeloConfig {

	//Variablers pasadas desde application.properties para proteger los datos
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String pwd;
	
	//Anotar metodo con @bean para que lo pille spring
	@Bean
	public DataSource dataSource() {
		//Con esto creamos la conexion a la base de datos
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(pwd);
		return data;
	}
	
	//adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("videojuegosPU");
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("model");
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}
	
	//gestor de transacción
	@Bean
	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory.getObject());
		return manager;
	}
}