package service;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("navigationBean")
@RequestScoped
public class NavigationBean {

    public String goToContatos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("contatos.xhtml");
            FacesContext.getCurrentInstance().responseComplete(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}