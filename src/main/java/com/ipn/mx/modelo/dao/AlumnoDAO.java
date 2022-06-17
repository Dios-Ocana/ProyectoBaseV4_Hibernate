/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Alumno;
import com.ipn.mx.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author escom
 */
public class AlumnoDAO {
    
    public void create(Alumno a) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        // Transaction transaction = session.beginTransaction();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            // session.save(a);
            session.persist(a);
            // session.merge(a); -> modificar
            // session.remove(a); -> eliminar
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    
    public List readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();
        try {
            transaction.begin();
            // a = (Alumno) session.get(Alumno.class, a.getID()); buscar uno solo
            Query q = session.createQuery("from Alumno", Alumno.class);
            resultados = q.list();
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return resultados;
    }
    
    public Alumno read(Alumno a) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            a = (Alumno) session.get(a.getClass(), a.getId()); // buscar uno solo
            transaction.commit();
        } catch(HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        AlumnoDAO dao = new AlumnoDAO();
        Alumno a = new Alumno();
        a.setId(10);
        System.out.println(dao.read(a));
        // System.out.println(dao.readAll());
    }
    
}
