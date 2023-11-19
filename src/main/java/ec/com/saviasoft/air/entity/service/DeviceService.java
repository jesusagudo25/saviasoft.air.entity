package ec.com.saviasoft.air.entity.service;

import ec.com.saviasoft.air.entity.data.DeviceRepository;
import ec.com.saviasoft.air.entity.model.pojo.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository repository;

    public Device findByUid(String uid) {
        try {
            return repository.findByUid(uid);
        } catch (Exception e) {
            return null;
        }
    }
}
