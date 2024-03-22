package ies.jandula.dragonBall.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ies.jandula.dragonBall.exceptions.DragonBallExceptions;
import ies.jandula.dragonBall.models.DragonBall;

/**
 * @author Juan Jurado
 */
public class Main 
{
	/** 
	 * @param args
	 * @throws IOException
	 * @throws DragonBallExceptions
	 */
    public static void main(String[] args) throws IOException, DragonBallExceptions 
    {
    	
        String archivo = "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "DragonBall.csv";

        File file = new File(archivo);
        
        FileWriter fileWriter = null;
        
        PrintWriter printWriter = null;
        
        Scanner scanner = null;
                
        try
        {       
        	fileWriter = new FileWriter("ejercicioDragonBall.txt");
            
            printWriter = new PrintWriter(fileWriter);
            
            scanner = new Scanner(file);            
                        
            Map<String,Map<String,DragonBall>>mapaSeries = new TreeMap<String, Map<String,DragonBall>>();  
            
            scanner.nextLine();
            
            while (scanner.hasNextLine())
            {     
            	
            	String linea = scanner.nextLine() ;            	
            	            
                Pattern lineaSimple = Pattern.compile("^([A-Za-z ()\\'\\-\\\"]+),([0-9]+),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaSimple = lineaSimple.matcher(linea);
                
                Pattern lineaPoderPunto = Pattern.compile("^([A-Za-z ]+),([0-9]+[.][0-9]),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderPunto = lineaPoderPunto.matcher(linea);
                
                Pattern lineaComillaPrincipio = Pattern.compile("^(\\\"[a-zA-Z (),]+\\\"),([0-9]+),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaComillaPrincipio = lineaComillaPrincipio.matcher(linea);
                
                Pattern lineaPersonajeExclamacion = Pattern.compile("^([A-Za-z ()\\'\\-\\!]+),([0-9]+),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeExclamacion = lineaPersonajeExclamacion.matcher(linea);
                
                Pattern lineaPersonajeNumero = Pattern.compile("^([A-Za-z0-9 ()\\'\\-]+),([0-9]+),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeNumero = lineaPersonajeNumero.matcher(linea);
                
                Pattern lineaPersonajeNumero2 = Pattern.compile("^([A-Za-z x0-x9 ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\.\\/\\-\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeNumero2 = lineaPersonajeNumero2.matcher(linea);
                
                Pattern lineaPersonajeNumero3 = Pattern.compile("^(\\\"[A-Za-z ()\\'\\-\\.\\,]+\\\"),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\.\\/\\-\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeNumero3 = lineaPersonajeNumero3.matcher(linea);
                
                Pattern lineaPersonajePorcentaje = Pattern.compile("^([A-Za-z0-9% ()\\'\\-]+),([0-9]+),([A-Za-z ]+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajePorcentaje = lineaPersonajePorcentaje.matcher(linea);
                
                Pattern lineaPersonajePorcentaje2 = Pattern.compile("^([A-Za-z0-9% ()\\'\\-]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\:]+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajePorcentaje2 = lineaPersonajePorcentaje2.matcher(linea);     
                
                Pattern lineaPersonajePorcentaje3 = Pattern.compile("^(\\\"[A-Za-z0-9% ().\\,]+\\\"),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\.\\/\\-\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajePorcentaje3 = lineaPersonajePorcentaje3.matcher(linea);  
                
                Pattern lineaPersonajePorcentaje4 = Pattern.compile("^([A-Za-z0-9% ().\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\.\\/\\-\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajePorcentaje4 = lineaPersonajePorcentaje4.matcher(linea);  
                                
                Pattern lineaPersonajeBarra = Pattern.compile("^([A-Za-z0/0-9/9 ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9 \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeBarra = lineaPersonajeBarra.matcher(linea);    
                
                Pattern lineaPersonajeletraNumero = Pattern.compile("^(\\\"[A-Za-z0-9 ()\\'\\-\\.\\,]+\\\"),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\!\\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPersonajeletraNumero = lineaPersonajeletraNumero.matcher(linea);
                
                Pattern lineaSagaPeliculaPunto = Pattern.compile("^([A-Za-z0-9% ()\\'\\-]+),([0-9]+),([A-Za-z \\.]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaPunto = lineaSagaPeliculaPunto.matcher(linea);
                
                Pattern lineaPoderComa = Pattern.compile("^([A-Za-z0-9% ()\\'\\-\\.]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\.]+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderComa = lineaPoderComa.matcher(linea);
                
                Pattern lineaPoderComaMil = Pattern.compile("^(\\\"[A-Za-z0-9% ()\\'\\-\\.\\,]+\\\"),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\.]+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderComaMil = lineaPoderComaMil.matcher(linea);
                
                Pattern lineaSagaPeliculaBarra = Pattern.compile("^([A-Za-z0-9% ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\.\\/]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaBarra = lineaSagaPeliculaBarra.matcher(linea);
                
                Pattern lineaPoderNumeroSagaPeliculaBarra = Pattern.compile("^([A-Za-z0-9% ()\\'\\-\\.\\,]+),([0-9]+),([A-Za-z \\.\\/]+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderNumeroSagaPeliculaBarra = lineaPoderNumeroSagaPeliculaBarra.matcher(linea);
                
                Pattern lineaSagaPeliculaBarra2 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0-9]+),([A-Za-z \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaBarra2 = lineaSagaPeliculaBarra2.matcher(linea);
                
                Pattern lineaSagaPeliculaBarra3 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0.0-9.9]+),([A-Za-z \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaBarra3 = lineaSagaPeliculaBarra3.matcher(linea);
                
                Pattern lineaSagaPeliculaRaya = Pattern.compile("^([A-Za-z0-9% ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaRaya = lineaSagaPeliculaRaya.matcher(linea);
                
                Pattern lineaSagaPeliculaNumero = Pattern.compile("^([A-Za-z0-9% ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9 \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaNumero = lineaSagaPeliculaNumero.matcher(linea);
                
                Pattern lineaSagaPeliculaNumero2 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0-9]+),([A-Za-z0-9 \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaNumero2 = lineaSagaPeliculaNumero2.matcher(linea);
                
                Pattern lineaSagaPeliculaNumero3 = Pattern.compile("^(\\\"[A-Za-z ()\\'\\-\\.\\,]+\\\"),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9 \\.\\/\\-]+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaNumero3 = lineaSagaPeliculaNumero3.matcher(linea);
                
                Pattern lineaSagaPeliculaNumero4 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0.0-9.9]+),([A-Za-z0-9: \\.\\/\\-\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaNumero4 = lineaSagaPeliculaNumero4.matcher(linea);
                
                Pattern lineaPoderNumeroSagaPeliculaDosPuntos = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z0-9: \\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderNumeroSagaPeliculaDosPuntos = lineaPoderNumeroSagaPeliculaDosPuntos.matcher(linea);
                
                Pattern lineaPoderNumeroSagaPeliculaDosPuntos2 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0-9]+),([A-Za-z0-9: \\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaPoderNumeroSagaPeliculaDosPuntos2 = lineaPoderNumeroSagaPeliculaDosPuntos2.matcher(linea);
                
                Pattern lineaSagaPeliculaExclamacion = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),([0.0-9.9]+),([A-Za-z \\!\\:\\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaExclamacion = lineaSagaPeliculaExclamacion.matcher(linea);
                
                Pattern lineaSagaPeliculaExclamacion2 = Pattern.compile("^([A-Za-z ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\!\\:\\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaExclamacion2 = lineaSagaPeliculaExclamacion2.matcher(linea);
                
                Pattern lineaSagaPeliculaExclamacion3 = Pattern.compile("^([A-Za-z0-9 ()\\'\\-\\.\\,]+),(\\\"[0,0-9,9]+\\\"),([A-Za-z \\!\\:\\.\\/\\']+),([A-Za-z ]+)$");
                Matcher matcherLineaSagaPeliculaExclamacion3 = lineaSagaPeliculaExclamacion3.matcher(linea);
                                
                if(matcherLineaSimple.matches())
                {
                	String personaje = matcherLineaSimple.group(1);
                	
                	String power = matcherLineaSimple.group(2);
                	
                	String sagaMovie = matcherLineaSimple.group(3);
                	
                	String series = matcherLineaSimple.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderPunto.matches())
                {
                	
             		String personaje = matcherLineaPoderPunto.group(1);
                	
                	String power = matcherLineaPoderPunto.group(2);
                	
                	String sagaMovie = matcherLineaPoderPunto.group(3);
                	
                	String series = matcherLineaPoderPunto.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                    
                    if (!mapaSeries.containsKey(series))
                    {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                    mapaSaga.put(sagaMovie, dragonBall);                                	

                }
             	else if (matcherLineaComillaPrincipio.matches())
                {
                	
         			String personaje = matcherLineaComillaPrincipio.group(1);
                	
                	String power = matcherLineaComillaPrincipio.group(2);
                	
                	String sagaMovie = matcherLineaComillaPrincipio.group(3);
                	
                	String series = matcherLineaComillaPrincipio.group(4);                	
                	 
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeExclamacion.matches())
             	{
             		String personaje = matcherLineaPersonajeExclamacion.group(1);
                	
                	String power = matcherLineaPersonajeExclamacion.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeExclamacion.group(3);
                	
                	String series = matcherLineaPersonajeExclamacion.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeBarra.matches())
             	{
             		String personaje = matcherLineaPersonajeBarra.group(1);
                	
                	String power = matcherLineaPersonajeBarra.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeBarra.group(3);
                	
                	String series = matcherLineaPersonajeBarra.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeNumero.matches())
                {
                	String personaje = matcherLineaPersonajeNumero.group(1);
                	
                	String power = matcherLineaPersonajeNumero.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeNumero.group(3);
                	
                	String series = matcherLineaPersonajeNumero.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeNumero2.matches())
                {
                	String personaje = matcherLineaPersonajeNumero2.group(1);
                	
                	String power = matcherLineaPersonajeNumero2.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeNumero2.group(3);
                	
                	String series = matcherLineaPersonajeNumero2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeNumero3.matches())
                {
                	String personaje = matcherLineaPersonajeNumero3.group(1);
                	
                	String power = matcherLineaPersonajeNumero3.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeNumero3.group(3);
                	
                	String series = matcherLineaPersonajeNumero3.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajePorcentaje.matches())
                {
                	String personaje = matcherLineaPersonajePorcentaje.group(1);
                	
                	String power = matcherLineaPersonajePorcentaje.group(2);
                	
                	String sagaMovie = matcherLineaPersonajePorcentaje.group(3);
                	
                	String series = matcherLineaPersonajePorcentaje.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajePorcentaje2.matches())
                {
                	String personaje = matcherLineaPersonajePorcentaje2.group(1);
                	
                	String power = matcherLineaPersonajePorcentaje2.group(2);
                	
                	String sagaMovie = matcherLineaPersonajePorcentaje2.group(3);
                	
                	String series = matcherLineaPersonajePorcentaje2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajePorcentaje3.matches())
                {
                	String personaje = matcherLineaPersonajePorcentaje3.group(1);
                	
                	String power = matcherLineaPersonajePorcentaje3.group(2);
                	
                	String sagaMovie = matcherLineaPersonajePorcentaje3.group(3);
                	
                	String series = matcherLineaPersonajePorcentaje3.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajePorcentaje4.matches())
                {
                	String personaje = matcherLineaPersonajePorcentaje4.group(1);
                	
                	String power = matcherLineaPersonajePorcentaje4.group(2);
                	
                	String sagaMovie = matcherLineaPersonajePorcentaje4.group(3);
                	
                	String series = matcherLineaPersonajePorcentaje4.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if(matcherLineaPersonajeletraNumero.matches())
                {
                	String personaje = matcherLineaPersonajeletraNumero.group(1);
                	
                	String power = matcherLineaPersonajeletraNumero.group(2);
                	
                	String sagaMovie = matcherLineaPersonajeletraNumero.group(3);
                	
                	String series = matcherLineaPersonajeletraNumero.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaPunto.matches())
                {
                	
         			String personaje = matcherLineaSagaPeliculaPunto.group(1);
                	
                	String power = matcherLineaSagaPeliculaPunto.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaPunto.group(3);
                	
                	String series = matcherLineaSagaPeliculaPunto.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderComa.matches())
                {
                	
         			String personaje = matcherLineaPoderComa.group(1);
                	
                	String power = matcherLineaPoderComa.group(2);
                	
                	String sagaMovie = matcherLineaPoderComa.group(3);
                	
                	String series = matcherLineaPoderComa.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderComaMil.matches())
                {
                	
         			String personaje = matcherLineaPoderComaMil.group(1);
                	
                	String power = matcherLineaPoderComaMil.group(2);
                	
                	String sagaMovie = matcherLineaPoderComaMil.group(3);
                	
                	String series = matcherLineaPoderComaMil.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaBarra.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaBarra.group(1);
                	
                	String power = matcherLineaSagaPeliculaBarra.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaBarra.group(3);
                	
                	String series = matcherLineaSagaPeliculaBarra.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaBarra2.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaBarra2.group(1);
                	
                	String power = matcherLineaSagaPeliculaBarra2.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaBarra2.group(3);
                	
                	String series = matcherLineaSagaPeliculaBarra2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaBarra3.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaBarra3.group(1);
                	
                	String power = matcherLineaSagaPeliculaBarra3.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaBarra3.group(3);
                	
                	String series = matcherLineaSagaPeliculaBarra3.group(4);
                	                	                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderNumeroSagaPeliculaBarra.matches())
                {
                	
             		String personaje = matcherLineaPoderNumeroSagaPeliculaBarra.group(1);
                	
                	String power = matcherLineaPoderNumeroSagaPeliculaBarra.group(2);
                	
                	String sagaMovie = matcherLineaPoderNumeroSagaPeliculaBarra.group(3);
                	
                	String series = matcherLineaPoderNumeroSagaPeliculaBarra.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaRaya.matches())
                {
                	
         			String personaje = matcherLineaSagaPeliculaRaya.group(1);
                	
                	String power = matcherLineaSagaPeliculaRaya.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaRaya.group(3);
                	
                	String series = matcherLineaSagaPeliculaRaya.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaNumero.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaNumero.group(1);
                	
                	String power = matcherLineaSagaPeliculaNumero.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaNumero.group(3);
                	
                	String series = matcherLineaSagaPeliculaNumero.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaNumero2.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaNumero2.group(1);
                	
                	String power = matcherLineaSagaPeliculaNumero2.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaNumero2.group(3);
                	
                	String series = matcherLineaSagaPeliculaNumero2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaNumero3.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaNumero3.group(1);
                	
                	String power = matcherLineaSagaPeliculaNumero3.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaNumero3.group(3);
                	
                	String series = matcherLineaSagaPeliculaNumero3.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaNumero4.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaNumero4.group(1);
                	
                	String power = matcherLineaSagaPeliculaNumero4.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaNumero4.group(3);
                	
                	String series = matcherLineaSagaPeliculaNumero4.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderNumeroSagaPeliculaDosPuntos.matches())
                {
                	
             		String personaje = matcherLineaPoderNumeroSagaPeliculaDosPuntos.group(1);
                	
                	String power = matcherLineaPoderNumeroSagaPeliculaDosPuntos.group(2);
                	
                	String sagaMovie = matcherLineaPoderNumeroSagaPeliculaDosPuntos.group(3);
                	
                	String series = matcherLineaPoderNumeroSagaPeliculaDosPuntos.group(4);                	
                	 
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaPoderNumeroSagaPeliculaDosPuntos2.matches())
                {
                	
             		String personaje = matcherLineaPoderNumeroSagaPeliculaDosPuntos2.group(1);
                	
                	String power = matcherLineaPoderNumeroSagaPeliculaDosPuntos2.group(2);
                	
                	String sagaMovie = matcherLineaPoderNumeroSagaPeliculaDosPuntos2.group(3);
                	
                	String series = matcherLineaPoderNumeroSagaPeliculaDosPuntos2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                } 
             	else if (matcherLineaSagaPeliculaExclamacion.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaExclamacion.group(1);
                	
                	String power = matcherLineaSagaPeliculaExclamacion.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaExclamacion.group(3);
                	
                	String series = matcherLineaSagaPeliculaExclamacion.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaExclamacion2.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaExclamacion2.group(1);
                	
                	String power = matcherLineaSagaPeliculaExclamacion2.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaExclamacion2.group(3);
                	
                	String series = matcherLineaSagaPeliculaExclamacion2.group(4);
                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);

                     
                    if (!mapaSeries.containsKey(series)) {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }
             	else if (matcherLineaSagaPeliculaExclamacion3.matches())
                {
                	
             		String personaje = matcherLineaSagaPeliculaExclamacion3.group(1);
                	
                	String power = matcherLineaSagaPeliculaExclamacion3.group(2);
                	
                	String sagaMovie = matcherLineaSagaPeliculaExclamacion3.group(3);
                	
                	String series = matcherLineaSagaPeliculaExclamacion3.group(4);       
                	                	
                	DragonBall dragonBall = new DragonBall(personaje, power, sagaMovie, series);
                     
                    if (!mapaSeries.containsKey(series)) 
                    {
                        mapaSeries.put(series, new TreeMap<>());
                    }
                    
                    
                    Map<String, DragonBall> mapaSaga = mapaSeries.get(series);
                    
                     
                    mapaSaga.put(sagaMovie, dragonBall);
                }                
                else
                {
                	System.out.println("Expresion a cambiar: "+linea);
                }    
           
            }      
            
            printWriter.println("Numero de series: " + mapaSeries.keySet().size() + "(" + mapaSeries.keySet() + ")");

            for (Map.Entry<String, Map<String, DragonBall>> entrada : mapaSeries.entrySet()) 
            {
                String serie = entrada.getKey();
                int numSagas = entrada.getValue().size();
                
                Map<String, DragonBall> mapaSaga = entrada.getValue();
                
                printWriter.println(serie);
                printWriter.println("   -   Número de sagas: " + numSagas);                 
                
                List<DragonBall> listaPoderes = null;
                
                DragonBall personajeMasPoderoso = null;
                
                DragonBall personajeMasDebil = null;
                
                for (Map.Entry<String, DragonBall> saga : mapaSaga.entrySet())
                {
	                String nombreSaga = saga.getKey();
	               
	                listaPoderes = new ArrayList<>(mapaSaga.values());
	                
	                // Ordenar la lista de personajes por su nivel de poder en orden descendente
	                listaPoderes.sort(Comparator.comparing(DragonBall::getPowerLevel).reversed());
	                
	                personajeMasPoderoso = listaPoderes.get(0);
	                
	                personajeMasDebil = listaPoderes.get(listaPoderes.size()-1);     
	              
	                printWriter.println("   -   Personajes destacados en "+nombreSaga+":"+personajeMasPoderoso.getCharacter()+"("+personajeMasPoderoso.getPowerLevel()+")"+personajeMasDebil.getCharacter()+"("+personajeMasDebil.getPowerLevel()+")");
	                
                } 
            }
            
            printWriter.flush();
            System.out.println("Insertado con exito");

        } 
        catch (FileNotFoundException fileNotFoundException) 
        {
        	String error ="File not found";
            System.out.println(fileNotFoundException.getMessage());
            throw new DragonBallExceptions(1, error, fileNotFoundException);
        }
        finally 
        {
        	scanner.close();
        	fileWriter.close();
        	printWriter.close();
			
		}
    }
}

                
