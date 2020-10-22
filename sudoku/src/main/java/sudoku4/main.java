/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku4;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static sudoku4.Inici_controller.dificultad;

/**
 *
 * @author Albert Workstation
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // ON N ES IGUAL AL NOMBRE DE COLUMNES 
        // K IGUAL AL NOMBRE DE BUITS QUE VOLEM
        // DIFICIL 30 K=51  MITJA 35 K=46 FACIL 40=41
        
        
        finestra_inici fi;
        tauler t;
        Tauler_controller tc;
        Inici_controller ic;

        fi = new finestra_inici();
        t = new tauler();

        tc = new Tauler_controller(t);
        ic = new Inici_controller(fi, tc);
           
        fi.setVisible(true);
        fi.setLocationRelativeTo(null);
        
       
         
        
       

    }

    



}
