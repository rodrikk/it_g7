package modelos;
// Generated 18-may-2024 17:30:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private int id;
     private String rol;
     private Set usuarioses = new HashSet(0);

    public Rol() {
    }

	
    public Rol(int id, String rol) {
        this.id = id;
        this.rol = rol;
    }
    public Rol(int id, String rol, Set usuarioses) {
       this.id = id;
       this.rol = rol;
       this.usuarioses = usuarioses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


