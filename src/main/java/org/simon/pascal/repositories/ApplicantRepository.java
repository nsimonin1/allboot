package org.simon.pascal.repositories;

import org.simon.pascal.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long>{

}
