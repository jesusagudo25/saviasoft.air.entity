package ec.com.saviasoft.air.entity.data;

import ec.com.saviasoft.air.entity.model.pojo.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemConfigRepository extends JpaRepository<SystemConfig, Integer> {

    Optional<SystemConfig> findByUserId(Integer userId);
}
