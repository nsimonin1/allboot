package org.simon.pascal.repositories;

import java.util.Optional;

import org.simon.pascal.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	Optional<Utilisateur> findOneByUsername(String login);

}
