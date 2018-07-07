package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.MealShopVO;
import wartee.tunlinaung.xyz.data.vo.ReviewsVO;

@Dao
public interface ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertReview(ReviewsVO... reviewsVOs);

    @Query("SELECT * FROM review")
    List<ReviewsVO> getAllReviews();

    @Query("SELECT * FROM review WHERE review_id= :reviewId")
    ReviewsVO getReviewById(String reviewId);

    @Query("SELECT * FROM review WHERE review_id= :reviewId")
    LiveData<ReviewsVO> getReviewByIdLD(String reviewId);

}
