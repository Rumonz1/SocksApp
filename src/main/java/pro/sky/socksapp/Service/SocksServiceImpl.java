package pro.sky.socksapp.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import pro.sky.socksapp.Model.Socks;

import java.util.HashMap;
import java.util.Map;

@Service
public class SocksServiceImpl implements SocksService{
    private static Map<Socks, Long> socksMap = new HashMap<>();
    private final SocksFileService socksFileService;

    public SocksServiceImpl(SocksFileService socksFileService) {
        this.socksFileService = socksFileService;
    }
    public Socks addSocks(Socks socks, long quantity) {
        if (quantity > 0 && socks.getSocksCompound() > 0 && socks.getSocksCompound() <= 100) {
            socksMap.merge(socks, quantity, Long::sum);
            socksMap.putIfAbsent(socks, quantity);
            saveToFile();
        }
        return socks;
    }

    @Override
    public Socks editSocks(Socks socks, long quantity) {
        ObjectUtils.isNotEmpty(socksMap);
        if (quantity > 0 && socksMap.containsKey(socks)) {
            long number = socksMap.get(socks) - quantity;
            if (number >= 0) {
                socksMap.merge(socks, quantity, (a, b) -> a - b);
                socksMap.putIfAbsent(socks, quantity);
                saveToFile();
            } else {
                throw new UnsupportedOperationException("Указанный товар отсутствует");
            }
        }
        return socks;
    }

    @Override
    public long getSocksByParameters(Socks.Color color, Socks.Size size, int cottonMin, int cottonMax) {
        ObjectUtils.isNotEmpty(socksMap);
        long count = 0;
        if (cottonMin >= 0 && cottonMax >= 0 && cottonMax >= cottonMin) {
            for (Map.Entry<Socks, Long> entry : socksMap.entrySet()) {
                if (entry.getKey().getSocksColor() == color && entry.getKey().getSocksSize() == size &&
                        entry.getKey().getSocksCompound() >= cottonMin && entry.getKey().getSocksCompound() <= cottonMax) {
                    count += entry.getValue();
                }
            }
        }
        return count;
    }

    @Override
    public boolean deleteSocks(Socks socks, long quantity) {
        ObjectUtils.isNotEmpty(socksMap);
        if (quantity > 0 && socksMap.containsKey(socks)) {
            long number = socksMap.get(socks) - quantity;
            if (number >= 0) {
                socksMap.merge(socks, quantity, (a, b) -> a - b);
                socksMap.putIfAbsent(socks, quantity);
                saveToFile();
                return true;
            } else {
                throw new UnsupportedOperationException("Указанный товар отсутствует");
            }
        }
        return false;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(socksMap);
            socksFileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = socksFileService.readFromFile();
            socksMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Socks, Long>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
