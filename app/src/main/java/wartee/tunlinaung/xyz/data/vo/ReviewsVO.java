package wartee.tunlinaung.xyz.data.vo;

class ReviewsVO {
    /**
     * reviewId : RV001
     * review : အရမြးကောငြးတယြ
     * userId : US001
     * userName : မောငမြောငြ
     * userImage : https://maxcdn.icons8.com/Share/icon/Users//user_male_circle_filled1600.png
     * timestamp : 20:00
     */

    private String reviewId;
    private String review;
    private String userId;
    private String userName;
    private String userImage;
    private String timestamp;

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
}
