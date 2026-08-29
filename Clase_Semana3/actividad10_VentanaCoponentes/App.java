import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception{
        JFrame ventana = new JFrame("Sistema grafico - Tecmilenio");
        ventana.setSize(350, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        //Hacer el acomodo de los elementos en forma de columna
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //Agregar margen al panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Registro de datos");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        ventana.add(panel);
        ventana.setVisible(true);
    }
}