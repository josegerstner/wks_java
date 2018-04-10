package ventanas;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

//
class Login extends JPanel {
    public Login(){
        //llenamos la caja del primer renglón
        JLabel nUser = new JLabel("User: ");
        user = new JTextField(20);
        Box cajaUser = Box.createHorizontalBox();
        cajaUser.add(nUser);
        cajaUser.add(Box.createHorizontalStrut(10));
        cajaUser.add(user);

        //llanemos la caja del segundo renglón
        JLabel nPass = new JLabel("Pass: ");
        pass = new JPasswordField(20);
        pass.getDocument().addDocumentListener(new CompruebaPass());
        Box cajaPass = Box.createHorizontalBox();
        cajaPass.add(nPass);
        cajaPass.add(Box.createHorizontalStrut(10));
        cajaPass.add(pass);

        //añadimos la caja dentro de una caja más grande
        Box contenedor = Box.createVerticalBox();
        contenedor.add(cajaUser);
        contenedor.add(Box.createVerticalStrut(10));
        contenedor.add(cajaPass);

        //añadimos el contenedor al panel
        add(contenedor);
    }
    public static String setearTitle(){
        return "INGRESO DE USUARIOS";
    }
    //clase que comprueba el password ingresado
    private class CompruebaPass implements DocumentListener {
        public void changedUpdate(DocumentEvent e){

        }
        public void insertUpdate(DocumentEvent e) {
            char[] contrasenia;
            contrasenia = pass.getPassword();
            if(contrasenia.length < 8 || contrasenia.length > 12){
                pass.setBackground(Color.RED);
                vPass = false;
            }else{
                pass.setBackground(Color.WHITE);
                vPass = true;
            }
        }
        public void removeUpdate(DocumentEvent e) {
            this.insertUpdate(e);
        }
    }
    public boolean getVPass(){
        return vPass;
    }
    public String getUser(){
        return user.getText();
    }
    private JTextField user;
    private JPasswordField pass;
    private boolean vPass = false;
}