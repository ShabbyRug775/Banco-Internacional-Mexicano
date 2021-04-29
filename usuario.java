package Program;

import javax.swing.Icon;

public class usuario implements java.io.Serializable{
    private float saldo;
    private float cambio;
    private String clave;
    private String nombre;
    private String sexo;
    private String fechaDN;
    private String NCuenta;
    private String TCoD;
    private String estado;
    private Icon ico;
     // getters and setters
    public Icon getIco() {
        return ico;
    }
    public void setIcon(Icon ico) {   
        this.ico = ico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNCuenta() {
        return NCuenta;
    }
    public void setNCuenta(String NCuenta) {
        this.NCuenta = NCuenta;
    }
    public String getFechaDN() {
        return fechaDN;
    }
    public void setFechaDN(String fechaDN) {
        this.fechaDN = fechaDN;
    }
    public String getTCoD() {
        return TCoD;
    }
    public void setTCoD(String TCoD) {
        this.TCoD = TCoD;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getCambio() {
        return cambio;
    }
    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
    public float retiros(){
        return saldo - cambio;
    }
    public float depositos(){
        return saldo + cambio;
    }
}