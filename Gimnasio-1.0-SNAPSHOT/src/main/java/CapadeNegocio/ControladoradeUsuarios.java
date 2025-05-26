package CapadeNegocio;

public  class  ControladoradeUsuarios {
    private static final ControladoradePersistencias CP = new ControladoradePersistencias();
    
    private ControladoradeUsuarios() {}
    
    public static ControladoradePersistencias getCP() {
        return CP;
    }  
    
}
