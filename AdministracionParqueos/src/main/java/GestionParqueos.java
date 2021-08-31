import jdk.jshell.execution.Util;

public class GestionParqueos {

    public static void main(String[] args){
        menuPrincipal();
    }

    public static void menuPrincipal(){
        int opt = 0;
        do {
            System.out.println("********* Gestion de Parqueos 1.0 *********");
            System.out.println("  1. Configuraciones");
            System.out.println("  2. Ingreso de Vehiculos");
            System.out.println("  3. Egreso de Vehiculos");
            System.out.println("  4. Salir");
            opt = Utils.obtenerEntero("Ingresa una opcion", 0);
            switch (opt) {
                case 1:
                    subMenuConfiguraciones();
                    break;
                case 2:
                    System.out.println("la opcion de ingreso esta pendiente de completa");
                    break;
                case 3:
                    System.out.println("la opcion de egreso esta pendiente de completa");
                    break;
                case 4:
                    System.out.println("Gracias hasta pronto...");
                    break;
                default:
                    System.out.println("[WARNING] UUPS! Opcion invalida.");
            }
        } while (opt != 4);
    }

    public static void subMenuConfiguraciones() {
        int opt = 0;
        System.out.println("++++++++++ (1) Configuraciones ++++++++++");
        System.out.println("  1. Configurar Espacios");
        System.out.println("  2. Configurar Precios");
        System.out.println("  3. Regresar");
        opt = Utils.obtenerEntero("Ingresa una opcion", 0);
        switch (opt) {
            case 1:
                subMenuConfEspacios();
                break;
            case 2:
                subMenuConfPrecios();
                break;
            case 3: //opt para regresar
                break;
            default:
                System.out.println("[WARNING] UUPS! Opcion invalida.");
        }
    }

    public static void subMenuConfPrecios() {
        int opt = 0;
        System.out.println("++++++++++ (1 > 2) Configurar Precios ++++++++++");
        mostrarTiposEnumerados(1);
        System.out.println("  4. Regresar");
        opt = Utils.obtenerEntero("Ingresa una opcion", 0);
        double precio = 0.00;
        switch (opt) {
            case 1:
                System.out.println("++++++ (1 > 2 > 1) Actualizar Precio Automovil ++++++");
                precio = Utils.obtenerDouble("Ingresar el Precio por Segundo", TipoVehiculos.AUTOMOVIL.getPrecio());
                TipoVehiculos.AUTOMOVIL.setPrecio(precio);
                break;
            case 2:
                System.out.println("++++++ (1 > 2 > 2) Actualizar Precio Motocicleta ++++++");
                precio = Utils.obtenerDouble("Ingresar el Precio por Segundo", TipoVehiculos.MOTOCICLETA.getPrecio());
                TipoVehiculos.MOTOCICLETA.setPrecio(precio);
                break;
            case 3:
                System.out.println("++++++ (1 > 2 > 3) Actualizar Precio Camion ++++++");
                precio = Utils.obtenerDouble("Ingresar el Precio por Segundo", TipoVehiculos.CAMION.getPrecio());
                TipoVehiculos.CAMION.setPrecio(precio);
                break;
            case 4:
                break;
            default:
                System.out.println("[WARNING] UUPS! Opcion invalida.");

        }
    }

    public static void subMenuConfEspacios() {
        int opt = 0;
        System.out.println("++++++++++ (1 > 1) Configurar Espacios ++++++++++");
        mostrarTiposEnumerados(2);
        System.out.println("  4. Regresar");
        opt = Utils.obtenerEntero("Ingresa una opcion", 0);
        int espacios = 0;
        switch (opt) {
            case 1:
                System.out.println("++++++ (1 > 1 > 1) Actualizar Espacios Automovil ++++++");
                espacios = Utils.obtenerEntero("Ingresar el Numero de Espacios", TipoVehiculos.AUTOMOVIL.getEspacios());
                TipoVehiculos.AUTOMOVIL.setEspacios(espacios);
                break;
            case 2:
                System.out.println("++++++ (1 > 1 > 2) Actualizar Espacios Motocicleta ++++++");
                espacios = Utils.obtenerEntero("Ingresar el Numero de Espacios", TipoVehiculos.MOTOCICLETA.getEspacios());
                TipoVehiculos.MOTOCICLETA.setEspacios(espacios);
                break;
            case 3:
                System.out.println("++++++ (1 > 1 > 3) Actualizar Espacios Camion ++++++");
                espacios = Utils.obtenerEntero("Ingresar el Numero de Espacios", TipoVehiculos.CAMION.getEspacios());
                TipoVehiculos.CAMION.setEspacios(espacios);
                break;
            case 4:
                break;
            default:
                System.out.println("[WARNING] UUPS! Opcion invalida.");

        }
    }

    public static void mostrarTiposEnumerados(int precioEspacios){ // 0 vacio ,1 precios, 2 espacios
        int i = 1;
        for(TipoVehiculos tpVehiculo : TipoVehiculos.values()) {
            System.out.println("  " + i + "."
                    + (precioEspacios == 1 ? (" (" + tpVehiculo.getPrecio() + ") ") : " ")
                    + (precioEspacios == 2 ? (" (" + tpVehiculo.getEspacios() + ") ") : " ")
                    + tpVehiculo );
            i++;
        }
    }
}
