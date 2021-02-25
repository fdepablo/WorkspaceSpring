package entidades;

//https://www.baeldung.com/spring-mvc-session-attributes
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@Scope("session")
@SessionScope
public class Saludos {
	private List<String> listaSaludos = new ArrayList<>();

	public List<String> getListaSaludos() {
		return listaSaludos;
	}

	public void setListaSaludos(List<String> listaSaludos) {
		this.listaSaludos = listaSaludos;
	}
	
	
}
