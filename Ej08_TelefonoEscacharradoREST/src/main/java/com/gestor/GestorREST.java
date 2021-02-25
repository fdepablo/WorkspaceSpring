package com.gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.entidades.Historia;

@Service
public class GestorREST {
	
private String urlMario="http://192.168.1.50:8080/mensaje";
private String urlJorge="http://192.168.1.38:8080/historia";

	
	public Historia getHistoria ()
	{
		try
		{
		URL url=null;
		InputStream is=null;
		try {
			url = new URL (urlMario);
			is = url.openStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	  
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      is.close();
	      return this.formatearJson(json);
	      
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	     return null;
	    

	}
	
	
	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	 
	 private Historia formatearJson (JSONObject json)
	 {
		
		 Historia h = new Historia ();
		 h.setMensaje(json.getString("mensaje"));
		 h.setPersonaje(json.getString("protagonista"));
		 
		 return h;
		 
	 }

}
