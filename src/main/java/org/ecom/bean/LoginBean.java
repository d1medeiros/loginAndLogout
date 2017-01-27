package org.ecom.bean;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.ecom.dao.UsuarioDao;
import org.ecom.modelo.Usuario;

@Model
public class LoginBean {

	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;
	@Inject
	FacesContext contexto;
	
	
	public String loga() {
		

		boolean existe = dao.buscaUsuario(this.usuario);
		
		if(existe){
			contexto.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "index?faces-redirect-true";
		}
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		
		contexto.getExternalContext().getSessionMap().remove("usuarioLogado");
		
		return "login?faces-redirect=true";
		
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
