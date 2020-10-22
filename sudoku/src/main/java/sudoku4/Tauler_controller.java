/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static sudoku4.Inici_controller.dificultad;

/**
 *
 * @author Albert Gonzalez
 */
public class Tauler_controller implements ActionListener, TableModelListener {

    public int fails = 0;
    public int selRow = 0;
    public int selCol = 0;
    public int selValue = 0;

    Sudoku sudoku;
    Solver solver = new Solver();
    tauler t1;
    int N = 9, K = 0;

    public Tauler_controller(tauler t1) {

        this.t1 = t1;
        // LiSTENER DE MOUSE DINS DE LA TAULA ( QUAN LA SELECCIO DEL USUARI CANVIA ) 

        t1.mostraSolucio.addActionListener(this);
        t1.carrega.addActionListener(this);

        t1.b1.addActionListener(this);
        t1.b2.addActionListener(this);
        t1.b3.addActionListener(this);
        t1.b4.addActionListener(this);
        t1.b5.addActionListener(this);
        t1.b6.addActionListener(this);
        t1.b7.addActionListener(this);
        t1.b8.addActionListener(this);
        t1.b9.addActionListener(this);

        // t1.addMouseListener(this);
//        t1.sudoku.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//
//                try {
//
//                    DefaultTableModel model = (DefaultTableModel) t1.sudoku.getModel();
//
//                    selRow = t1.sudoku.rowAtPoint(evt.getPoint());
//                    selCol = t1.sudoku.columnAtPoint(evt.getPoint());
//
//                    Object valueAt = model.getValueAt(selRow, selCol);
//
//                    int SelectedItem = Integer.parseInt(valueAt.toString());
//
//                    System.out.println("ROW:" + (selRow + 1) + "COL:" + (selCol + 1) + "VALUE:" + SelectedItem);
//
//                    boolean ok = solver.isOk(selRow, selCol, selectedInt);
//                    System.out.println(ok);
//
//                    // model.setval
//                    sudoku.imprimeixSudoku();
//
//                } catch (Exception e) {
//
//                    System.out.println("Error." + e);
//                }
//
//            }
//        });
        t1.sudoku.getModel().addTableModelListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

       
       t1.errors.setText(Integer.toString(fails));
        
        if (e.getActionCommand().equals("Nou")) {
            ompleTauler(t1);
            fails=0;
        }

        switch (e.getActionCommand()) {
            case "1":
                teclat(1);
                break;
            case "2":
                teclat(2);
                break;
            case "3":
                teclat(3);
                break;
            case "4":
                teclat(4);
                break;
            case "5":
                teclat(5);
                break;
            case "6":
                teclat(6);
                break;
            case "7":
                teclat(7);
                break;
            case "8":
                teclat(8);
                break;
            case "9":
                teclat(9);
                break;
            default:

        }
        
       

    }

    public void teclat(int numero) {

        //Guardamos la posicion que ha seleccionado el usuario. 
        t1.sudoku.setValueAt(numero, t1.sudoku.getSelectedRow(), t1.sudoku.getSelectedColumn());
        selValue = numero;

        //boolean ok = solver.isOk(selRow, selCol, selValue);
        boolean inRow = solver.isInRow(t1.sudoku.getSelectedRow(), numero);
        boolean inCol = solver.isInCol(t1.sudoku.getSelectedColumn(), numero);
        boolean inBox = solver.isInBox(t1.sudoku.getSelectedRow(), t1.sudoku.getSelectedColumn(), numero);

        System.out.println("Is in row?" + solver.isInRow(t1.sudoku.getSelectedRow(), numero));
        System.out.println("Is in col?" + solver.isInCol(t1.sudoku.getSelectedColumn(), numero));
        System.out.println("Is in box?" + solver.isInBox(t1.sudoku.getSelectedRow(), t1.sudoku.getSelectedColumn(), numero));

        //FUNCIONA 
        if (inRow==false && inCol==false && inBox == false) {

            System.out.println("Numero valido");
            //Afegim el numero a la matriu

        } else {

            System.out.println("Numero no  valido");
            fails++;
        }

        editaMatriu(t1.sudoku.getSelectedRow(), t1.sudoku.getSelectedColumn(), numero);

        //TIENES QUE PONER EL TIPO DE DATO QUE HAY EN LA TABLA
        t1.sudoku.getColumnClass(selRow);
        YourTableCellRenderer yourTableCellRenderer = new YourTableCellRenderer();
        
        t1.sudoku.setDefaultRenderer(Object.class,yourTableCellRenderer);

         if (fails>3) {
            
            JOptionPane.showMessageDialog(null, "Has superat els 3 errors.");

        }
        
//        selRow=t1.sudoku.getSelectedRow();
//        selCol=t1.sudoku.getSelectedRow();
        //Comprovem la validesa del numero a la matriu
        // System.out.println(ok);
//        System.out.println(t1.sudoku.getSelectedRow());
//        System.out.println(t1.sudoku.getSelectedColumn());
//        System.out.println("Numero:"+numero);
    }

//    public void comprovacions() {
//
//        //boolean validaNumero = sudoku.validaNumero(selRow, selCol, selValue);
//        if (sudoku.comprovaFila(selRow, selValue) == false) {
//
//            System.out.println("Num Fila  repetit");
//        } else {
//            System.out.println("Num fila no repetit");
//        }
//
//        if (sudoku.comprovaColumna(selCol, selValue) == false) {
//
//            System.out.println("Num columna repetit");
//        } else {
//            System.out.println("Num columna no repetit");
//        }
//
//        //i-i%SRN, j-j%SRN, num
//        if (sudoku.comprovaNumerosQuadrant(selRow - selRow % 3, selCol - selCol % 3, selValue) == false) {
//
//            System.out.println("Num quadrant repetit");
//        } else {
//            System.out.println("Num quadrant no repetit");
//        }
//
//    }
    public void ompleTauler(tauler t1) {

        K = configuraDificultat(K);

        // CREACIO ARRAYS 
        sudoku = new Sudoku(9, K);

        sudoku.ompleValors();

        solver.matriu = sudoku.mat;

        // PASSEM L'ARRAY A LA GRID
        ompleJtable(t1);

    }

    // OMPLIM JTABLE
    public void ompleJtable(tauler t) {

        DefaultTableModel model = (DefaultTableModel) t.sudoku.getModel();

        for (int row = 0; row < t.sudoku.getRowCount(); row++) {
            for (int col = 0; col < t.sudoku.getColumnCount(); col++) {

                model.setValueAt(sudoku.mat[row][col], row, col);

                // Buidem casella si hi ha un zero
                if (model.getValueAt(row, col).equals(0)) {

                    model.setValueAt(null, row, col);

                }
            }
        }

        setCellsAlignment(t.sudoku, SwingConstants.CENTER);
        //darColor(t.sudoku); 
    }

    // CENTREM CONTINGUT DE LES CASELLES 
    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }

    public static int configuraDificultat(int K) {

        // DIFICIL 30 K=51  MITJA 35 K=46 FACIL 40=41
        switch (dificultad) {
            case "facil":
                K = 41;
                break;
            case "intermedio":
                K = 46;
                break;
            case "dificil":
                K = 51;
                break;
            default:

        }

        //System.out.println();
        return K;

    }

    public void editaMatriu(int row, int column, int valor) {

        try {

            if (valor > 0 && valor < 10) {

                sudoku.mat[row][column] = valor;
                System.out.println("Matriu Editada");

            }
        } catch (Exception e) {

            System.out.println("FALLO EN LA MATRIZ DE INTS");
        }

    }

    @Override
    public void tableChanged(TableModelEvent e) {

    }

    public class YourTableCellRenderer extends DefaultTableCellRenderer {

        private int SPECIAL_COLUMN = 5;
        private int SPECIAL_ROW = 5;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value,isSelected, hasFocus,row, column);
            this.setOpaque(true);
            Object result = table.getModel().getValueAt(row, column);

            System.out.println("RENDERER");

            // si troba les ROWS i cloumnes cambia de color la casella 
            System.out.println("RENDERER IF");
            //c.setFont();
            // you may want to address isSelected here too

            c.setForeground(Color.RED);
            c.setBackground(Color.RED);

            return c;
        }
    }

}
