import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.*;

public class App {
    public static long calcularFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calcularFactorial(n-1);
    }

    // Fibonacci recursivo
    public static long calcularFibonacci (int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return calcularFibonacci(n-1) + calcularFibonacci(n-2);
    }
    public static void main(String[] args) throws Exception{
        // Creacion de una interfaz grafica
        // Crear la ventana
        JFrame ventana = new JFrame("Algoritmos recursivos");
        ventana.setSize(520, 450);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        //cambiar el icono de la ventana
        try {
            URL iconUrl = URI.create("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqN4ZDDf84jFh-Z12RhK1U-YlmKWGUFtgLqpofkEyUMw&s").toURL();
            Image iconoVentana = ImageIO.read(iconUrl);
            ventana.setIconImage(iconoVentana);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del icono: " + e.getMessage());
        }

        // crear panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        // Cargar una imagen
        JLabel lblBanner = new JLabel();
        lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            URL imagenUrl = URI.create("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqN4ZDDf84jFh-Z12RhK1U-YlmKWGUFtgLqpofkEyUMw&s").toURL();
            Image imgBanner = ImageIO.read(imagenUrl);
            ImageIcon ingBanner = new ImageIcon(imgBanner);
            lblBanner.setIcon(ingBanner);
        } catch (Exception e) {
            System.out.println("No se pudo cargar el banner");
        }
        panelPrincipal.add(lblBanner, BorderLayout.NORTH);
        
        // Crear 3 paneles para separar los algoritmos
        JTabbedPane pestanas = new JTabbedPane();
        // Pestaña 1: Factorial
        JPanel panelFactorial = new JPanel(new GridLayout(3,1,10,10));
        panelFactorial.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        JTextField txtFactorial = new JTextField("5");
        JButton btnCalcularFactorial = new JButton("Calcular factorial(n!)");
        JTextArea areaLongFactorial = new JTextArea();
        areaLongFactorial.setEditable(false);
        areaLongFactorial.setFont(new Font("Monospaced", Font.PLAIN, 16));

        JPanel subJPanelF = new JPanel(new GridLayout(1,2,5,5));
        subJPanelF.add(new JLabel("Ingresa n:"));
        subJPanelF.add(txtFactorial);

        panelFactorial.add(subJPanelF);
        panelFactorial.add(btnCalcularFactorial);
        panelFactorial.add(new JScrollPane(areaLongFactorial));

        btnCalcularFactorial.addActionListener(e -> {
                try {
                    int n = Integer.parseInt(txtFactorial.getText().trim());
                    if (n < 0 || n > 20) {
                        areaLongFactorial.setText("Por favor ingresa un numero entre 0 y 20");
                        return;
                    }
                    long resultado = calcularFactorial(n);
                    areaLongFactorial.setText("Algoritmo Factorial Recursivo\n");
                    areaLongFactorial.append("Resultado de factorial (" + n + ") = " + resultado);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: ingresa un numero valido: " + ex);
                }
        });

        // Pestaña 2: Fibonacci
        JPanel panelFibonacci = new JPanel(new GridLayout(3,1,10,10));
        panelFibonacci.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JTextField txtFibonacci = new JTextField("6");
        JButton btnCalcularFibonnacci = new JButton("Calcular serie Fibonnaci");
        JTextArea areaLogFibonacci = new JTextArea();
        areaLogFibonacci.setEditable(false);
        areaLogFibonacci.setFont(new Font("Monospaced", Font.BOLD, 16));

        JPanel subPanelFibonacci = new JPanel(new GridLayout(1,2,5,5));
        subPanelFibonacci.add(new JLabel("Ingresa el limite: "));
        subPanelFibonacci.add(txtFibonacci);

        panelFibonacci.add(subPanelFibonacci);
        panelFibonacci.add(btnCalcularFibonnacci);
        panelFactorial.add(new JScrollPane(areaLogFibonacci));

        btnCalcularFibonnacci.addActionListener(e -> {
                try {
                    int n = Integer.parseInt(txtFibonacci.getText().trim());
                    if (n < 0) {
                        areaLogFibonacci.setText("Por favor ingresa un numero positivo");
                        return;
                    }
                    long resultado = calcularFibonacci(n);
                    areaLogFibonacci.setText("Algoritmo Fibonacci Recursivo\n");
                    areaLogFibonacci.append("Valor en la posicion ("+n+") = " + resultado);
                } catch (NumberFormatException ex) {
                    areaLogFibonacci.setText("Error: ingresa un numero valido");
                }
        });


        // Agregar las pestañas
        pestanas.addTab("Factorial", panelFactorial);

        panelPrincipal.add(pestanas, BorderLayout.NORTH);

        //Mostrar la ventana
        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
}
