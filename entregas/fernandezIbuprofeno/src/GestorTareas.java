import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] tareasCompletadas = new boolean[10];
        int numeroDeTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        while (true) {
            System.out.println("[1] Anadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                if (numeroDeTareas < 10) {
                    System.out.print("Descripcion de la nueva tarea: ");
                    String descripcionDeTarea = scanner.nextLine();
                    tareas[numeroDeTareas] = descripcionDeTarea;
                    tareasCompletadas[numeroDeTareas] = false;
                    numeroDeTareas++;
                    System.out.println("Tarea anadida correctamente.");
                } else {
                    System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
                }
            } else if (opcion == 2) {
                System.out.println("Tareas para Marcar");
                for (int tarea = 0; tarea < numeroDeTareas; tarea++) {
                    System.out.println((tarea + 1) + ". " + tareas[tarea] + " [" + (tareasCompletadas[tarea] ? "Completada" : "Pendiente") + "]");
                }
                if (numeroDeTareas > 0) {
                    System.out.print("Numero de tarea a marcar como completada: ");
                    int tareaCompletada = scanner.nextInt();
                    if (tareaCompletada >= 1 && tareaCompletada <= numeroDeTareas) {
                        if (!tareasCompletadas[tareaCompletada - 1]) {
                            tareasCompletadas[tareaCompletada - 1] = true;
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Esta tarea ya estaba completada.");
                        }
                    } else {
                        System.out.println("Numero de tarea invalido.");
                    }
                } else {
                    System.out.println("No hay tareas para marcar.");
                }
            } else if (opcion == 3) {
                System.out.println("Tareas Pendientes");
                boolean hayPendientes = false;
                for (int i = 0; i < numeroDeTareas; i++) {
                    if (!tareasCompletadas[i]) {
                        System.out.println((i + 1) + ". " + tareas[i]);
                        hayPendientes = true;
                    }
                }
                if (!hayPendientes) {
                    System.out.println("(No hay tareas pendientes)");
                }
            } else if (opcion == 4) {
                System.out.println("Estadisticas");
                int numeroTareasCompletadas = 0;
                for (int i = 0; i < numeroDeTareas; i++) {
                    if (tareasCompletadas[i]) {
                        numeroTareasCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + numeroDeTareas);
                System.out.println("Tareas completadas: " + numeroTareasCompletadas);
                System.out.println("Tareas pendientes: " + (numeroDeTareas - numeroTareasCompletadas));
                if (numeroDeTareas > 0) {
                    double porcentajeTareasCompletadas = (numeroTareasCompletadas * 100.0) / numeroDeTareas;
                    System.out.println("Porcentaje de completacion: " + porcentajeTareasCompletadas + "%");
                }
            } else if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                break;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
