package utils.proxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Нужно найти перечень прокси серверов и сохранить в файл в формате ip;port
 * Например скачать перечень http://free-proxy.cz/ru/proxylist/country/RU/https/ping/level1
 * Проверить работоспособность http://free.proxy-sale.com/proxy-checker/ (убираем медленные, иначе будут проблемы)
 *
 */
public class ProxyFactory {

    /**
     *
     * @param path - путь к файлу с проксей
     * @return
     */
    public static Queue<Proxy> getProxy(String path) {
        ConcurrentLinkedQueue<Proxy> proxyQueue = new ConcurrentLinkedQueue<>();
        proxyQueue.offer(Proxy.NO_PROXY);//добавляет 1 параметр - по умолчанию будет работать без прокси
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                proxyQueue.offer(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(line.split(";")[0]
                        , new Integer(line.split(";")[1]))));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return proxyQueue;
    }
}
