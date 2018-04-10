package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Marco extends JFrame {
    public Marco(){
        setLayout(new BorderLayout());
        setBounds(400, 200, 400, 200);
        this.setLocationRelativeTo(null);

        //panel superior
        superior = new JPanel();
        superior.add(new JLabel("INGRESO DE USUARIO"));
        add(superior, BorderLayout.NORTH);

        //panel de login
        login = new Login();
        add(login, BorderLayout.CENTER);
        login.setVisible(true);

        //panel inferior con el botonazo
        JPanel inferior = new JPanel();
        JButton botonazo = new JButton("Cambiar");
        botonazo.addActionListener(new Cambiar());
        inferior.add(botonazo);
        add(inferior, BorderLayout.SOUTH);
    }

    private class Cambiar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            contador++;
            if(login.getVPass()==true){
                setUser(login.getUser());
                login.setVisible(false);
                formulario = new Formulario();
                add(formulario, BorderLayout.CENTER);
                if(contador>=2){
                    System.exit(0);
                }
            }
        }
    }
    void setUser(String user){
        this.user = new JTextField(user);
    }
    private JPanel superior;
    private Login login;
    private Formulario formulario;
    private int contador = 0;
    JTextField user;
    JPasswordField pass;
}