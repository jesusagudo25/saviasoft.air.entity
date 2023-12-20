package ec.com.saviasoft.air.entity.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtil {

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
