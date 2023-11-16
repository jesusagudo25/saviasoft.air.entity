package ec.com.saviasoft.air.entity.data;

import ec.com.saviasoft.air.entity.model.pojo.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Optional<Device> findBySerialNumber(String serialNumber);
}
