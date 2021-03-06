import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static int obtenerEntero(String mensaje, int valorDefault){
        int valor = 0;
        boolean valorInvalido = true;
        Scanner entrada;
        do{
            entrada = new Scanner(System.in);
            try {
                if (0 != valorDefault){
                    System.out.print(mensaje + "(" + valorDefault + "): ");
                    String valorInicial = entrada.nextLine();
                    if (valorInicial.equals("")){
                        valor = valorDefault;
                    } else {
                        valor = Integer.parseInt(valorInicial);
                    }
                } else {
                    System.out.print(mensaje + ": ");
                    valor = Integer.parseInt(entrada.nextLine());
                }
                valorInvalido = false;
            } catch(InputMismatchException | NumberFormatException e){
                valorInvalido = true;
                System.out.println("[ERROR] Valor invalido!, vuelve a intentarlo.");
            }
        } while(valorInvalido);
        return valor;
    }

    public static double obtenerDouble(String mensaje, double valorDefault){
        double valor = 0;
        boolean valorInvalido = true;
        Scanner entrada;
        do{
            entrada = new Scanner(System.in);
            try {
                if (0 != valorDefault){
                    System.out.println(mensaje + "(" + valorDefault + "): ");
                    String valorInicial = entrada.nextLine();
                    if (valorInicial.equals("")){
                        valor = valorDefault;
                    } else {
                        valor = Double.parseDouble(valorInicial);
                    }
                } else {
                    System.out.println(mensaje + ": ");
                    valor = Double.parseDouble(entrada.nextLine());
                }
                valorInvalido = false;
            } catch(InputMismatchException | NumberFormatException e){
                valorInvalido = true;
                System.out.println("[ERROR] Valor invalido!, vuelve a intentarlo.");
            }
        } while(valorInvalido);
        return valor;
    }

    public static String obtenerString(String mensaje, String valorDefault){
        String valor = "";
        do{
            Scanner entrada = new Scanner(System.in);
            entrada.useDelimiter("\n");
            if (null != valorDefault){
                System.out.println(mensaje + "(" + valorDefault + "): ");
            } else {
                System.out.println(mensaje + ": ");
            }
            valor = entrada.nextLine();
            if(valor.equals("")){
                if (null != valorDefault){
                    valor = valorDefault;
                } else {
                    System.out.println("[ERROR] Valor invalido!, intente de nuevo");
                }
            }
        }while(valor.equals(""));
        return valor;
    }

    public static String obtenerFecha(String mensaje, String valorDefault){
        String fecha = "";
        boolean fechaInvalida = true;
        int diasMes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        String mensajeError = "[ERROR] Fecha invalida!, vuelve a intentarlo. el formato requerido es (dd/mm/yyyy)";
        System.out.println("[WARNING] Formato de fecha (dd/mm/yyyy)");
        Scanner entrada;
        do{
            entrada = new Scanner(System.in);
            if (null != valorDefault){
                System.out.println(mensaje + "(" + valorDefault + "): ");
            } else {
                System.out.println(mensaje + ": ");
            }
            fecha = entrada.nextLine();
            if (fecha.equals("") && valorDefault != null){
                return valorDefault;
            }
            if (fecha.length() == 10){
                String[] fechaArray = fecha.split("/");
                if(fechaArray.length == 3) {
                    try{
                        int dia = Integer.parseInt(fechaArray[0]);
                        int mes = Integer.parseInt(fechaArray[1]);
                        int anio = Integer.parseInt(fechaArray[2]);
                        if(dia > 0 && mes > 0 && anio > 0
                                && mes <= 12 && dia <= diasMes[(mes - 1)]){
                            fechaInvalida = false;
                        } else {
                            System.out.println(mensajeError);
                        }
                    } catch(NumberFormatException e){
                        System.out.println(mensajeError);
                    }
                } else {
                    System.out.println(mensajeError);
                }
            } else {
                System.out.println(mensajeError);
            }
        } while(fechaInvalida);
        return fecha;
    }

    public static void generarPdf() {
        // Se crea el documento
        Document documento = new Document();
        try {
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");

            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

            // Se abre el documento.
            documento.open();
            documento.add(new Paragraph("Esto es el primer p??rrafo, normalito"));

            documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
                    FontFactory.getFont("arial",   // fuente
                            22,                            // tama??o
                            Font.ITALIC,                   // estilo
                            BaseColor.CYAN)));             // color
            documento.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
