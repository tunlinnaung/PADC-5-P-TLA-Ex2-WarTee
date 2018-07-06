package wartee.tunlinaung.xyz.network.responses;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.RestaurantVO;

public class RestaurantResponse {

    private int code;
    private String message;
    private String apiVersion;
    private List<RestaurantVO> astlMealShop;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<RestaurantVO> getAstlMealShop() {
        return astlMealShop;
    }
}
