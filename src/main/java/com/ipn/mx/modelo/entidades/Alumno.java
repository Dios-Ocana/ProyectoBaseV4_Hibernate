/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author escom
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombreAlumno", length = 50, nullable = false)
    private String nombreAlumno;

    @Column(name = "paternoAlumno", length = 50, nullable = false)
    private String paternoAlumno;

    @Column(name = "maternoAlumno", length = 50, nullable = false)
    private String maternoAlumno;

    @Column(name = "emailAlumno", length = 100, nullable = false)
    private String emailAlumno;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    public static void main(String[] args) {
        Alumno a = new Alumno();
        a.setNombreAlumno("yo");
        a.setPaternoAlumno("ya");
        a.setMaternoAlumno("yi");
        a.setEmailAlumno("mail@mail.com");
        a.setFechaCreacion(new Date());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoBase_V5PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
}
