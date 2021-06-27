import processor.MyController;
import utils.requestUtils.RequestUtils;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        MyController controller = new MyController();
        controller.doAction();
        //binanceExample();
    }

    public static void binanceExample() throws Exception {
        String s = "GET /bapi/accounts/v1/private/country/disable/timeleft HTTP/1.1\n" +
                "Host: accounts.binance.com\n" +
                "Connection: keep-alive\n" +
                "x-trace-id: ffe63280-9c8c-4507-8a6f-1c78199d3387\n" +
                "csrftoken: 282baa915f089f8522b9df650393b62c\n" +
                "x-ui-request-trace: ffe63280-9c8c-4507-8a6f-1c78199d3387\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.216 YaBrowser/21.5.4.607 Yowser/2.5 Safari/537.36\n" +
                "content-type: application/json\n" +
                "lang: ru\n" +
                "fvideo-id: 31b7b8633a09af36878ff3bdebaa2f53a928a7a1\n" +
                "sec-ch-ua-mobile: ?0\n" +
                "device-info: eyJzY3JlZW5fcmVzb2x1dGlvbiI6IjE5MjAsMTA4MCIsImF2YWlsYWJsZV9zY3JlZW5fcmVzb2x1dGlvbiI6IjE5MjAsMTA0MCIsInN5c3RlbV92ZXJzaW9uIjoiV2luZG93cyAxMCIsImJyYW5kX21vZGVsIjoidW5rbm93biIsInN5c3RlbV9sYW5nIjoicnUiLCJ0aW1lem9uZSI6IkdNVCszIiwidGltZXpvbmVPZmZzZXQiOi0xODAsInVzZXJfYWdlbnQiOiJNb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXaW42NDsgeDY0KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvOTAuMC40NDMwLjIxNiBZYUJyb3dzZXIvMjEuNS40LjYwNyBZb3dzZXIvMi41IFNhZmFyaS81MzcuMzYiLCJsaXN0X3BsdWdpbiI6IkJvb2tSZWFkZXIsQ2hyb21pdW0gUERGIFBsdWdpbixDaHJvbWl1bSBQREYgVmlld2VyLE5hdGl2ZSBDbGllbnQiLCJjYW52YXNfY29kZSI6IjAzMzI5ZTliIiwid2ViZ2xfdmVuZG9yIjoiR29vZ2xlIEluYy4gKE5WSURJQSkiLCJ3ZWJnbF9yZW5kZXJlciI6IkFOR0xFIChOVklESUEsIE5WSURJQSBHZUZvcmNlIEdUWCAxMDUwIFRpIERpcmVjdDNEMTEgdnNfNV8wIHBzXzVfMCwgRDNEMTEtMjcuMjEuMTQuNTY3MSkiLCJhdWRpbyI6IjEyNC4wNDM0NzUyNzUxNjA3NCIsInBsYXRmb3JtIjoiV2luMzIiLCJ3ZWJfdGltZXpvbmUiOiJFdXJvcGUvTW9zY293IiwiZGV2aWNlX25hbWUiOiJZYW5kZXggVjIxLjUuNC42MDcgKFdpbmRvd3MpIiwiZmluZ2VycHJpbnQiOiI5MjM0YWIzODU4YzFiMTZiYjg4ODZjMGIzYjU5NzRkOSIsImRldmljZV9pZCI6IiIsInJlbGF0ZWRfZGV2aWNlX2lkcyI6IjE2MjQ3NDMwOTQxMTNwb3B3MG56ODBrMHNOd1UwZUswLDE2MjI4NzYxODM4OTQzNEJweXZtOG45c21yVU10QkRCIn0=\n" +
                "bnc-uuid: 2ee26c73-1633-43c6-b75d-deda6396239a\n" +
                "clienttype: web\n" +
                "sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"90\", \"Yandex\";v=\"90\"\n" +
                "Accept: */*\n" +
                "Sec-Fetch-Site: same-origin\n" +
                "Sec-Fetch-Mode: cors\n" +
                "Sec-Fetch-Dest: empty\n" +
                "Referer: https://accounts.binance.com/ru/2fa?return_to=aHR0cHM6Ly93d3cuYmluYW5jZS5jb20vcnUvbmZ0L21hcmtldA%3D%3D\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: ru,en;q=0.9\n" +
                "Cookie: cid=fr3xmtcy; _ga=GA1.2.776002785.1621525789; bnc-uuid=2ee26c73-1633-43c6-b75d-deda6396239a; source=organic; campaign=yandex.ru; fiat-prefer-currency=RUB; __ssid=1abb64632858efc2a38f176a0fa416a; rskxRunCookie=0; rCookie=sx3u8bj8ipeb0otr7xh5l5kox2rd9x; fiat-user-save-currency=RUB; lastRskxRun=1621530019444; defaultMarketTab=favorite; userPreferredCurrency=RUB_USD; _hjid=9edc1f89-3647-45be-8d84-c09eca777636; _gid=GA1.2.1045944964.1624261260; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22119753020%22%2C%22first_id%22%3A%221798a7808c214e-075a7f4fcbfc6c-5a5b3109-1327104-1798a7808c358b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%221798a7808c214e-075a7f4fcbfc6c-5a5b3109-1327104-1798a7808c358b%22%7D; BNC_FV_KEY=31b7b8633a09af36878ff3bdebaa2f53a928a7a1; BNC_FV_KEY_EXPIRE=1624810955751; gtId=e7eff527-ef49-4531-9cad-9fa4c8c46d01; s9r1=8052EAD494E5D097FBCC26565F4C9F78; lang=ru; _gat=1; cr00=228B3C2AB4D3B8B9C524885F277F86FC; d1og=web.119753020.7D8FBC8A3D2C5DDD42B15CA06554FE63; r2o1=web.119753020.2283C451B001E7355743FEAB87ECC130; f30l=web.119753020.5292F5C8165B6EA776CEBD6BFF17A33A; p20t=web.119753020.072E8B1BFB00D19F28A7F8AEFA6EB317; logined=y; isAccountsLoggedIn=y; __BINANCE_USER_DEVICE_ID__={\"5d358bd708a8d83ea452c51a9dcd9590\":{\"date\":1624743095289,\"value\":\"1624743094113popw0nz80k0sNwU0eK0\"},\"b1ad947f8ca1e940bc52e9fc05e73637\":{\"date\":1622876184875,\"value\":\"162287618389434Bpyvm8n9smrUMtBDB\"}}";

        String[] headersArray = s.split("\n");
        HashMap<String, String> headers = new HashMap();
        for (String header : headersArray) {
            String[] myHeader = header.split(":");
            if (myHeader.length > 1 && !"Accept-Encoding".equalsIgnoreCase(myHeader[0])) {
                headers.put(myHeader[0].trim(), Arrays.stream(myHeader).skip(1).reduce((x, y) -> x + y).get().trim());
            }
        }
        //System.out.println(headers);
        String body = "{number:1,productId:104379318385265664}";
        String response = RequestUtils.postRequest("https://www.binance.com/bapi/nft/v1/private/nft/mystery-box/purchase", body, headers);
        System.out.println(response);
    }
}
