/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.utilities.converters;

import co.mpc.backend.persistence.model.entities.DTO;
import co.mpc.frontend.controllers.IManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Pablo Ramirez
 */
public abstract class AbstractConverte implements Converter {
    protected String nameManagedBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer k = Integer.valueOf(value);
        //OrdenManagedBean omb = context.getApplication().evaluateExpressionGet(context, "#{ordenManagedBean}", OrdenManagedBean.class);
        IManagedBean omb = (IManagedBean) context.getApplication().getELResolver().getValue(
                context.getELContext(), null, nameManagedBean);
        
        return omb.getObjetoByKey(k);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if( value instanceof DTO){
            DTO to = (DTO) value;
            return to.getPrimaryKey();
        }
        context.addMessage(null, new FacesMessage("Error al convertir el objeto TipoOrden a String"));
        return null;
    }
    
}

