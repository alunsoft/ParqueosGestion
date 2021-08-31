public enum TipoVehiculos {
    AUTOMOVIL(0,0.0),
    MOTOCICLETA(0,0.0),
    CAMION(0,0.0);

    private int espacios;
    private double precio;

    private TipoVehiculos(int espacios, double precio) {
        this.espacios = espacios;
        this.precio = precio;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
