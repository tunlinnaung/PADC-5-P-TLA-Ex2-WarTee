package wartee.tunlinaung.xyz.network.responses;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;

public class FoodResponse {

    private int code;
    private String message;
    private String apiVersion;
    private List<FoodVO> astlWarDee;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<FoodVO> getAstlWarDee() {
        return astlWarDee;
    }
}
