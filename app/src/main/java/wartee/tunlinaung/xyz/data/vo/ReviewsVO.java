package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "review")
public class ReviewsVO {
    /**
     * reviewId : RV001
     * review : အရမြးကောငြးတယြ
     * userId : US001
     * userName : မောငမြောငြ
     * userImage : https://maxcdn.icons8.com/Share/icon/Users//user_male_circle_filled1600.png
     * timestamp : 20:00
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "review_id")
    private String reviewId;
    private String review;
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_image")
    private String userImage;
    @ColumnInfo(name = "time_stamp")
    private String timestamp;
    @ColumnInfo(name = "restaurant_id")
    private transient String restaurantId;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
