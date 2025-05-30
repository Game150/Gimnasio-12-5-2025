package Controladoras;

public  class  ControladoradeUsuarios {
    private static final ControladoradePersistencias CP = new ControladoradePersistencias();
    private static final ControladoradeModificaciones CM = new ControladoradeModificaciones();
    private static final ControladoradeObtenciones CO = new ControladoradeObtenciones();
    private static final ControladoradeEliminaciones CE = new ControladoradeEliminaciones();
    
    private ControladoradeUsuarios() {}
    
    public static ControladoradePersistencias getCP() {
        return CP;
    }  
    
    public static ControladoradeModificaciones getCM() {
        return CM;
    }
    
    public static ControladoradeObtenciones getCO() {
        return CO;
    }
    
    public static ControladoradeEliminaciones getCE() {
        return CE;
    }
    
}
