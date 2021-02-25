package gestor;

import org.springframework.stereotype.Service;

@Service
public class GestorUsuario {
	
	
	public boolean validar (String usuario, String password)
	
	{
		if ("jesus".equals(usuario) && password.equals("12345"))
		{
			return true;
		}else if ("marta".equals(usuario) && password.equals("12345"))
		{
			return true;
		}else 
		{
			return false;
		}
		
		
	}

}
