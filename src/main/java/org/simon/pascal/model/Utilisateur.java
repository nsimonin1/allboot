package org.simon.pascal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.simon.pascal.api.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private Boolean actif;
	@Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
