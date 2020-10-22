/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku4;



/**
 *
 * @author Albert Gonzalez
 */
public class Jugador {
    
    String nombre; 
    int score; 
    String dificultad; 

    public Jugador(String nombre, int score, String dificultad) {
        this.nombre = nombre;
        this.score = score;
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Player{" + "nombre=" + nombre + ", score=" + score + ", dificultad=" + dificultad + '}';
    }

    public Jugador() {
    }

  
    
    
    
}
