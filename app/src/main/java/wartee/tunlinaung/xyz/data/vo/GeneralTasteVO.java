package wartee.tunlinaung.xyz.data.vo;

class GeneralTasteVO {
    /**
     * tasteId : T001
     * taste : ပုံမှန် ကျဆိမ့် ချိုဆိမ့်
     * tasteDesc : မနက်စာအဖြစ် သောက်လေ့ရှိသောအရည်တမျိုး  အီကြာကွေးနှင့် တွဲစားခြင်းသည် အလိုက်ဖက်ဆုံးဖြစ်သည်
     */

    private String tasteId;
    private String taste;
    private String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }

    public void setTasteDesc(String tasteDesc) {
        this.tasteDesc = tasteDesc;
    }
}
