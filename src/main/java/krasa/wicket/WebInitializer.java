package krasa.wicket;

import javax.servlet.*;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebInitializer implements ServletContextInitializer {

	public static final String WICKET_WEBSOCKET = "wicket.filter";

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		FilterRegistration filter = sc.addFilter(WICKET_WEBSOCKET, WicketFilter.class);

		filter.setInitParameter("applicationClassName", WicketApplication.class.getCanonicalName());
		filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		filter.addMappingForUrlPatterns(null, false, "/*");

		sc.getSessionCookieConfig().setMaxAge(
				60 * 60 * 10); // reloads page with ajax after it expires, i have no idea how it works.
	}

}