import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {

        String[] tareas = new String[10];
        boolean[] tareasCompletadas = new boolean[10];
        int[] numeroDeTareas = { 0 };

        boolean enFuncionamiento = true;

        do {
            switch (pedirOpcion()) {
                case 1 -> agregarTarea(tareas, tareasCompletadas, numeroDeTareas);
                case 2 -> completarTarea(tareas, tareasCompletadas, numeroDeTareas);
                case 3 -> verPendientes(tareas, tareasCompletadas, numeroDeTareas);
                case 4 -> verEstadisticas(tareasCompletadas, numeroDeTareas);
                case 5 -> enFuncionamiento = false;
                default -> System.out.println("Opción inválida");
            }
        } while (enFuncionamiento);
    }

    static void verEstadisticas(boolean[] tareasCompletadas, int[] numeroDeTareas) {
        System.out.println("Estadisticas");
        int numeroTareasCompletadas = 0;
        for (int i = 0; i < numeroDeTareas[0]; i++) {
            if (tareasCompletadas[i]) {
                numeroTareasCompletadas++;
            }
        }
        System.out.println("Total de tareas: " + numeroDeTareas[0]);
        System.out.println("Tareas completadas: " + numeroTareasCompletadas);
        System.out.println("Tareas pendientes: " + (numeroDeTareas[0] - numeroTareasCompletadas));
        if (numeroDeTareas[0] > 0) {
            double porcentajeTareasCompletadas = (numeroTareasCompletadas * 100.0) / numeroDeTareas[0];
            System.out.println("Porcentaje de completacion: " + porcentajeTareasCompletadas + "%");
        }
    }

    static void verPendientes(String[] tareas, boolean[] tareasCompletadas, int[] numeroDeTareas) {
        System.out.println("Tareas Pendientes");
        boolean hayPendientes = false;
        for (int i = 0; i < numeroDeTareas[0]; i++) {
            if (!tareasCompletadas[i]) {
                System.out.println((i + 1) + ". " + tareas[i]);
                hayPendientes = true;
            }
        }
        if (!hayPendientes) {
            System.out.println("(No hay tareas pendientes)");
        }
    }

    static void completarTarea(String[] tareas, boolean[] tareasCompletadas, int[] numeroDeTareas) {
        System.out.println("Tareas para Marcar");
        for (int tarea = 0; tarea < numeroDeTareas[0]; tarea++) {
            System.out.println((tarea + 1) + ". " + tareas[tarea] + " ["
                    + (tareasCompletadas[tarea] ? "Completada" : "Pendiente") + "]");
        }
        if (numeroDeTareas[0] > 0) {
            System.out.print("Numero de tarea a marcar como completada: ");
            int tareaCompletada = new Scanner(System.in).nextInt();
            if (tareaCompletada >= 1 && tareaCompletada <= numeroDeTareas[0]) {
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
    }

    static void agregarTarea(String[] tareas, boolean[] tareasCompletadas, int[] numeroDeTareas) {
        if (numeroDeTareas[0] < 10) {
            System.out.print("Descripcion de la nueva tarea: ");
            String descripcionDeTarea = new Scanner(System.in).nextLine();
            tareas[numeroDeTareas[0]] = descripcionDeTarea;
            tareasCompletadas[numeroDeTareas[0]] = false;
            numeroDeTareas[0]++;
            System.out.println("Tarea anadida correctamente.");
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
        }
    }

    static int pedirOpcion() {
        Scanner scanner = new Scanner(System.in);
        mostrarMenu();
        int opcion = scanner.nextInt();
        return opcion;
    }

    static void mostrarMenu() {
        System.out.println("Gestor de Tareas v1.0");
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
    }

}
