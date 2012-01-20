package edu.mayo.cts2.framework.plugin.service.example;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import edu.mayo.cts2.framework.model.codesystem.CodeSystemCatalogEntry;
import edu.mayo.cts2.framework.model.command.ResolvedReadContext;
import edu.mayo.cts2.framework.model.core.EntryDescription;
import edu.mayo.cts2.framework.model.service.core.NameOrURI;
import edu.mayo.cts2.framework.model.service.core.ReadContext;
import edu.mayo.cts2.framework.model.util.ModelUtils;
import edu.mayo.cts2.framework.service.profile.codesystem.CodeSystemReadService;

@Component
public class ExampleCodeSystemCatalogReadService implements CodeSystemReadService {

	public boolean exists(NameOrURI nameOrUri, ReadContext readContext) {
		//in this example, 'exists' is always true
		return true;
	}

	public CodeSystemCatalogEntry read(NameOrURI nameOrUri, ResolvedReadContext readContext) {
		//NameOrURI can either be a CodeSystenName or its URI. For this example,
		//assume the request is 'by name'.
		String codeSystemName = nameOrUri.getName();
		
		if(StringUtils.isBlank(codeSystemName)){
			throw new UnsupportedOperationException("Only resolution by name is supported.");
		}
		
		//In real-world scenarios, we would fetch from a database or other store. Here
		//we just make up a Resource and return it back.
		CodeSystemCatalogEntry entry = new CodeSystemCatalogEntry();
		
		entry.setCodeSystemName(codeSystemName);
		entry.setAbout("http://cts2/demo#" + codeSystemName);
		
		EntryDescription ed = new EntryDescription();
		ed.setValue(ModelUtils.toTsAnyType(
				"The Code System: " + codeSystemName));
		
		entry.setResourceSynopsis(ed);

		return entry;
	}
	
	
}