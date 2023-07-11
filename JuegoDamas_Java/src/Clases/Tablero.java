package Clases;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero {

    /*
    La eneracion de ficha sigue estos valores:
    0 -> base amarilla
    1 -> base marron (posicion de vacio)
    2 -> Jugador 2
    3 -> Jugador 1
    4 -> Reinas de jugador 1
    5 -> Reinas de jugador 2
     */
    
    protected static boolean movimientoObligatorio;
    protected static int[][] tableroLogico;
    protected static int filaAnterior, columnaAnterior;
    private int fila, columna;

    protected JLabel[][] tableroFisico;
    private JPanel form;
    private Movimiento movimiento;
    private ImageIcon imgBase0 = new ImageIcon("src/Imagenes/base0.png");
    private ImageIcon imgBase1 = new ImageIcon("src/Imagenes/base1.png");
    private ImageIcon imgJ1 = new ImageIcon("src/Imagenes/fichaJ1.png");
    private ImageIcon imgJ2 = new ImageIcon("src/Imagenes/fichaJ2.png");
    private ImageIcon imgRJ1 = new ImageIcon("src/Imagenes/reinaFB.png");
    private ImageIcon imgRJ2 = new ImageIcon("src/Imagenes/reinaFN.png");
    private ImageIcon moverObligatorio = new ImageIcon("src/Imagenes/posicionAMover.png");

    public Tablero(JPanel form, JLabel lbCantidadB, JLabel lbCantidadN, JLabel lbTurno, JLabel lbImgFicha) {
        this.form = form;
        this.fila = 8;
        this.columna = 9;

        movimiento = new Movimiento(lbCantidadB, lbCantidadN, lbTurno, lbImgFicha);
        tableroLogico = new int[fila][columna];
        this.tableroFisico = new JLabel[fila][columna];

        for (int f = 0; f < this.fila; f++) {
            for (int c = 0; c < this.columna; c++) {
                tableroLogico[f][c] = 0;
                this.tableroFisico[f][c] = new JLabel();
            }
        }
        generarFichas();
        refrescarTablero();
    }

    public void reiniciar() {
        movimiento.reiniciar();

        for (int i = 0; i < this.fila; i++) {
            for (int j = 0; j < this.columna; j++) {
                this.form.remove(this.tableroFisico[i][j]);
                this.tableroFisico[i][j] = new JLabel();
            }
        }

        generarFichas();
        pintarTablero();
        this.form.repaint();
    }

    private void generarFichas() {

        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 9; c++) {
                if (f % 2 == 0) {
                    if (c % 2 == 0) {
                        if (f < 3) {
                            tableroLogico[f][c] = 2;
                        } else if (f > 4) {
                            tableroLogico[f][c] = 3;
                        } else {
                            tableroLogico[f][c] = 1;
                        }
                    }
                } else {
                    if (c % 2 != 0) {
                        if (f < 3) {
                            tableroLogico[f][c] = 2;
                        } else if (f > 4) {
                            tableroLogico[f][c] = 3;
                        } else {
                            tableroLogico[f][c] = 1;
                        }
                    }
                }
            }
        }

    }

    private void refrescarTablero() {
        for (int f = 0; f < this.fila; f++) {
            for (int c = 0; c < this.columna - 1; c++) {
                switch (tableroLogico[f][c]) {
                    case 0 ->
                        this.tableroFisico[f][c].setIcon(imgBase1);
                    case 1 ->
                        this.tableroFisico[f][c].setIcon(imgBase0);
                    case 2 ->
                        this.tableroFisico[f][c].setIcon(imgJ2);
                    case 3 ->
                        this.tableroFisico[f][c].setIcon(imgJ1);
                    case 4 ->
                        this.tableroFisico[f][c].setIcon(imgRJ1);
                    case 5 ->
                        this.tableroFisico[f][c].setIcon(imgRJ2);
                }
            }
        }

        if (movimientoObligatorio == true) {
            this.tableroFisico[movimiento.getFilaTip()][movimiento.getColumnaTip()].setIcon(moverObligatorio);
        }

    }

    public void pintarTablero() {
        int PosX = 0, PosY = 0;

        for (int f = 0; f < this.fila; f++) {
            PosY = f * 65;
            for (int c = 0; c < this.columna - 1; c++) {
                PosX = c * 65;
                this.tableroFisico[f][c].setSize(65, 65);
                this.tableroFisico[f][c].setLocation(PosX, PosY);
                this.tableroFisico[f][c].setName(f + "-" + c);

                switch (Tablero.tableroLogico[f][c]) {
                    case 0 ->
                        this.tableroFisico[f][c].setIcon(imgBase1);
                    case 1 ->
                        this.tableroFisico[f][c].setIcon(imgBase0);
                    case 2 ->
                        this.tableroFisico[f][c].setIcon(imgJ2);
                    case 3 ->
                        this.tableroFisico[f][c].setIcon(imgJ1);
                }

                this.tableroFisico[f][c].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String[] posiciones = e.getComponent().getName().split("-");
                        int filaDestino, columnaDestino;

                        switch (e.getButton()) {
                            case MouseEvent.BUTTON3 -> {
                                movimientoObligatorio = false;
                                filaAnterior = Integer.parseInt(posiciones[0]);
                                columnaAnterior = Integer.parseInt(posiciones[1]);
                            }
                            case MouseEvent.BUTTON1 -> {
                                if (Integer.parseInt(posiciones[0]) != filaAnterior || Integer.parseInt(posiciones[1]) != columnaAnterior) {
                                    filaDestino = Integer.parseInt(posiciones[0]);
                                    columnaDestino = Integer.parseInt(posiciones[1]);

                                    movimiento.moverFicha(filaAnterior, columnaAnterior, filaDestino, columnaDestino);
                                }
                                refrescarTablero();
                                form.repaint();
                            }
                            default -> {

                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });

                this.tableroFisico[f][c].setOpaque(true);
                this.form.add(this.tableroFisico[f][c]);
            }
        }
    }
}
