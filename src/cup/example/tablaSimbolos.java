package cup.example;
import java.io.*;
import java.util.*;

public class tablaSimbolos{
		 HashMap t;
		 public tablaSimbolos(){
			 t = new HashMap();
		 }
		 public simboloLista insertar(String tipo, String id, Double valorD, Boolean valorB, Character valorC){
			 simboloLista s = new simboloLista(tipo, id, valorD, valorB, valorC); 
			 t.put(id, s);
			 return s;
		 }
		 public simboloLista insertarVector(String tipo, String id, Double valorD, Boolean valorB, Character valorC, Integer dimension1, Integer dimension2){
			 simboloLista s = new simboloLista(tipo, id, valorD, valorB, valorC, dimension1, dimension2); 
			 t.put(id, s);
			 return s;
		 }
		 public void put(String id, simboloLista s){
			 t.put(id, s);
		 }
		 public simboloLista buscar(String id){
			 return (simboloLista)(t.get(id));
		 }
		 public void rellenarFicheroSalida() throws IOException {
			 FileWriter fichero = null;
		     PrintWriter pw = null;
		        try
		        {
		            fichero = new FileWriter("./output.txt");
		            pw = new PrintWriter(fichero);
		            Iterator it = t.values().iterator();
		            Iterator it1 = t.values().iterator();
		            
		            pw.println("LISTADO DE TODAS LAS VARIABLES:");
		            pw.println("");

		            while(it.hasNext()){
						 simboloLista s = (simboloLista)it.next();
						 //S?mbolos normales 
						 if(s.tipo.equalsIgnoreCase("Entero") && s.dimension1 == null) 
							 pw.println(s.tipo + " " + s.id);
						 if(s.tipo.equalsIgnoreCase("Real") && s.dimension1 == null) 
							 pw.println(s.tipo + " " + s.id);
						 if(s.tipo.equalsIgnoreCase("Booleano") && s.dimension1 == null) 
							 pw.println(s.tipo + " " + s.id);
						 if(s.tipo.equalsIgnoreCase("Caracter") && s.dimension1 == null) 
							 pw.println(s.tipo + " " + s.id);	
						 //Vectores dos dimensiones
						 if(s.dimension1 != null && s.dimension2 != null) {
							pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + s.dimension1 + "]" + "[" + s.dimension2 + "]");
						 }
						//Vectores una dimension
						 if(s.dimension1 != null && s.dimension2 == null) {
							 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + s.dimension1 + "]");
						 }
					 }
		            
		            pw.println("");
					pw.println("LISTADO DE VARIABLES CONSTANTES:");
					pw.println("");
		            
	            	while(it1.hasNext()){
						 simboloLista s = (simboloLista)it1.next();
						 if(s.isChanged == null) {
							 //S?mbolos normales 
							 if(s.tipo.equalsIgnoreCase("Entero") && s.dimension1 == null) 
								 pw.println(s.tipo + " " + s.id + " := "+ s.valorD);
							 if(s.tipo.equalsIgnoreCase("Real") && s.dimension1 == null) 
								 pw.println(s.tipo + " " + s.id + " := "+ s.valorD);
							 if(s.tipo.equalsIgnoreCase("Booleano") && s.dimension1 == null) 
								 pw.println(s.tipo + " " + s.id + " := "+ s.valorB);
							 if(s.tipo.equalsIgnoreCase("Caracter") && s.dimension1 == null) 
								 pw.println(s.tipo + " " + s.id + " := "+ s.valorC);	
							 //Vectores dos dimensiones
							 if(s.dimension1 != null && s.dimension2 != null) {
								 if(s.tipo.equalsIgnoreCase("Entero")) {
									 for (int i = 0; i < s.dimension1; i++){
										 for (int j = 0; j < s.dimension2; j++){
											 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorDVector2[i][j]);
										 }
									 }
								 }
								 if(s.tipo.equalsIgnoreCase("Real")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 for (int j = 0; j < s.dimension2; j++){
											 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorDVector2[i][j]);
										 }
									 }
								 }
								 if(s.tipo.equalsIgnoreCase("Booleano")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 for (int j = 0; j < s.dimension2; j++){
											 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorBVector2[i][j]);
										 }
									 }
								 }
								 if(s.tipo.equalsIgnoreCase("Caracter")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 for (int j = 0; j < s.dimension2; j++){
											 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorCVector2[i][j]);
										 }
									 }
								 }
							 }
							//Vectores una dimension
							 if(s.dimension1 != null && s.dimension2 == null) {
								 if(s.tipo.equalsIgnoreCase("Entero")) {
									 for (int i = 0; i < s.dimension1; i++){
										 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorDVector[i]);
									 }
								 }
								 if(s.tipo.equalsIgnoreCase("Real")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorDVector[i]);
									 }
								 }
								 if(s.tipo.equalsIgnoreCase("Booleano")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorBVector[i]);
									 }
							 	 }
								 if(s.tipo.equalsIgnoreCase("Caracter")) { 
									 for (int i = 0; i < s.dimension1; i++){
										 pw.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorCVector[i]);
									 }
								 }
							 }
						 }
					 }
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		           try {
		           // Nuevamente aprovechamos el finally para 
		           // asegurarnos que se cierra el fichero.
		           if (null != fichero)
		              fichero.close();
		           } catch (Exception e2) {
		              e2.printStackTrace();
		           }
		        }
		 }
		 public void imprimir(){
			 Iterator it = t.values().iterator();
			 while(it.hasNext()){
				 simboloLista s = (simboloLista)it.next();
				 //S?mbolos normales
				 if(s.tipo.equalsIgnoreCase("Entero") && s.dimension1 == null) 
					 System.out.println(s.tipo + " " + s.id + " := "+ s.valorD + " //Modificado: " + s.isChanged);
				 if(s.tipo.equalsIgnoreCase("Real") && s.dimension1 == null) 
					 System.out.println(s.tipo + " " + s.id + " := "+ s.valorD + " //Modificado: " + s.isChanged);
				 if(s.tipo.equalsIgnoreCase("Booleano") && s.dimension1 == null) 
					 System.out.println(s.tipo + " " + s.id + " := "+ s.valorB + " //Modificado: " + s.isChanged);
				 if(s.tipo.equalsIgnoreCase("Caracter") && s.dimension1 == null) 
					 System.out.println(s.tipo + " " + s.id + " := "+ s.valorC + " //Modificado: " + s.isChanged);	
				 //Vectores dos dimensiones
				 if(s.dimension1 != null && s.dimension2 != null) {
					 if(s.tipo.equalsIgnoreCase("Entero")) {
						 for (int i = 0; i < s.dimension1; i++){
							 for (int j = 0; j < s.dimension2; j++){
								 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorDVector2[i][j] + " //Modificado: " + s.isChanged);
							 }
						 }
					 }
					 if(s.tipo.equalsIgnoreCase("Real")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 for (int j = 0; j < s.dimension2; j++){
								 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorDVector2[i][j] + " //Modificado: " + s.isChanged);
							 }
						 }
					 }
					 if(s.tipo.equalsIgnoreCase("Booleano")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 for (int j = 0; j < s.dimension2; j++){
								 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorBVector2[i][j] + " //Modificado: " + s.isChanged);
							 }
						 }
					 }
					 if(s.tipo.equalsIgnoreCase("Caracter")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 for (int j = 0; j < s.dimension2; j++){
								 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "]" + "[" + j + "] := "+ s.valorCVector2[i][j] + " //Modificado: " + s.isChanged);
							 }
						 }
					 }
				 }
				//Vectores una dimension
				 if(s.dimension1 != null && s.dimension2 == null) {
					 if(s.tipo.equalsIgnoreCase("Entero")) {
						 for (int i = 0; i < s.dimension1; i++){
							 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorDVector[i] + " //Modificado: " + s.isChanged);
						 }
					 }
					 if(s.tipo.equalsIgnoreCase("Real")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorDVector[i] + " //Modificado: " + s.isChanged);
						 }
					 }
					 if(s.tipo.equalsIgnoreCase("Booleano")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorBVector[i] + " //Modificado: " + s.isChanged);
						 }
				 	 }
					 if(s.tipo.equalsIgnoreCase("Caracter")) { 
						 for (int i = 0; i < s.dimension1; i++){
							 System.out.println("VECTOR " + s.tipo + " " + s.id +  " [" + i + "] := "+ s.valorCVector[i] + " //Modificado: " + s.isChanged);
						 }
					 }
				 }
			 }
	}
}

