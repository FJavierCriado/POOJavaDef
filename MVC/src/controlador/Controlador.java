/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author usuario
 */
import vista.Vista;
import modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controlador implements ActionListener {
    private Vista view;
    private Modelo model;
    
    public Controlador(Vista view, Modelo model) {
        this.view=view;
        this.model=model;
        this.view.getBtnMultiplicar().addActionListener(this);
    }
    public void iniciar() {
        view.setTitle("MVC Multiplicar");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setNumeroUno(Integer.parseInt(view.getTxtNumero1().getText()));
        model.setNumeroDos(Integer.parseInt(view.getTxtNumero2().getText()));
        model.multiplicar();
        view.getTxtResultado().setText(""+model.getResultado());
    }
    
}
