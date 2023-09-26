package et.gov.empProfile.repository;

import et.gov.empProfile.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobREpository extends JpaRepository<Job, Integer> {
}
