package ec.com.saviasoft.air.entity.service;

import ec.com.saviasoft.air.entity.data.DeviceRepository;
import ec.com.saviasoft.air.entity.model.pojo.Device;
import ec.com.saviasoft.air.entity.model.request.DeviceRequest;
import ec.com.saviasoft.air.entity.util.UUIDUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    @Autowired
    private UUIDUtil uuidUtil;

    private final DeviceRepository repository;

    public List<Device> getDevices() {
        return repository.findAll();
    }

    public Device findByUid(String uid) {
        return repository.findByUid(uid);
    }

    public List<Device> findByUser(Integer user) {
        return repository.findByUserId(user);
    }

    public Device createDevice(DeviceRequest deviceRequest) {
        return repository.save(Device.builder()
                .userId(deviceRequest.getUserId())
                .userName(deviceRequest.getUserName())
                .name(deviceRequest.getName())
                .serialNumber(deviceRequest.getSerialNumber())
                .location(deviceRequest.getLocation())
                .uid(uuidUtil.generateUUID())
                .status(true)
                .createdDate(new Date())
                .updatedDate(new Date())
                .build());
    }

    public Device updateDevice(Integer id, Device device) {
        Device deviceToUpdate = repository.findById(id).orElse(null);
        if (deviceToUpdate != null) {
            deviceToUpdate.setName(device.getName());
            deviceToUpdate.setSerialNumber(device.getSerialNumber());
            deviceToUpdate.setLocation(device.getLocation());
            deviceToUpdate.setUpdatedDate(new Date());
            return repository.save(deviceToUpdate);
        }else {
            return null;
        }
    }

    public Device setStatus(Integer id, Boolean status) {
        Device deviceToUpdate = repository.findById(id).orElse(null);
        if(deviceToUpdate != null) {
            deviceToUpdate.setStatus(status);
            deviceToUpdate.setUpdatedDate(new Date());
            return repository.save(deviceToUpdate);
        }else {
            return null;
        }
    }
}
