import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Principal {
	
	static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
 
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		
		//Leer fichero empleando NIO.2
		Path origen = Paths.get("D:\\PRUEBAS\\alumnos.csv");
		
		BufferedReader br = Files.newBufferedReader(origen);
		
		Stream<String> lineas = br.lines();
		
		lineas.forEach(linea -> {
			String[] campos = linea.split(";");
			Alumno alumno = new Alumno(Integer.parseInt(campos[0]), campos[1], campos[2]);
			listaAlumnos.add(alumno);
		});
		
		Utilidades.generarXML(listaAlumnos);
		Utilidades.leerXML("nombre");

	}

}
