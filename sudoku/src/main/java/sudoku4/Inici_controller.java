/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Albert Gonzalez
 */
public class Inici_controller implements ActionListener {
    
    
   public static String dificultad = "";
   public static String usuari;
    Jugador j1;
    Tauler_controller tc;
    finestra_inici fi;
    


    public Inici_controller(finestra_inici fi, Tauler_controller tc) {

        this.tc = tc;
        this.fi = fi;

        fi.jugar.addActionListener(this);
        fi.dificil.addActionListener(this);
        fi.intermedio.addActionListener(this);
        fi.facil.addActionListener(this);
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //System.out.println(e.getActionCommand());
        usuari = fi.usuarioTB.getText();

        if (fi.facil.isSelected()) {
            dificultad = "facil";
        }

        if (fi.intermedio.isSelected()) {

            dificultad = "intermedio";
        }
        if (fi.dificil.isSelected()) {

            dificultad = "dificil";
        }

//        System.out.println(usuari);
//        System.out.println(dificultad);

        if (e.getActionCommand().equals("jugar")) {

            usuari=fi.usuarioTB.getText(); 
            j1 = new Jugador(usuari,0,dificultad);
            
            tc.t1.dificultat.setText(dificultad);
            tc.t1.jugadorLabel.setText(usuari);
            
            
            tc.t1.setVisible(true);
            fi.setVisible(false);
            tc.t1.setLocationRelativeTo(null);
            
        }

    }
    
   

  
}
