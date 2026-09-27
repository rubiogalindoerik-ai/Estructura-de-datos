import javax.swing.*;
import java.awt.*;

public class MainVentana extends JFrame{
    // Permite al usaurio escribir el numero a buscar
    private JTextField txtObjetivo;
    // Permite al usuario visualizar el resultado
    private JTextArea areaResultado;

    // Arreglo ordenado de prueba
    private int[] datos = {2,5,8,12,16,29,58,98,100}; 

    public MainVentana(){
        // Configuracion de la ventana
        // JFrame ventana = new JFrame();
        // ventana.setTitle()
        setTitle("Metodos de busqueda");
        setSize(480,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Panel superior para los controles
        JPanel panelControles = new JPanel(new GridLayout(3,1,5,5));

        JPanel subPanelInput = new JPanel(new GridLayout(3,1,5,5));
        subPanelInput.add(new JLabel("Numero a buscar: "));
        txtObjetivo = new JTextField("6");
        subPanelInput.add(txtObjetivo);
        panelControles.add(subPanelInput);

        JButton btnLineal = new JButton("Ejecutar Busqueda Lineal");
        JButton btnBinario = new JButton("Ejecutar Busqueda Binaria");
        panelControles.add(btnLineal);
        panelControles.add(btnBinario);
        panelPrincipal.add(panelControles, BorderLayout.NORTH);

        //Area de texto para mostrar los resultados
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Arial", Font.PLAIN, 16));
        areaResultado.setText("Arreglo ejemplo: \n [2,5,8,12,16,29,58,98,100]\n\nSeleccione un metodo de busqueda");
        panelPrincipal.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Boton de busqueda lineal
        btnLineal.addActionListener(e -> {
            try {
                int objetivo = Integer.parseInt(txtObjetivo.getText().trim());
                int indice = AlgortimosBusqueda.buscarLineal(datos, objetivo);

                areaResultado.setText("Metodo de busqueda lineal\n");
                if (indice != -1) {
                    areaResultado.append("Valor encontrado\nEl valor: " + objetivo + " esta en la poscion [ " + indice + " ]");
                } else {
                    areaResultado.setText("El valor: " + objetivo + " no existe en los datos");
                }
            } catch (NumberFormatException ex) {
                areaResultado.setText("Error: ingresa un NUMERO por favor.");

            }
        });

        // Boton de busqueda binaria
        btnBinario.addActionListener(e -> {
            try {
                int objetivo = Integer.parseInt(txtObjetivo.getText().trim());
                int indice = AlgortimosBusqueda.busquedaBinaria(datos, 0, datos.length -1, objetivo);

                areaResultado.setText("Metodo de busqueda binaria\n");
                if (indice != -1) {
                    areaResultado.append("Valor encontrado\nEl valor: " + objetivo + " esta en la poscion [ " + indice + " ]");
                } else {
                    areaResultado.setText("El valor: " + objetivo + " no existe en los datos");
                }
            } catch (NumberFormatException ex) {
                areaResultado.setText("Error: ingresa un NUMERO por favor.");
                
            }
        });

    }

    public static void main(String[] args) {
        
    }
}
