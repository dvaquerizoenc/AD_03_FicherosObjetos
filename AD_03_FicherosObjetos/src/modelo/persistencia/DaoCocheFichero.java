package modelo.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;

public class DaoCocheFichero {
	private static final String NOMBRE_FICHERO = "coches.bin";
	
	public Coche getCocheByID(String id) throws Exception {
		Coche coche = null;
		
		try(FileInputStream file = new FileInputStream(NOMBRE_FICHERO);
			ObjectInputStream escritor = new ObjectInputStream(file);){
			
			coche = (Coche) escritor.readObject();
			
			return coche;
		} catch (IOException e) {
			throw e;
		}
	}
	
	// Borrar coche por id
	
	public List<Coche> getListaCochesDao() throws Exception {
		
		
		try(FileInputStream file = new FileInputStream(NOMBRE_FICHERO);
			ObjectInputStream ois = new ObjectInputStream(file);){
			
			List<Coche> listadoCoches = (List<Coche>)ois.readObject();
			
		
			return listadoCoches;
			
		} catch (Exception e) {
			throw e;
		}
	}
}
