/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelos.HibernateUtil;
import modelos.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author santi
 */
public class DAOUsuario {

    Session session = null;

    //Create
    public void registrarUsuario(Usuarios u) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(u);
        tx.commit();
    }

    
     //Read Usuario
    public Usuarios obtenerUsuario(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Usuarios WHERE id=" + id;
        Query query = session.createQuery(sql);
        Usuarios usuario = (Usuarios) query.uniqueResult();
        tx.commit();
        return usuario;
    }
    
    
    //Update
    public void actualizarUsuario(String nombre, String apellidos, String email, int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Bateria Where id = '" + id + "'");
        Usuarios usuario = (Usuarios) query.uniqueResult();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        session.update(usuario);
        transaction.commit();
    }

    
    //Delete
    public void eliminarUsuario(Usuarios u) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(u);
        tx.commit();
    }


    public List<Usuarios> listaUsuarios() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "From Usuarios";
        Query query = session.createQuery(sql);
        List<Usuarios> list = (List<Usuarios>) query.list();
        tx.commit();
        return list;
    }
    
}
