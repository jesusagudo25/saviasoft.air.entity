package ec.com.saviasoft.air.entity.controller;

import ec.com.saviasoft.air.entity.model.pojo.Device;
import ec.com.saviasoft.air.entity.model.request.DeviceRequest;
import ec.com.saviasoft.air.entity.model.response.ErrorResponse;
import ec.com.saviasoft.air.entity.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService service;

    @GetMapping
    public ResponseEntity<List<Device>> getDevices() {
        List<Device> devices = service.getDevices();

        if (devices != null) {
            return ResponseEntity.ok(devices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byUid/{uid}")
    public ResponseEntity<?> getDevice(@PathVariable String uid) {
        Device device = service.findByUid(uid);

        if (device != null) {
            return ResponseEntity.ok(device);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(404, "El dispositivo no existe", "Error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/byUser/{user}")
    public ResponseEntity<List<Device>> getDevicesByUser(@PathVariable Integer user) {
        List<Device> devices = service.findByUser(user);

        if (devices != null) {
            return ResponseEntity.ok(devices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody DeviceRequest device) {
        return ResponseEntity.ok(service.createDevice(device));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Integer id, @RequestBody Device device) {
        return ResponseEntity.ok(service.updateDevice(id, device));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Device> setStatus(@PathVariable Integer id, @RequestBody Map<String, Boolean> payload) {
        return ResponseEntity.ok(service.setStatus(id, payload.get("status")));
    }
}
