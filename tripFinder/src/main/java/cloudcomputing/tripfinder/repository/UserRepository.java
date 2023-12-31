package cloudcomputing.tripfinder.repository;

import cloudcomputing.tripfinder.Models.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistrationData, Long> {

}
