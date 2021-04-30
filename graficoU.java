package Program;
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class graficoU extends JFrame implements ActionListener, java.io.Serializable{
    private JButton ingresar, salir;
    private AudioClip player;
    public graficoU(){
        // ventana principal
        setLayout(null);
        setBounds(50, 50, 1200, 725);
        setTitle("Banco Internacional");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/banco.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/fondo4.jpg"));
        JLabel fondo = new JLabel();
        fondo.setBounds(0,0,1200,725);
        fondo.setIcon(new ImageIcon(uno.getImage().getScaledInstance(fondo.getWidth(),
                fondo.getHeight(), Image.SCALE_DEFAULT)));
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // buttons
        
        salir = new JButton("Salir");
        salir.setBounds(400, 430, 300, 100);
        ImageIcon exit = new ImageIcon(getClass().getResource("/imagenes/exit.png"));
        salir.setIcon(new ImageIcon(exit.getImage().getScaledInstance(45,
                45, Image.SCALE_DEFAULT)));
        salir.addActionListener(this);
        salir.setBackground(Color.red);
        add(salir);

        // se pueden insertar audios
        
        // se hace visible
        setVisible(true);
    }
    // metodos abstractos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Ingresar")){
            datos agregar = new datos();
            agregar.setVisible(true);
            player.stop();
            dispose();
        } else if (e.getActionCommand().equals("Salir")){
            player.stop();
            dispose();
            System.exit(0);
        }
    }
}
