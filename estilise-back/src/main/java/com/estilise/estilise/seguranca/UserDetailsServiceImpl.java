package com.estilise.estilise.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estilise.estilise.model.modelUsuario;
import com.estilise.estilise.repository.UsuarioRepository;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<modelUsuario> user = userRepository.findByEmailusuario(userEmail);
		user.orElseThrow(()-> new UsernameNotFoundException(userEmail + " not found."));
		return user.map(DetailsImpl::new).get();
	}
}
