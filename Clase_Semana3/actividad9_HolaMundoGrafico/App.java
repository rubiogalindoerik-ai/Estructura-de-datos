import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        //1. Crear la ventana principal(Frame)
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centra la ventana
        ventana.setLocationRelativeTo(null);
        //2. Crear los componentes
        JLabel etiqueta = new JLabel("Hola mundo");
        JButton boton = new JButton("Da Click aqui");
        //3. Definir que hace el boton
        boton.addActionListener(e -> {
            etiqueta.setText("Boton presionado");
        });
        //4. Agregar los componente a la ventana(panel)
        JPanel panel = new JPanel();
        panel.add(boton);
        panel.add(etiqueta);
        //5. Agregar el panel a la ventana
        ventana.add(panel);
        //6. Mostrar la ventana
        ventana.setVisible(true); 
    }
}