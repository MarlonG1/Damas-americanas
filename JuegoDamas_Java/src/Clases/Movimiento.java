package Clases;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Movimiento {

    //Variables
    private int turno = 1, fichasBlancas = 12, fichasNegras = 12, filaTip, columnaTip;
    private boolean capturaNormal, noCambiarTurno;
    protected static boolean juegoTerminado;

    //Objetos
    private JLabel lbCantidadB, lbCantidadN, lbTurno, lbImgFicha;
    private ImageIcon fichaInfoJ1 = new ImageIcon("src/Imagenes/fichaJ1Info.png");
    private ImageIcon fichaInfoJ2 = new ImageIcon("src/Imagenes/fichaJ2Info.png");

    public Movimiento(JLabel lbCantidadB, JLabel lbCantidadN, JLabel lbTurno, JLabel lbImgFicha) {
        this.lbCantidadB = lbCantidadB;
        this.lbCantidadN = lbCantidadN;
        this.lbTurno = lbTurno;
        this.lbImgFicha = lbImgFicha;
    }

    public void reiniciar() {
        this.fichasBlancas = 12;
        this.fichasNegras = 12;
        this.turno = 1;
        juegoTerminado = false;

        this.lbTurno.setText("Uno");
        this.lbImgFicha.setIcon(fichaInfoJ1);
        this.lbCantidadB.setText("x" + this.fichasBlancas);
        this.lbCantidadN.setText("x" + this.fichasNegras);
    }

    //Accion de mover la ficha
    public void moverFicha(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino) {

        if (!juegoTerminado) {

            int fichaActual = Tablero.tableroLogico[filaAnterior][columnaAnterior];

            if (!esTurnoValido(fichaActual)) {
                JOptionPane.showMessageDialog(null, "No es tu turno");
                return;
            }

            if (!esMovimientoValido(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual)) {
                JOptionPane.showMessageDialog(null, "Movimiento inválido");
                return;
            }

            if (!hayCapturasDisponibles(filaAnterior, columnaAnterior, filaDestino, columnaDestino)) {

                if (esMovimientoNormal(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual)) {
                    moverFichaNormal(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual);
                } else if (esMovimientoCaptura(filaAnterior, columnaAnterior, filaDestino, columnaDestino)) {
                    int filaIntermedia = (filaAnterior + filaDestino) / 2;
                    int columnaIntermedia = (columnaAnterior + columnaDestino) / 2;

                    if (!esFichaOponente(filaIntermedia, columnaIntermedia, fichaActual)) {
                        JOptionPane.showMessageDialog(null, "Movimiento inválido");
                        return;
                    }

                    capturarFicha(filaAnterior, columnaAnterior, filaDestino, columnaDestino, filaIntermedia, columnaIntermedia, fichaActual);

                    if (hayCapturasDisponibles(filaDestino, columnaDestino, filaDestino, columnaDestino)) {
                        noCambiarTurno = true;
                    }

                } else if (esReina(fichaActual)) {
                    moverFichaReina(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual);
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento inválido");
                    return;
                }

                Reproductor.reproducirSonido("movimientoFicha");
                promocionAReina(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual);

                if (!noCambiarTurno) {
                    cambiarTurno();
                }
                CondicionesGanar.condiciones(fichasBlancas, fichasNegras);
            } else {
                JOptionPane.showMessageDialog(null, "Tienes movimiento obligatorio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El juego ya ha concluido, si deseas volver a jugar presiona el boton de |Reiniar|");
        }
    }

    public boolean hayCapturasDisponibles(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino) {
        capturaNormal = false;

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                int fichaActual = Tablero.tableroLogico[fila][columna];

                if (esTurnoValido(fichaActual) && puedeCapturar(fila, columna, filaDestino, columnaDestino)) {
                    return true;
                }

                if (capturaNormal == true) {
                    break;
                }

            }
        }

        return false;
    }

    public boolean puedeCapturar(int fila, int columna, int filaDestino, int columnaDestino) {
        int fichaActual = Tablero.tableroLogico[fila][columna];
        int[][] posicionesCaptura;

        posicionesCaptura = switch (fichaActual) {
            case 2 ->
                new int[][]{{1, -1}, {1, 1}};
            case 3 ->
                new int[][]{{-1, -1}, {-1, 1}};
            default ->
                new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        };
        for (int[] posicion : posicionesCaptura) {
            int filaIntermedia = fila + posicion[0];
            int columnaIntermedia = columna + posicion[1];
            int supuestoFilaDestino = fila + 2 * posicion[0];
            int supuestoColumnaDestino = columna + 2 * posicion[1];

            if (filaIntermedia >= 0 && filaIntermedia < 8 && columnaIntermedia >= 0 && columnaIntermedia < 8
                    && supuestoFilaDestino >= 0 && supuestoFilaDestino < 8 && supuestoColumnaDestino >= 0 && supuestoColumnaDestino < 8) {

                if (esFichaOponente(filaIntermedia, columnaIntermedia, fichaActual)
                        && Tablero.tableroLogico[supuestoFilaDestino][supuestoColumnaDestino] == 1) {

                    if (supuestoFilaDestino == filaDestino && supuestoColumnaDestino == columnaDestino) {
                        capturaNormal = true; // La posicion de destino original cumple para poder comer
                        this.noCambiarTurno = false;
                        return false;
                    }

                    this.filaTip = supuestoFilaDestino;
                    this.columnaTip = supuestoColumnaDestino;
                    Tablero.movimientoObligatorio = true;
                    this.noCambiarTurno = false;

                    return true; // Se encontró al menos una captura válida
                }
            }
        }

        return false; // No se encontró ninguna captura válida
    }

    //Movimiento de captura
    private boolean esMovimientoCaptura(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino) {
        int diferenciaFila = filaDestino - filaAnterior;
        int diferenciaColumna = columnaDestino - columnaAnterior;

        return Math.abs(diferenciaFila) == 2 && Math.abs(diferenciaColumna) == 2;
    }

    private void capturarFicha(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int filaIntermedia, int columnaIntermedia, int fichaActual) {

        if (Tablero.tableroLogico[filaIntermedia][columnaIntermedia] == 3) {
            this.fichasBlancas--;
            this.lbCantidadB.setText("x" + this.fichasBlancas);
        } else {
            this.fichasNegras--;
            this.lbCantidadN.setText("x" + this.fichasNegras);
        }

        Tablero.tableroLogico[filaDestino][columnaDestino] = fichaActual;
        Tablero.tableroLogico[filaAnterior][columnaAnterior] = 1;
        Tablero.tableroLogico[filaIntermedia][columnaIntermedia] = 1;
    }

    //Validacion de movimientos y fichas normales
    private boolean esMovimientoValido(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        int diferenciaFila = filaDestino - filaAnterior;
        int diferenciaColumna = columnaDestino - columnaAnterior;

        if (esMovimientoNormal(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual)) {
            return Tablero.tableroLogico[filaDestino][columnaDestino] == 1;
        } else if (Math.abs(diferenciaFila) == 2 && Math.abs(diferenciaColumna) == 2) {
            // Movimiento de captura
            int filaIntermedia = (filaAnterior + filaDestino) / 2;
            int columnaIntermedia = (columnaAnterior + columnaDestino) / 2;
            return Tablero.tableroLogico[filaDestino][columnaDestino] == 1
                    && esFichaOponente(filaIntermedia, columnaIntermedia, fichaActual);
        } else if (esMovimientoReina(filaAnterior, columnaAnterior, filaDestino, columnaDestino, fichaActual)) {
            return esMovimientoReinaValido(filaAnterior, columnaAnterior, filaDestino, columnaDestino)
                    && esTurnoValido(fichaActual);
        } else {
            return false;
        }
    }

    private void moverFichaNormal(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        Tablero.tableroLogico[filaDestino][columnaDestino] = fichaActual;
        Tablero.tableroLogico[filaAnterior][columnaAnterior] = 1;
    }

    private boolean esMovimientoNormal(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        int diferenciaFila = filaDestino - filaAnterior;
        int diferenciaColumna = columnaDestino - columnaAnterior;

        return switch (fichaActual) {
            case 3 ->
                diferenciaFila == -1 && Math.abs(diferenciaColumna) == 1;
            case 2 ->
                diferenciaFila == 1 && Math.abs(diferenciaColumna) == 1;
            default ->
                false;
        };
        // 3 Ficha normal del Jugador 1, se mueve en diagonal superior
        // 2 Ficha normal del Jugador 2, se mueve en diagonal inferior
        // La ficha actual no es una ficha normal
    }

    //Acciones relacionadas a los turnos
    private void cambiarTurno() {
        this.turno = (this.turno == 1) ? 2 : 1;

        if (this.turno == 1) {
            this.lbTurno.setText("Uno");
            this.lbImgFicha.setIcon(fichaInfoJ1);
        } else {
            this.lbTurno.setText("Dos");
            this.lbImgFicha.setIcon(fichaInfoJ2);
        }
    }

    private boolean esTurnoValido(int fichaActual) {
        return (this.turno == 1 && fichaActual == 3)
                || (this.turno == 1 && fichaActual == 4)
                || (this.turno == 2 && fichaActual == 2)
                || (this.turno == 2 && fichaActual == 5);
    }

    private boolean esFichaOponente(int fila, int columna, int fichaActual) {
        int fichaEnemiga;
        int fichaReinaEnemiga;

        if (fichaActual == 2 || fichaActual == 5) {
            fichaEnemiga = 3;
            fichaReinaEnemiga = 4;
        } else {
            fichaEnemiga = 2;
            fichaReinaEnemiga = 5;
        }

        return Tablero.tableroLogico[fila][columna] == fichaEnemiga || Tablero.tableroLogico[fila][columna] == fichaReinaEnemiga;
    }

    //Movimiento y validacion de ficha reina
    public void promocionAReina(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        if (fichaActual == 3 && filaDestino == 0) {
            // Promover a reina del Jugador 1
            Tablero.tableroLogico[filaDestino][columnaDestino] = 4;
            Reproductor.reproducirSonido("promocionDeReina");
        } else if (fichaActual == 2 && filaDestino == 7) {
            // Promover a reina del Jugador 2
            Tablero.tableroLogico[filaDestino][columnaDestino] = 5;
            Reproductor.reproducirSonido("promocionDeReina");
        }
    }

    private void moverFichaReina(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        Tablero.tableroLogico[filaDestino][columnaDestino] = fichaActual;
        Tablero.tableroLogico[filaAnterior][columnaAnterior] = 1;
    }

    private boolean esMovimientoReinaValido(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino) {
        int diferenciaFila = filaDestino - filaAnterior;
        int diferenciaColumna = columnaDestino - columnaAnterior;
        int direccionFila = diferenciaFila / Math.abs(diferenciaFila);
        int direccionColumna = diferenciaColumna / Math.abs(diferenciaColumna);
        int filaActual = filaAnterior + direccionFila;
        int columnaActual = columnaAnterior + direccionColumna;

        while (filaActual != filaDestino && columnaActual != columnaDestino) {
            if (Tablero.tableroLogico[filaActual][columnaActual] != 1) {
                return false;
            }

            filaActual += direccionFila;
            columnaActual += direccionColumna;
        }

        return true;
    }

    private boolean esMovimientoReina(int filaAnterior, int columnaAnterior, int filaDestino, int columnaDestino, int fichaActual) {
        // Verificar si la ficha es una reina
        return (fichaActual == 4 || fichaActual == 5) && Math.abs(filaDestino - filaAnterior) == Math.abs(columnaDestino - columnaAnterior);
    }

    private boolean esReina(int fichaActual) {
        return fichaActual == 4 || fichaActual == 5;
    }

    //Setters
    public void setFichasBlancas(int fichasBlancas) {
        this.fichasBlancas = fichasBlancas;
    }

    public void setFichasNegras(int fichasNegras) {
        this.fichasNegras = fichasNegras;
    }

    public int getFilaTip() {
        return filaTip;
    }

    public int getColumnaTip() {
        return columnaTip;
    }
}
