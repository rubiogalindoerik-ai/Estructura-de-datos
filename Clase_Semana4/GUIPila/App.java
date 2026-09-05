import javax.swing.*;
import java.awt.*;

public class App {
    public static Pila<String> pila = new Pila<>();
    public static void main(String[] args) throws Exception{
        // Configurar la ventana principal
        JFrame ventana = new JFrame("GUI - Pila");
        ventana.setSize(350, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal y el diseño
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        // Panel superior(Controles y campos de texto)
        JPanel panelControles = new JPanel(new GridLayout(3,1,5,5));
        JTextField txtValor = new JTextField();
        JButton btnPush = new JButton("Apilar elemento (PUSH)");
        JButton btnPop = new JButton("Desapilar elemento (POP)");
        panelControles.add(new JLabel("Valor a insertar"));
        panelControles.add(txtValor);

        JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));
        panelBotones.add(btnPush);
        panelBotones.add(btnPop);
        panelControles.add(panelBotones);

        panel.add(panelControles, BorderLayout.NORTH);

        JTextArea txtAreaPila = new JTextArea();
        txtAreaPila.setEditable(false);
        txtAreaPila.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane();

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(new JLabel("Estado de la pila: "), BorderLayout.NORTH);
        panelCentro.add(scrollPane, BorderLayout.CENTER);
        panel.add(panelCentro, BorderLayout.CENTER);

        // Definicion de la tarea(RUNNABLE) sirve para actualizar la vista
        Runnable actualizarVisualizacion = () -> {
            txtAreaPila.setText(pila.mostrarPila());
        };

        // Crear los eventos de los botones

    btnPush.addActionListener(e -> {
        String texto = txtValor.getText().trim();
        if (!texto.isEmpty()) {
            pila.push(texto);
            txtValor.setText("");
            actualizarVisualizacion.run();
        } else {
            JOptionPane.showMessageDialog(ventana, "Por favor escribe algo", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    });

    btnPop.addActionListener(e -> {
        String datoRemovido = pila.pop();
        if (datoRemovido != null) {
            JOptionPane.showMessageDialog(ventana, "Elemento retirado de la pila: " + datoRemovido);
            actualizarVisualizacion.run();
        } else {
            JOptionPane.showMessageDialog(ventana, "La pila esta vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    });

        // Mostrar ventana;
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
