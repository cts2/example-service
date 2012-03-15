package edu.mayo.cts2.framework.plugin.service.example;

import org.springframework.stereotype.Component;

import edu.mayo.cts2.framework.service.profile.Cts2Profile;
import edu.mayo.cts2.framework.service.profile.codesystem.CodeSystemReadService;
import edu.mayo.cts2.framework.service.provider.ServiceProvider;

@Component("exampleServiceProvider")
public class ExampleServiceProvider implements ServiceProvider {

	private ExampleCodeSystemCatalogReadService service = new ExampleCodeSystemCatalogReadService();
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Cts2Profile> T getService(Class<T> clazz) {
		if(clazz == CodeSystemReadService.class){
			return (T) this.service;
		} else {
			return null;
		}
	}
}
