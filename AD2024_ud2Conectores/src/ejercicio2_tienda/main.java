package ejercicio2_tienda;

import java.util.Scanner;

public class main {

    public class MainMenu {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Listar todos los productos");
                System.out.println("2. Listar todos los productos por sección");
                System.out.println("3. Añadir un producto nuevo");
                System.out.println("4. Eliminar un producto");
                System.out.println("5. Crear un pedido nuevo (con transacción y actualización de stock)");
                System.out.println("6. Listar pedidos");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                option = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (option) {
                    case 1:
                        listarTodosLosProductos();
                        break;
                    case 2:
                        listarProductosPorSeccion();
                        break;
                    case 3:
                        añadirProductoNuevo();
                        break;
                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        crearPedidoNuevo();
                        break;
                    case 6:
                        listarPedidos();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción entre 0 y 6.");
                }
            } while (option != 0);

            scanner.close();
        }

        private static void listarTodosLosProductos() {
            // Aquí iría la lógica para listar todos los productos.
            System.out.println("Listando todos los productos...");
        }

        private static void listarProductosPorSeccion() {
            // Aquí iría la lógica para listar productos por sección.
            System.out.println("Listando productos por sección...");
        }

        private static void añadirProductoNuevo() {
            // Aquí iría la lógica para añadir un nuevo producto.
            System.out.println("Añadiendo un producto nuevo...");
        }

        private static void eliminarProducto() {
            // Aquí iría la lógica para eliminar un producto.
            System.out.println("Eliminando un producto...");
        }

        private static void crearPedidoNuevo() {
            // Aquí iría la lógica para crear un pedido nuevo y actualizar el stock.
            System.out.println("Creando un pedido nuevo y actualizando el stock...");
        }

        private static void listarPedidos() {
            // Aquí iría la lógica para listar todos los pedidos.
            System.out.println("Listando todos los pedidos...");
        }
    }

}
