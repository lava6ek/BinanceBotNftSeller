package processor;

import jframe.ControllerJframe;
import model.BinanceRequestDto;
import model.Rtype;
import model.marketResponseDTO.MarketResponse;
import model.marketResponseDTO.Row;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MyController {

    static final Logger logger = Logger.getLogger(MyController.class);

    HashMap<String, Integer> ignoreMap = new HashMap<>();

    public void doAction() throws IOException, InterruptedException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("application.properties"));

        long tradeType = Long.parseLong(properties.getProperty("tradeType"));
        String title = properties.getProperty("title");
        String productListUrl = properties.getProperty("productListUrl");
        String buyNftUrl = properties.getProperty("buyNftUrl");
        String parseBody = properties.getProperty("parseBody");
        final String buyBodyPattern = "{\"amount\":\"{amount}\",\"productId\":\"{id}\",\"tradeType\":0}";
        Double minBusdPrice = Double.parseDouble(properties.getProperty("minBusdPrice"));
        Double minBnbPrice = Double.parseDouble(properties.getProperty("minBnbPrice"));

        BinanceRequestDto binanceRequestDto = binanceDtoBuilder(productListUrl, parseBody);
        ControllerJframe jframe = new ControllerJframe();
        Parser parser = new Parser(jframe);

        while (true) {
            if (!jframe.isPause()) {
                MarketResponse response = parser.parse(binanceRequestDto);
                if (response.getData() != null) {
                    List<Row> rows = Arrays.stream(response.getData().getRows())
                            .filter(x -> title.equalsIgnoreCase(x.getTitle()) && x.getTradeType() == tradeType)
                            .collect(Collectors.toList());
                    //log
                    Date date = new Date();
                    String time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
                    String sForLog = (rows.stream().map(x -> x.getTitle() + " : " + x.getAmount() + " " + x.getCurrency()).reduce("refreshing(" + time + "):", (x, y) -> x + "\n" + y));
                    logger.info(sForLog);
                    jframe.setTextArea(sForLog);
                    //end log
                    for (Row row : rows) {
                        Double currentPrice = Double.parseDouble(row.getAmount());
                        String productId = row.getProductID();
                        //Проверяем что не куплен и еще не пробовали купить
                        if (row.getStatus() == 1 && !ignoreMap.containsKey(productId) && ignoreMap.getOrDefault(productId, 1) < 3) {
                            //Проверяем цены
                            if (("BUSD".equalsIgnoreCase(row.getCurrency()) && currentPrice <= minBusdPrice) ||
                                    ("BNB".equalsIgnoreCase(row.getCurrency()) && currentPrice <= minBnbPrice)) {
                                ignoreMap.put(productId, ignoreMap.getOrDefault(productId + 1, 1));
                                jframe.updateTextArea("trying to buy " + row.getTitle() + " : " + row.getAmount());
                                String buyBody = buyBodyPattern.replace("{amount}", row.getAmount()).replace("{id}", row.getProductID());
                                BinanceRequestDto binanceRequestBuy = binanceDtoBuilder(buyNftUrl, buyBody);
                                String result = parser.buyNft(binanceRequestBuy);
                                logger.info(result);
                                jframe.updateTextArea(result);
                                System.out.println(result);
                            }
                        }
                    }
                }
                Thread.sleep(10);
            } else {
                Thread.sleep(100);
            }
        }
    }

    public String buyNft(long productId) {

        return "";
    }

    public BinanceRequestDto binanceDtoBuilder(String url, String buyBody) throws IOException {
        BinanceRequestDto binanceRequestDto = new BinanceRequestDto();
        //set url
        binanceRequestDto.setUrl(url);
        //set type request
        binanceRequestDto.setRequestType(Rtype.POST);
        //set headers
        List<String> headersList = Files.readAllLines(Paths.get("headers.txt"));
        HashMap<String, String> headers = new HashMap();
        for (String header : headersList) {
            String[] myHeader = header.split(":");
            if (myHeader.length > 1 && !"Accept-Encoding".equalsIgnoreCase(myHeader[0])) {
                headers.put(myHeader[0].trim(), Arrays.stream(myHeader).skip(1).reduce((x, y) -> x + y).get().trim());
            }
        }
        binanceRequestDto.setHeaders(headers);
        //set body
        binanceRequestDto.setBody(buyBody);
        return binanceRequestDto;
    }
}
