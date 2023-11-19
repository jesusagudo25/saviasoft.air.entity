package ec.com.saviasoft.air.entity.controller;

import ec.com.saviasoft.air.entity.model.pojo.Device;
import ec.com.saviasoft.air.entity.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService service;

    @GetMapping("/byUid/{uid}")
    public ResponseEntity<Device> getDevice(@PathVariable String uid) {
        return ResponseEntity.ok(service.findByUid(uid));
    }
}
