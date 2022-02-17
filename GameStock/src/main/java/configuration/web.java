package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class web implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext container) {
// Registra la clase de configuraci�n del modelo
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(modeloConfig.class);
// Registra la clase de configuraci�n del controlador
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
					//mvcConfig es el archivo que hemos creado de configuracion
		dispatcherContext.register(mvcConfig.class);
// Gestiona el ciclo de vida del contexto de aplicaci�n
		container.addListener(new ContextLoaderListener(rootContext));
// Crea y registra el DispatcherServlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
				new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}