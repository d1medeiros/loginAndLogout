package org.ecom.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.ecom.modelo.Usuario;


public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager em;

	public boolean buscaUsuario(Usuario usuario) {
		String nome = usuario.getNome();
		String senha = usuario.getSenha();
		
//		String nome = "diego";
//		String senha = "1234";
		
		Query query = em.createNamedQuery("findX")
			.setParameter("pNome", nome)
			.setParameter("pSenha", senha);
		
		
		try {
			Usuario u = (Usuario) query.getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}
		 
		 return true;
	}
	
	
	
	
}
