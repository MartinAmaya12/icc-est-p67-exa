package moldes;

public class Pedido{
   private String nombre;
    private String codigoPostal;
    private List<Integer> prioridades;
    public Pedido(String nombre, String codigoPostal, List<Integer> prioridades) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.prioridades = prioridades;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public List<Integer> getPrioridades() {
        return prioridades;
    }
    public void setPrioridades(List<Integer> prioridades) {
        this.prioridades = prioridades;
    }

    public int getZona() {
    String[] partes = this.ip.split("\\.");
    return Integer.parseInt(partes[3]);
    }

    public int getUrgencia(){
        int sumaCodigos = 0;
        for(int cod : this.codigos){
            if(cod % 3 == 0){
                sumaCodigos = sumaCodigos + cod;
            }
        }
        String nombreLimpio  = this.nombre.replace("", "");
        Set<Character> caracteresUnidos = new HashSet<>();

        for(char c: nombreLimpio.toCharArray()){
            caracteresUnidos.add(c);
        }

        return sumaCodigos * caracteresUnidos.size();
    }

   @Override
    public String toString() {
        return "Pedido [nombre=" + nombre + ", codigo Postal=" + codigoPostal + ", Prioridades=" + prioridades
        + "zona= " + zona + "urgencia= " + urgencia "]";
    }


}





























































ublic class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public List<Integer> getCodigos() {
        return codigos;
    }
    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }

    public int getSubred() {
    String[] partes = this.ip.split("\\.");
    return Integer.parseInt(partes[3]);
    }

    public int getRiesgo(){
        int sumaCodigos = 0;
        for(int cod : this.codigos){
            if(cod % 3 == 0){
                sumaCodigos = sumaCodigos + cod;
            }
        }
        String nombreLimpio  = this.nombre.replace("", "");
        Set<Character> caracteresUnidos = new HashSet<>();

        for(char c: nombreLimpio.toCharArray()){
            caracteresUnidos.add(c);
        }

        return sumaCodigos * caracteresUnidos.size();
    }

    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", ip=" + ip + ", codigos=" + codigos 
                + ", subred= " + ", codigos= " +"]";
    }

    
}