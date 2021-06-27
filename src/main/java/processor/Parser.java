package processor;

import org.json.JSONObject;

import jframe.ControllerJframe;
import model.BinanceRequestDto;
import model.marketResponseDTO.MarketResponse;
import org.apache.log4j.Logger;
import utils.jsonUtils.JsonUtils;
import utils.requestUtils.RequestUtils;

import java.util.Date;

public class Parser {

    static final Logger logger = Logger.getLogger(Parser.class);

    ControllerJframe jframe;

    public Parser(ControllerJframe jframe) {
        this.jframe = jframe;
    }

    public MarketResponse parse(BinanceRequestDto binanceRequestDto) throws InterruptedException {
        MarketResponse marketResponse = new MarketResponse();
        Date date = new Date();
        String time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        try {
            String s = RequestUtils.postRequest(binanceRequestDto.getUrl(), binanceRequestDto.getBody(), binanceRequestDto.getHeaders());
            marketResponse = (MarketResponse) JsonUtils.jsonToObject(s, MarketResponse.class);
        } catch (Exception e) {
            String sLog = e.getMessage();
            logger.info(sLog);
            jframe.updateTextArea(sLog);
            //System.out.println(e.getMessage());
        }
        return marketResponse;
    }

    public String buyNft(BinanceRequestDto binanceRequestDto) throws InterruptedException {
        String productId = "productId:" + new JSONObject(binanceRequestDto.getBody()).get("productId") + ";";
        String result = "";
        Date date = new Date();
        //String time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        try {
            result = RequestUtils.postRequest(binanceRequestDto.getUrl(), binanceRequestDto.getBody(), binanceRequestDto.getHeaders());
            String requestId = (String) new JSONObject(result).getJSONObject("data").get("requestId");
            result = result + "\n" + RequestUtils.postRequest("https://www.binance.com/bapi/nft/v1/private/nft/nft-trade/order-query", "{\"orderNo\":\"" + requestId + "\",\"tradeType\":1}", binanceRequestDto.getHeaders());
        } catch (Exception e) {
            String sLog = e.getMessage();
            logger.info(sLog);
            jframe.updateTextArea(sLog);
            System.out.println(sLog);
        }
        return productId + result ;
    }
}
