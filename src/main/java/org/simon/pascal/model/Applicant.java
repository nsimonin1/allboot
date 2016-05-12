package org.simon.pascal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Data
@Entity
@NoArgsConstructor
public class Applicant {
	@Id
	@GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;
    
    public Applicant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
