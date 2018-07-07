package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.List;

import wartee.tunlinaung.xyz.persistance.typeconverters.RestaurantsImagesTypeConvertor;

@Entity(tableName = "restaurant")
@TypeConverters(RestaurantsImagesTypeConvertor.class)
public class RestaurantVO {


    /**
     * shopId : MS001
     * name : YKKO
     * address : အမှတြ၃၆၊မှညေီထပြ၊ဝါးတနြးလမြး
     * lat : 123.45
     * lng : 234.56
     * township : အလုံမှို့နယြ
     * popularity : 123.45
     * shopImages : ["https://2vfinx3dr03gflz3227fpf2152k-wpengine.netdna-ssl.com/wp-content/uploads/2013/10/0073.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYfgnXWHo9ZheAEAEQ38BzxkdUFC9lrMAVqdgAMcWbORjdL-pH"]
     * reviews : [{"reviewId":"RV001","review":"အရမြးကောငြးတယြ","userId":"US001","userName":"မောငမြောငြ","userImage":"https://maxcdn.icons8.com/Share/icon/Users//user_male_circle_filled1600.png","timestamp":"20:00"},{"reviewId":"bcd","review":"abc","userId":"abc","userName":"abc","userImage":"abc","timestamp":"abc"}]
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "shop_id")
    private String shopId;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private String township;
    private double popularity;

    @ColumnInfo(name = "shop_images")
    private List<String> shopImages;

    @Ignore
    private List<ReviewsVO> reviews;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public void setShopImages(List<String> shopImages) {
        this.shopImages = shopImages;
    }

    public List<ReviewsVO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsVO> reviews) {
        this.reviews = reviews;
    }
}
