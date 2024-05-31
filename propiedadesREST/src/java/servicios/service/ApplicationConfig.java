/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author migue
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.service.AlquilarFacadeREST.class);
        resources.add(servicios.service.ComprarFacadeREST.class);
        resources.add(servicios.service.DireccionesFacadeREST.class);
        resources.add(servicios.service.FavoritosFacadeREST.class);
        resources.add(servicios.service.PropiedadesFacadeREST.class);
        resources.add(servicios.service.RolesFacadeREST.class);
        resources.add(servicios.service.SegurosFacadeREST.class);
        resources.add(servicios.service.UsuariosFacadeREST.class);
        resources.add(servicios.service.ValoracionesFacadeREST.class);
        resources.add(servicios.service.VisitasFacadeREST.class);
    }
    
}
