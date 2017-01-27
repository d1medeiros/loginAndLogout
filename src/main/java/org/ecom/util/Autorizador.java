package org.ecom.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.ecom.modelo.Usuario;

public class Autorizador implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent evento) {
		
		FacesContext contexto = evento.getFacesContext();
		String viewId = contexto.getViewRoot().getViewId();
		
		if("/login.xhtml".equals(viewId)){
			return;
		}
		
		Usuario usuario = (Usuario) contexto.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(usuario != null){
			return;
		}
		
		contexto.getApplication()
			.getNavigationHandler()
			.handleNavigation(contexto, null, "/login?faces-redirect=true");
		
		contexto.renderResponse();
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
