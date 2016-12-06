/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.controllers;

import co.mpc.backend.persistence.model.entities.Revision;
import co.mpc.backend.persistence.model.facades.RevisionFacadeLocal;
import co.mpc.frontend.controllers.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Juank
 */
@Named(value = "revisionManagedBean")
@SessionScoped
public class RevisionManagedBean implements Serializable, IManagedBean<Revision> {

    private Revision revision;
    @EJB
    private RevisionFacadeLocal revisionFL;

    public RevisionManagedBean() {
    }

    @PostConstruct
    public void init() {
        revision = new Revision();
    }

    @Override
    public Revision getObjetoByKey(Integer id) {
        return revisionFL.find(id);
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public void registrarRevision() {
        revisionFL.create(revision);
    }

    public void eliminarRevision() {
        revisionFL.remove(revision);
    }

    public List<Revision> listarRevisiones() {
        return revisionFL.findAll();
    }

}
