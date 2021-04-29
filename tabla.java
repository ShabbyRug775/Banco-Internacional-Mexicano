package Program;

import Program.usuario;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tabla extends JFrame{
    public tabla(usuario objeto){
        super("Datos del usuario");
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn(objeto.getNombre());
    
    String[]p1={"Clave", objeto.getClave()};
    String[]p2={"Sexo", objeto.getSexo()};
    String[]p3={"Estado", objeto.getEstado()};
    String[]p4={"Fecha de nacimiento", objeto.getFechaDN()};
    String[]p5={"Tipo de tarjeta", objeto.getTCoD()};
    String[]p6={"Numero de cuenta", objeto.getNCuenta()};
    
    modelo.addRow(p1);
    modelo.addRow(p2);
    modelo.addRow(p3);
    modelo.addRow(p4);
    modelo.addRow(p5);
    modelo.addRow(p6);
    
    JTable tablas = new JTable(modelo);
    tablas.setBounds(20,20,300,700);
    }
}
