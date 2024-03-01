package utils;

import javax.swing.text.html.HTMLEditorKit;

public class Utils {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Colores de texto
    public static final String BLACK = "\033[0;30m";   // Negro
    public static final String RED = "\033[0;31m";     // Rojo
    public static final String GREEN = "\033[0;32m";   // Verde
    public static final String YELLOW = "\033[0;33m";  // Amarillo
    public static final String BLUE = "\033[0;34m";    // Azul
    public static final String PURPLE = "\033[0;35m";  // Morado
    public static final String CYAN = "\033[0;36m";    // Cyan
    public static final String WHITE = "\033[0;37m";   // Blanco

    // Estilos de texto
    public static final String BOLD = "\033[1m";       // Texto en negrita
    public static final String UNDERLINE = "\033[4m";  // Texto subrayado
    public static final String REVERSED = "\033[7m";   // Colores invertidos

    // Colores de fondo
    public static final String BG_BLACK = "\033[40m";   // Negro
    public static final String BG_RED = "\033[41m";     // Rojo
    public static final String BG_GREEN = "\033[42m";   // Verde
    public static final String BG_YELLOW = "\033[43m";  // Amarillo
    public static final String BG_BLUE = "\033[44m";    // Azul
    public static final String BG_PURPLE = "\033[45m";  // Morado
    public static final String BG_CYAN = "\033[46m";    // Cyan
    public static final String BG_WHITE = "\033[47m";   // Blanco

    public static void sleepThread(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println(Utils.RED + "Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(Utils.RESET);
        }
    }
}
