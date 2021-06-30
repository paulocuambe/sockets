package threaded.single;

import java.util.HashMap;
import java.util.Map;

public class QuoteService {
    private Map<String, String> productInfo = new HashMap<>();

    public QuoteService() {
        this.productInfo.put("a", "100 MZN");
        this.productInfo.put("b", "200 MZN");
    }

    public String getQuote(String product) {
        return productInfo.get(product);
    }

    public Map<String, String> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Map<String, String> productInfo) {
        this.productInfo = productInfo;
    }
}
