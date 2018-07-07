package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "suited_for")
public class SuitedForVO {
    /**
     * suitedForId : SF001
     * suitedFor : အဆာပြေသောက်ရန်သင့်တော်
     * suitedForDesc : abc
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "suited_for_id")
    private String suitedForId;
    @ColumnInfo(name = "suited_for")
    private String suitedFor;
    @ColumnInfo(name = "suited_desc")
    private String suitedForDesc;
    @ColumnInfo(name = "foodId")
    private transient String foodId;

    public String getSuitedForId() {
        return suitedForId;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
