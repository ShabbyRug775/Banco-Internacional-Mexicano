package Program;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class saludo extends JFrame implements java.io.Serializable, ItemListener, ActionListener{
    private JLabel nombre, clave, sexo, fechaDN, TCoD, estado, NCuenta, saldo, op, ico, NS;
    private JComboBox operacion;
    private JTextField cambio, SF;
    private JButton confirma;
    private float Sald, camb, SFF;
    saludo(usuario objeto){
        // ventana
        setLayout(null);
        setBounds(100, 100, 750, 650);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/banco.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/fondo4.jpg"));
        JLabel fondo = new JLabel();
        fondo.setBounds(0,0,750,600);
        fondo.setIcon(new ImageIcon(uno.getImage().getScaledInstance(fondo.getWidth(),
                fondo.getHeight(), Image.SCALE_DEFAULT)));
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        // Labels
        nombre = new JLabel("Nombre: \t " + objeto.getNombre());
        nombre.setBounds(50, 30, 250, 30);
        nombre.setForeground(Color.DARK_GRAY);
        add(nombre);
        clave = new JLabel("Clave: \t " + objeto.getClave());
        clave.setBounds(50, 90, 250, 30);
        clave.setForeground(Color.DARK_GRAY);
        add(clave);
        sexo = new JLabel("Sexo: \t " + objeto.getSexo());
        sexo.setBounds(50, 150, 250, 30);
        sexo.setForeground(Color.DARK_GRAY);
        add(sexo);
        estado = new JLabel("Estado: \t " + objeto.getEstado());
        estado.setBounds(50, 210, 250, 30);
        estado.setForeground(Color.DARK_GRAY);
        add(estado);
        fechaDN = new JLabel("Fecha de nacimiento: \t " + objeto.getFechaDN());
        fechaDN.setBounds(50, 270, 250, 30);
        fechaDN.setForeground(Color.DARK_GRAY);
        add(fechaDN);
        TCoD = new JLabel("Tipo de tarjeta: \t " + objeto.getTCoD());
        TCoD.setBounds(50, 330, 250, 30);
        TCoD.setForeground(Color.DARK_GRAY);
        add(TCoD);
        NCuenta = new JLabel("Numero de cuenta: \t " + objeto.getNCuenta());
        NCuenta.setBounds(50, 390, 250, 30);
        NCuenta.setForeground(Color.DARK_GRAY);
        add(NCuenta);
        saldo = new JLabel("Saldo: \t " + objeto.getSaldo());
        saldo.setBounds(50, 450, 100, 30);
        saldo.setForeground(Color.DARK_GRAY);
        add(saldo);
        NS = new JLabel("Saldo Nuevo: \t ");
        NS.setBounds(50, 500, 150, 30);
        NS.setForeground(Color.DARK_GRAY);
        add(NS);
        ico = new JLabel(objeto.getIco());
        ico.setBounds(350, 200, 150, 150);
        add(ico);
        op = new JLabel();
        op.setBounds(400, 410, 250, 40);
        op.setForeground(Color.LIGHT_GRAY);
        add(op);
        // ComboBox
        operacion = new JComboBox();
        operacion.addItem("Selecciona la operacion a realizar");
        operacion.addItem("Retiro");
        operacion.addItem("Deposito");
        operacion.setBounds(350, 150, 275,40);
        operacion.setSelectedIndex(0);
        operacion.addItemListener((ItemListener) this);
        add(operacion);
        // textField
        cambio = new JTextField();
        cambio.setBounds(400, 450, 150, 25);
        add(cambio);
        SF = new JTextField();
        SF.setBounds(225, 500, 150, 25);
        add(SF);
        // Buttons
        confirma = new JButton("Confirmar");
        confirma.setBounds(400, 500, 150, 40);
        confirma.addActionListener((ActionListener) this);
        add(confirma);
        // se hace visible
        setVisible(true);
    }
    // inician los override
    @Override
    public void itemStateChanged(ItemEvent e) {
        usuario Dat = new usuario();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getSource() == operacion){
                op.setText("Por favor ingrese el valor del " + operacion.getSelectedItem());
                String cadena = (String) e.getItem();
                if(cadena.equals("Retiro")){
                    cambio.setVisible(true);
                }else if(cadena.equals("Deposito")){
                    cambio.setVisible(true);
                } 
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        usuario Dat = new usuario();
        Sald = Dat.getSaldo();
        if (e.getActionCommand().equals("Confirmar")){
            Dat.setCambio(Float.parseFloat(cambio.getText()));
            if(operacion.getSelectedItem().equals("Retiro")){
                if (camb > Sald){
                    SFF = Dat.retiros();
                    JOptionPane.showMessageDialog(confirma, "Saldo insuficiente");
                } else {
                    SFF = Dat.retiros();
                    SF.setText(String.valueOf(SFF));
                }
            } else if(operacion.getSelectedItem().equals("Deposito")){
                SFF = Dat.depositos();
                SF.setText(String.valueOf(SFF));
            }
        }
    }
}