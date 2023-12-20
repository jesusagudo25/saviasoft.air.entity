package ec.com.saviasoft.air.entity.data;

import ec.com.saviasoft.air.entity.model.pojo.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Device findByUid(String uid);

    List<Device> findByUserId(Integer user);
}
