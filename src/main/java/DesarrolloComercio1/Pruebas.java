package DesarrolloComercio1;

public class Pruebas {
    public Pruebas() {
    }

    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        GestorClientes gestorClientes = new GestorClientes();
        GestorComprobante gestorComprobante = new GestorComprobante();
        gestorProducto.create("Zapatilla", 80000, 10);
        gestorProducto.create("Pantalón", 20000, 50);
        gestorProducto.create("Camisas", 18000, 50);
        gestorProducto.create("Celular", 1100000, 22);
        gestorProducto.create("Audifonos", 12000, 39);
        gestorClientes.create("Jose", "Erices", 169800952, 35);
        gestorClientes.create("Carolina", "Navarro", 180177401, 32);
        gestorClientes.create("Manuel", "Sanchez", 180177408, 28);
        gestorClientes.create("Gladys", "Navarro", 145177470, 33);
        gestorClientes.create("Fabiola", "Erices", 185177465, 42);
        gestorClientes.create("Catalina", "Erices", 160179911, 18);
        gestorClientes.create("Bruno", "Erices", 119416890, 19);
        Cliente cliente = (Cliente)gestorClientes.readAll().get(4);
        gestorComprobante.createComprobante(cliente);
    }
}
