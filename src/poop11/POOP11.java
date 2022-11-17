package poop11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J34N
 */
public class POOP11 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("######## File #######");
        File archivo = new File("archivo.txt");
        System.out.println(archivo.exists());
        
        try {
            boolean seCreo = archivo.createNewFile();
            System.out.println(seCreo);
            
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("========= Obtener desde teclado ========");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Escribe texto para el archivo: ");
            String texto = br.readLine();
            System.out.println(texto);
            
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("========= FileWriter ========");
        
        try {
            FileWriter fw = new FileWriter("fw.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println("Esto es una impresion del archivo");
            salida.println("Esto es la segunda linea");
            for (int i = 0; i < 10; i++) {
                salida.println("Linea escrita por el for " +i);
            }
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("========= FileReader ========");
        try {
            FileReader fr = new FileReader("fw.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            //System.out.println(linea);
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("======== Alumnos =======");
        Alumno alu = new Alumno();        
        System.out.println("========= FileWriter ========");
        
        try {
            FileWriter fw = new FileWriter("listaAlumnos.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println("Jean,Garcia,Soto,319226304,19,9.3");
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("========= FileReader ========");
        try {
            FileReader fr = new FileReader("listaAlumnos.csv");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            
            System.out.println(linea);
            ArrayList<String> Datos = new ArrayList<String>();
        
            System.out.println("======= StringTokenizer ===========");
            StringTokenizer tokenizador = new StringTokenizer(linea,",");
            while(tokenizador.hasMoreTokens()){
                String token = tokenizador.nextToken();
                System.out.println(token);
                Datos.add(token);
            }
            br.close();
            //Castear
            
            alu.setNombre(Datos.get(0));
            alu.setaPaterno(Datos.get(1)); 
            alu.setaMaterno(Datos.get(2));
            alu.setNumCuenta(Integer.parseInt(Datos.get(3)));
            alu.setEdad(Integer.parseInt(Datos.get(4)));
            //acá se redonde el 9.3 
            alu.setPromedio((int)(Double.parseDouble(Datos.get(5))));
            System.out.println(alu);
            
            
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOP11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
