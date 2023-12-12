package ec.com.saviasoft.air.entity.service;

import ec.com.saviasoft.air.entity.data.DeviceRepository;
import ec.com.saviasoft.air.entity.model.pojo.Device;
import ec.com.saviasoft.air.entity.model.request.DeviceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public Device createDevice(DeviceRequest deviceRequest) {
        try {
            return repository.save(Device.builder()
                    .userId(deviceRequest.getUserId())
                    .name(deviceRequest.getName())
                    .serialNumber(deviceRequest.getSerialNumber())
                    .location(deviceRequest.getLocation())
                    .uid(deviceRequest.getUid())
                    .status(deviceRequest.getStatus())
                    .createdDate(new Date())
                    .updatedDate(new Date())
                    .build());
        } catch (Exception e) {
            return null;
        }
    }
}
