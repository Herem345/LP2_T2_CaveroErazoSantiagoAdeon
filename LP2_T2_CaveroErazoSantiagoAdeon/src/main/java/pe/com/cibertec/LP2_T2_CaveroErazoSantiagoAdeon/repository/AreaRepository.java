package pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.model.entity.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {
}
