package Program;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class datos extends JFrame implements ActionListener, ItemListener, java.io.Serializable, KeyListener{
    private String dia, mes, ann, GMFO, NCuenta, TCoD, edo;
    private JLabel clave, name,sex, date, tar, est, NC, foto, saldoi;
    private JTextField CC, NM, NumCuenta, saldo;
    private JButton agregar, buscar, eliminar,salir, botf;
    private JRadioButton RBM, RBF, OTR;
    private JCheckBox CTC, CTD;
    private JComboBox day, month, year, estado;
    public ArrayList <usuario> inf;
    private AudioClip principal, add, search, delete;
    public Icon ico;
    private ButtonGroup OPC = new ButtonGroup();
    private ButtonGroup CD = new ButtonGroup();
    // inicia el constructor
    public datos(){
        // ventana principal
        setLayout(null);
        inf = new ArrayList<>();
        setBounds(50, 50, 1200, 725);
        setTitle("Agregar Usuario");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/banco.png")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/fondo4.jpg"));
        JLabel fondo = new JLabel();
        fondo.setBounds(0,0,1200,725);
        fondo.setIcon(new ImageIcon(uno.getImage().getScaledInstance(fondo.getWidth(),
                fondo.getHeight(), Image.SCALE_DEFAULT)));
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Labels
        name = new JLabel("Nombre");
        name.setBounds(85, 100, 200, 25);
        name.setForeground(Color.DARK_GRAY);
        add(name);
        saldoi = new JLabel("Saldo inicial");
        saldoi.setBounds(285, 100, 200, 25);
        saldoi.setForeground(Color.DARK_GRAY);
        add(saldoi);
        clave = new JLabel("Numero de usuario");
        clave.setBounds(85, 170, 250, 25);
        clave.setForeground(Color.DARK_GRAY);
        add(clave);
        sex = new JLabel("Sexo");
        sex.setBounds(85, 240, 100, 25);
        sex.setForeground(Color.DARK_GRAY);
        add(sex);
        date = new JLabel("Fecha de nacimiento");
        date.setBounds(85, 385, 200, 25);
        date.setForeground(Color.DARK_GRAY);
        add(date);
        tar = new JLabel("Cuenta con:");
        tar.setBounds(85, 580, 200,25);
        tar.setForeground(Color.DARK_GRAY);
        add(tar);
        est = new JLabel("Estado de procedencia");
        est.setBounds(85, 310, 200, 25);
        est.setForeground(Color.DARK_GRAY);
        add(est);
        NC = new JLabel("Numero de cuenta");
        NC.setBounds(650, 115, 150, 25);
        NC.setForeground(Color.DARK_GRAY);
        add(NC);
        foto = new JLabel();
        foto.setBounds(615,300,200,200);
        foto.setForeground(Color.DARK_GRAY);
        add(foto);
        ImageIcon imgin = new ImageIcon(getClass().getResource("/imagenes/agimg.png"));
        foto.setIcon(new ImageIcon(imgin.getImage().getScaledInstance(foto.getWidth(),
                foto.getHeight(), Image.SCALE_DEFAULT)));
        // TextFields
        /*Validaciones*/
        //Verifica Solo Letras para el nombre
        NM = new JTextField();
        NM.setBounds(85, 135, 150, 25);
        NM.addKeyListener (new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        add(NM);
        //Verifica Solo Numeros para el numero de usuario
        CC = new JTextField();
        CC.setBounds(85, 205, 150, 25);
        CC.addKeyListener (new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        add(CC);
        saldo = new JTextField();
        saldo.setBounds(285, 135, 150, 25);
        saldo.addKeyListener (new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        add(saldo);
        NumCuenta = new JTextField();
        NumCuenta.setBounds(650, 150, 150, 25);
        add(NumCuenta);
        CC.setEnabled(true);
        NM.setEnabled(true);
        NumCuenta.setEnabled(true);
        // buttons
        agregar = new JButton("Agregar");
        agregar.setBounds(900, 100, 200, 80);
        ImageIcon altas = new ImageIcon(getClass().getResource("/imagenes/añadir.png"));
        agregar.setIcon(new ImageIcon(altas.getImage().getScaledInstance(45,
                45, Image.SCALE_DEFAULT)));
        agregar.addActionListener(this);
        agregar.setBackground(Color.GREEN);
        add(agregar);
        buscar = new JButton("Buscar");
        buscar.setBounds(900, 250, 200, 80);
        ImageIcon cons = new ImageIcon(getClass().getResource("/imagenes/buscar.png"));
        buscar.setIcon(new ImageIcon(cons.getImage().getScaledInstance(45,
                45, Image.SCALE_DEFAULT)));
        buscar.addActionListener(this);
        buscar.setBackground(Color.BLUE);
        add(buscar);
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(900, 400, 200, 80);
        ImageIcon rem = new ImageIcon(getClass().getResource("/imagenes/borrar.png"));
        eliminar.setIcon(new ImageIcon(rem.getImage().getScaledInstance(45,
                45, Image.SCALE_DEFAULT)));
        eliminar.addActionListener(this);
        eliminar.setBackground(Color.ORANGE);
        add(eliminar);
        salir = new JButton("Cancelar");
        salir.setBounds(900, 550, 200, 80);
        ImageIcon cancelar = new ImageIcon(getClass().getResource("/imagenes/return.png"));
        salir.setIcon(new ImageIcon(cancelar.getImage().getScaledInstance(45,
                45, Image.SCALE_DEFAULT)));
        salir.setBackground(Color.red);
        salir.addActionListener(this);
        add(salir);
        botf = new JButton("Agregar imagen");
        botf.setBounds(615,565,150,50);
        botf.addActionListener(this);
        add(botf);
        // Checkbox
        CTC = new JCheckBox("Tarjeta de credito");
        CTC.setBounds (85,600,150,25);
        CTC.addItemListener(this);
        add(CTC);
        CD.add(CTC);
        CTD = new JCheckBox("Tarjeta de debito");
        CTD.setBounds (250,600,150,25);
        CTD.addItemListener(this);
        add(CTD);
        CD.add(CTD);
        // RadioButtons
        RBM = new JRadioButton("Masculino");
        RBM.setBounds(85, 275, 100, 30);
        RBM.addItemListener(this);
        add(RBM);
        OPC.add(RBM);
        RBF = new JRadioButton("Femenino");
        RBF.setBounds(190, 275, 90, 30);
        RBF.addItemListener(this);
        add(RBF);
        OPC.add(RBF);
        OTR = new JRadioButton("Otro");
        OTR.setBounds(285, 275, 60, 30);
        OTR.addItemListener(this);
        add(OTR);
        OPC.add(OTR);
        // ComboBox
        day = new JComboBox();
        day.addItem("Día");day.addItem("1");day.addItem("2");day.addItem("3");
        day.addItem("4");day.addItem("5");day.addItem("6");day.addItem("7");
        day.addItem("8");day.addItem("9");day.addItem("10");day.addItem("11");
        day.addItem("12");day.addItem("13");day.addItem("14");day.addItem("15");
        day.addItem("16");day.addItem("17");day.addItem("18");day.addItem("19");
        day.addItem("20");day.addItem("21");day.addItem("22");day.addItem("23");
        day.addItem("24");day.addItem("25");day.addItem("26");day.addItem("27");
        day.addItem("28");day.addItem("29");day.addItem("30");day.addItem("31");
        day.setBounds(85, 415, 150, 30);
        day.setSelectedIndex(0);
        day.addItemListener(this);
        add(day);
        month = new JComboBox();
        month.addItem("Mes");month.addItem("Enero");month.addItem("Febrero");
        month.addItem("Marzo");month.addItem("Abril");month.addItem("Mayo");
        month.addItem("Junio");month.addItem("Julio");month.addItem("Agosto");
        month.addItem("Septiembre");month.addItem("Octubre");
        month.addItem("Noviembre");month.addItem("Diciembre");
        month.setBounds(85, 470, 150, 30);
        month.setSelectedIndex(0);
        month.addItemListener(this);
        add(month);
        year = new JComboBox();
        year.addItem("Año");year.addItem("2019");year.addItem("2018");
        year.addItem("2017");year.addItem("2016");year.addItem("2015");
        year.addItem("2014");year.addItem("2013");year.addItem("2012");
        year.addItem("2011");year.addItem("2010");year.addItem("2009");
        year.addItem("2008");year.addItem("2007");year.addItem("2006");
        year.addItem("2005");year.addItem("2004");year.addItem("2003");
        year.addItem("2002");year.addItem("2001");year.addItem("2000");
        year.addItem("1999");year.addItem("1998");year.addItem("1997");
        year.addItem("1996");year.addItem("1995");year.addItem("1994");
        year.addItem("1993");year.addItem("1992");year.addItem("1991");
        year.addItem("1990");year.addItem("1989");year.addItem("1988");
        year.addItem("1987");year.addItem("1986");year.addItem("1985");
        year.addItem("1984");year.addItem("1983");year.addItem("1982");
        year.addItem("1981");year.addItem("1980");year.addItem("1979");
        year.addItem("1978");year.addItem("1977");year.addItem("1976");
        year.addItem("1975");year.addItem("1974");year.addItem("1973");
        year.addItem("1972");year.addItem("1971");year.addItem("1970");
        year.addItem("1969");year.addItem("1968");year.addItem("1967");
        year.addItem("1966");year.addItem("1965");year.addItem("1964");
        year.addItem("1963");year.addItem("1962");year.addItem("1961");
        year.addItem("1960");year.addItem("1959");year.addItem("1958");
        year.addItem("1957");year.addItem("1956");year.addItem("1955");
        year.addItem("1954");year.addItem("1953");year.addItem("1952");
        year.addItem("1951");year.addItem("1950");year.addItem("1949");
        year.addItem("1948");year.addItem("1947");year.addItem("1946");
        year.addItem("1945");year.addItem("1944");year.addItem("1943");
        year.addItem("1942");year.addItem("1941");year.addItem("1940");
        year.addItem("1939");year.addItem("1938");year.addItem("1937");
        year.addItem("1936");year.addItem("1935");year.addItem("1934");
        year.addItem("1933");year.addItem("1932");year.addItem("1931");
        year.addItem("1930");year.addItem("1929");year.addItem("1928");
        year.addItem("1927");year.addItem("1926");year.addItem("1925");
        year.addItem("1924");year.addItem("1923");year.addItem("1922");
        year.addItem("1921");year.addItem("1920");year.addItem("1919");
        year.addItem("1918");year.addItem("1917");year.addItem("1916");
        year.addItem("1915");year.addItem("1914");year.addItem("1913");
        year.addItem("1912");year.addItem("1911");year.addItem("1910");
        year.addItem("1909");year.addItem("1908");year.addItem("1907");
        year.addItem("1906");year.addItem("1905");year.addItem("1904");
        year.addItem("1903");year.addItem("1902");year.addItem("1901");
        year.addItem("1900");
        year.setBounds(85, 525, 150, 30);
        year.setSelectedIndex(0);
        year.addItemListener(this);
        add(year);
        estado = new JComboBox();
        estado.addItem("Estado");estado.addItem("Aguascalientes");
        estado.addItem("Baja California");estado.addItem("Baja California Sur");
        estado.addItem("Campeche");estado.addItem("Chiapas");estado.addItem("Chihuahua");
        estado.addItem("Ciudad de México");estado.addItem("Coahuila");
        estado.addItem("Colima");estado.addItem("Durango");estado.addItem("Estado de México");
        estado.addItem("Guanajuato");estado.addItem("Guerrero");estado.addItem("Hidalgo");
        estado.addItem("Jalisco");estado.addItem("Michoacán");estado.addItem("Morelos");
        estado.addItem("Nayarit");estado.addItem("Nuevo León");estado.addItem("Oaxaca");
        estado.addItem("Puebla");estado.addItem("Querétaro");estado.addItem("Quintana Roo");
        estado.addItem("San Luis Potosi");estado.addItem("Sinaloa");estado.addItem("Sonora");
        estado.addItem("Tabasco");estado.addItem("Tamaulipas");estado.addItem("Tlaxcala");
        estado.addItem("Veracruz");estado.addItem("Yucatán");estado.addItem("Zacatecas");
        estado.setBounds(85, 345, 150, 30);
        estado.setSelectedIndex(0);
        estado.addItemListener(this);
        add(estado);
        /* se insertan audios */
        principal = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/Sparkle.wav"));
        add = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/Strad.wav"));
        delete = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/RelaxPiano.wav"));
        search = java.applet.Applet.newAudioClip(getClass().getResource("/Musica/Mall.wav"));
        principal.play();
        // se hace visible
        setVisible(true);
    }
    // abrir y cerrar sirven para guardar datos
    public void abrir(){
        try{
            FileInputStream fis = new FileInputStream("usuarios.dat");
            ObjectInputStream entrada = new ObjectInputStream(fis);
            inf = (ArrayList<usuario>)entrada.readObject();
            fis.close();
            entrada.close();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Error, se creara en un momento");
            System.out.println(e.toString());
        }
    }
    public void cerrar(){
        try{
            FileOutputStream fos = new FileOutputStream("usuarios.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(inf);
            fos.close();
            out.close();
        }
        catch(Exception e){
            System.out.println("Error al final");
        }
    }
    // inician los Override
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            if (e.getSource() == day){
                dia = (String) e.getItem();
            } else if (e.getSource() == month){
                mes = (String) e.getItem();
            } else if (e.getSource() == year){
                ann = (String) e.getItem();
            } else if(e.getSource() == estado) {
                edo = (String) e.getItem();
            }
        }
        if (e.getSource() instanceof JRadioButton ){
            if (RBM.isSelected()){
                GMFO = "M";
            }else if (RBF.isSelected()){
                GMFO = "F";
            }else if (OTR.isSelected()){
                GMFO = "O";
            }
        }
        if (e.getSource() instanceof JCheckBox){
            if (CTC.isSelected()){
                TCoD = "Credito";
            } else if (CTD.isSelected()){
                TCoD = "Debito";
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        usuario User = new usuario();
        abrir();
        if (e.getActionCommand().equals("Agregar imagen")){
            JFileChooser selector = new JFileChooser();
            selector.showOpenDialog(this);
            File archivoelegido = selector.getSelectedFile();
            if(archivoelegido !=null){
                String origen = archivoelegido.getPath();
                ImageIcon ico = new ImageIcon(origen);
                this.foto.setIcon(new ImageIcon(ico.getImage().getScaledInstance(foto.getWidth(),
                foto.getHeight(), Image.SCALE_DEFAULT)));
            } else{
                JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo");
            }
        } else if (e.getActionCommand().equals("Cancelar")){
            graficoU regresar = new graficoU();
            principal.stop();
            add.stop();
            search.stop();
            delete.stop();
            dispose();
            regresar.setVisible(true);
        } else if (e.getActionCommand().equals("Agregar")){
            principal.stop();
            add.play();
            search.stop();
            delete.stop();
            User.setClave(CC.getText());
            User.setNombre(NM.getText());
            User.setFechaDN(dia + mes.charAt(0) + ann);
            User.setSexo(GMFO);
            User.setTCoD(TCoD);
            User.setEstado(edo);
            User.setSaldo(Float.parseFloat(saldo.getText()));
            User.setIcon(ico);
            inf.add(User);
            NumCuenta.setEnabled(true);
            NCuenta = User.getClave() + User.getNombre().charAt(0) + User.getSexo()
                    + User.getFechaDN() + User.getEstado().charAt(0);
            User.setNCuenta(NCuenta);
            NumCuenta.setText(String.valueOf(User.getNCuenta()));
            CC.setText("");
            NM.setText("");
        } else if (e.getActionCommand().equals("Buscar")){
            add.stop();
            principal.stop();
            search.play();
            delete.stop();
            int cuantos, flag = 0;
            cuantos = inf.size();
            for (int w = 0; w < cuantos; w++) {
                if (NumCuenta.getText().equals(inf.get(w).getNCuenta())){
                    flag = 1;
                    JOptionPane.showMessageDialog(buscar, "Usuario encontrado");
                    saludo hi = new saludo(inf.get(w));
                    hi.setVisible(true);
                    break;
                }
            }
            if (flag == 0){
                JOptionPane.showMessageDialog(buscar, "Usuario no encontrado");
            }
            CC.setText(null);
            NM.setText(null);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            estado.setSelectedIndex(0);
        } else  if (e.getActionCommand().equals("Eliminar")){
            principal.stop();
            add.stop();
            search.stop();
            delete.play();
            int cuantos, flag = 0;
            cuantos = inf.size();
            for (int w = 0; w < cuantos; w++) {
                if (NumCuenta.getText().equals(inf.get(w).getNCuenta())){
                    flag = 1;
                    inf.remove(inf.get(w));
                    JOptionPane.showMessageDialog(eliminar, "Usuario Eliminado");
                    break;
                }
            } 
            if (flag == 0){
                JOptionPane.showMessageDialog(eliminar, "Usuario no encontrado");
            }
            CC.setText(null);
            NM.setText(null);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            estado.setSelectedIndex(0);
        }
        cerrar();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}