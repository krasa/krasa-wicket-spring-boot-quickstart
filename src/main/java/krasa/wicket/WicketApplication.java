package krasa.wicket;

import krasa.wicket.pages.TestPage;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WicketApplication extends WebApplication {

	@Override
	public Class<TestPage> getHomePage() {
		return TestPage.class;
	}

	@Override
	public void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}

	public ApplicationContext getSpringContext() {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}

	public static WicketApplication getWicketApplication() {
		return ((WicketApplication) get());
	}

}
