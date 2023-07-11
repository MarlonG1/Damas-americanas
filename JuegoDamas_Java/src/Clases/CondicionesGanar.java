package Clases;

import javax.swing.JOptionPane;

public class CondicionesGanar {

    public static void condiciones(int cantFichasB, int cantFichasN) {
        if (cantFichasB == 0) {
            Movimiento.juegoTerminado = true;
            JOptionPane.showMessageDialog(null, "Felicidades Jugador 1, eres el ganador!!!");
        }

        if (cantFichasN == 0) {
            Movimiento.juegoTerminado = true;
            JOptionPane.showMessageDialog(null, "Felicidades Jugador 2, eres el ganador!!!");
        }
    }

}
