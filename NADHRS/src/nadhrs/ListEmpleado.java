package nadhrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NADHRS
 */
public class ListEmpleado {

    ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
    Scanner input = new Scanner(System.in);

    private int numCon;
    private int edad;
    private String nom;
    private String area;
    private String planta;
    private String turno;

    private int cuantosRegistrar;

    public void resgistrar() {

        listaEmpleado.add(new Empleado(5959, 85, "Rogelio", "Producción", "Complejo", "Fin de Semana"));
        listaEmpleado.add(new Empleado(4556, 65, "Carlos", "Producción", "Complejo", "Fin de Semana"));
        listaEmpleado.add(new Empleado(522522, 45, "Alberto", "Producción", "Complejo", "Fin de Semana"));
        listaEmpleado.add(new Empleado(8855, 35, "Zaire", "Producción", "Complejo", "Fin de Semana"));
        listaEmpleado.add(new Empleado(995925, 20, "Marcela", "Producción", "Complejo", "Fin de Semana"));
        listaEmpleado.add(new Empleado(588, 19, "Karen", "Producción", "Complejo", "Fin de Semana"));

        /*System.out.println("¿Cuantos empleados quieres registrar?");
        cuantosRegistrar = input.nextInt();

        for (int i = 0; i < cuantosRegistrar; i++) {
            
            System.out.print("Numero de empleado: ");
            
             for (int x = 0; x < 100;  x++) {
           numCon = ((int) (Math.random() * 100));
        }
           
            System.out.print("Edad: ");
              for (int x = 0; x < 100;  x++) {
           edad = ((int) (Math.random() * 100));
        }

            System.out.print("Nombre: ");
              for (int x = 0; x < 100;  x++) {
         nom = ("Anthony");
        }
            
            System.out.print("Area: ");
              for (int x = 0; x < 100;  x++) {
         area = ("Davis");
        }
              
              System.out.print("Planta: ");
            for (int x = 0; x < 100;  x++) {
        planta = ("L.A.");
            }

            System.out.print("Turno: ");
            for (int x = 0; x < 100;  x++) {
           turno = ("Nocturno");
            }

            System.out.println("------------");
            listaEmpleado.add(new Empleado(numCon, edad, nom, area, planta, turno));
        }
         */
    }

    public void imprimir() {

        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (i == 0) {
                System.out.println("---------------");
                System.out.println("Numero de control: " + listaEmpleado.get(i).getNumControl());
                System.out.println("Nombre: " + listaEmpleado.get(i).getNombre());
                System.out.println("Edad: " + listaEmpleado.get(i).getEdad());
                System.out.println("Area: " + listaEmpleado.get(i).getArea());
                System.out.println("Planta: " + listaEmpleado.get(i).getPlanta());
                System.out.println("Turno: " + listaEmpleado.get(i).getTurno());
                System.out.println("---------------");
            } else {
                System.out.println("Numero de control: " + listaEmpleado.get(i).getNumControl());
                System.out.println("Nombre: " + listaEmpleado.get(i).getNombre());
                System.out.println("Edad: " + listaEmpleado.get(i).getEdad());
                System.out.println("Area: " + listaEmpleado.get(i).getArea());
                System.out.println("Planta: " + listaEmpleado.get(i).getPlanta());
                System.out.println("Turno: " + listaEmpleado.get(i).getTurno());
                System.out.println("---------------");
            }
        }
    }

    public void ordenarPorNombre() {
        Collections.sort(listaEmpleado, new OrdenarEmpleadosLetra());
    }

    public void ordenarPorEdad() {
        Collections.sort(listaEmpleado, new OrdenarEmpleadosEdad());
    }

    public void buscarEmpleado() {
        Collections.sort(listaEmpleado, new OrdenarEmpleadosLetra());
        System.out.println("Ingrese el nombre completo del empleado que quiere buscar: ");
        String nom;
        nom = input.nextLine();
        OrdenarEmpleadosLetra ordenar = new OrdenarEmpleadosLetra();
        Empleado busqueda = new Empleado(0, 0, nom, null, null, null);
        int ind = Collections.binarySearch(listaEmpleado, busqueda, ordenar);
        if (ind < 0) {
            System.out.println("Ese empleado no existe");
        } else {
            System.out.println(listaEmpleado.get(ind));
        }
    }

    public void eliminarEmpleado() {
Collections.sort(listaEmpleado, new OrdenarEmpleadosLetra());
        System.out.println("Ingrese el nombre completo del empleado que quiere eliminar: ");
        String nom;
        nom = input.nextLine();
        OrdenarEmpleadosLetra ordenar = new OrdenarEmpleadosLetra();
        Empleado busqueda = new Empleado(0, 0, nom, null, null, null);
        int ind = Collections.binarySearch(listaEmpleado, busqueda, ordenar);
        if (ind < 0) {
            System.out.println("Ese empleado no existe");
        } else {
            //Empieza menú
            int opt;
            do {
                System.out.println("¿Seguro que quieres eliminarlo?");
                System.out.println(listaEmpleado.get(ind));
                System.out.println(
                        "1 - Si \n"
                        + "2 - No "
                );
                opt = input.nextInt();

                switch (opt) {
                    case 1:
                        listaEmpleado.remove(ind);
                        System.out.println("Ha sido eliminado");
                        opt = 2;
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");
                }
            } while (opt != 2);
        }
    }
}
