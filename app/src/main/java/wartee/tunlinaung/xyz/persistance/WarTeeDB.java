package wartee.tunlinaung.xyz.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.GeneralTasteVO;
import wartee.tunlinaung.xyz.data.vo.MatchWarDeeListVO;
import wartee.tunlinaung.xyz.data.vo.MealShopVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.data.vo.ReviewsVO;
import wartee.tunlinaung.xyz.data.vo.ShopByDistanceVO;
import wartee.tunlinaung.xyz.data.vo.ShopByPopularityVO;
import wartee.tunlinaung.xyz.data.vo.SuitedForVO;
import wartee.tunlinaung.xyz.persistance.dao.FoodDao;
import wartee.tunlinaung.xyz.persistance.dao.GeneralTasteDao;
import wartee.tunlinaung.xyz.persistance.dao.MatchWarDeeListDao;
import wartee.tunlinaung.xyz.persistance.dao.MealShopDao;
import wartee.tunlinaung.xyz.persistance.dao.RestaurantDao;
import wartee.tunlinaung.xyz.persistance.dao.ReviewsDao;
import wartee.tunlinaung.xyz.persistance.dao.ShopByDistanceDao;
import wartee.tunlinaung.xyz.persistance.dao.ShopByPopularityDao;
import wartee.tunlinaung.xyz.persistance.dao.SuitedForDao;

@Database(entities = {
        FoodVO.class, GeneralTasteVO.class, MatchWarDeeListVO.class,
        MealShopVO.class, RestaurantVO.class, ReviewsVO.class,
        ShopByDistanceVO.class, ShopByPopularityVO.class, SuitedForVO.class
}, version = 1, exportSchema = false)
public abstract class WarTeeDB extends RoomDatabase {

    private static final String DB_NAME = "WarTee.DB";
    private static WarTeeDB INSTANCE;

    public abstract FoodDao foodDao();
    public abstract GeneralTasteDao generalTasteDao();
    public abstract MatchWarDeeListDao matchWarDeeListDao();
    public abstract MealShopDao mealShopDao();
    public abstract RestaurantDao restaurantDao();
    public abstract ReviewsDao reviewsDao();
    public abstract ShopByDistanceDao shopByDistanceDao();
    public abstract ShopByPopularityDao shopByPopularityDao();
    public abstract SuitedForDao suitedForDao();

    public static WarTeeDB getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, WarTeeDB.class, DB_NAME)
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build();
        }
        return INSTANCE;
    }
}
