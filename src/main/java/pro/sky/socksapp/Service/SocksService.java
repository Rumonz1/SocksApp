package pro.sky.socksapp.Service;

import org.springframework.stereotype.Service;
import pro.sky.socksapp.Model.Socks;

@Service
public interface SocksService {

    Socks editSocks(Socks socks, long quantity);

    long getSocksByParameters(Socks.Color color, Socks.Size size, int cottonMin, int cottonMax);

    boolean deleteSocks(Socks socks, long quantity);

    Socks addSocks(Socks socks, long quantity);
}
