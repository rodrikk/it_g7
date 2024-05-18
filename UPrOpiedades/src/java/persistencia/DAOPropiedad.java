/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelos.HibernateUtil;
import modelos.Propiedades;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author santi
 */
public class DAOPropiedad {

    Session session = null;

    //Create
    public void registrarPropiedad(Propiedades p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }

    
     //Read
    public Propiedades obtenerPropiedad(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Propiedades WHERE id=" + id;
        Query query = session.createQuery(sql);
        Propiedades propiedad = (Propiedades) query.uniqueResult();
        tx.commit();
        return propiedad;
    }
    
    
    //Update
    public void actualizarPropiedades(int superficie, int numeroHabitaciones, int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Propiedades Where id = '" + id + "'");
        Propiedades propiedad = (Propiedades) query.uniqueResult();
        propiedad.setSuperficie(superficie);
        propiedad.setNumeroHabitaciones(numeroHabitaciones);
        session.update(propiedad);
        transaction.commit();
    }

    
    //Delete
    public void eliminarPropiedad(Propiedades p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }


    public List<Propiedades> listaPropiedades() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Usuarios";
        Query query = session.createQuery(sql);
        List<Propiedades> list = (List<Propiedades>) query.list();
        tx.commit();
        return list;
    }
    
}

