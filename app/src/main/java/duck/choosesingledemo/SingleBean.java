package duck.choosesingledemo;

/**
 * ====================================================
 * 作    者：DUCK
 * 版    本：
 * 创建日期：2018/1/15 - 12:38
 * 描    述：
 * 修订历史：
 * ====================================================
 */

public final class SingleBean {

    private String item;
    private boolean isCheck;

    public SingleBean(String item) {
        this.item = item;
    }

    public SingleBean() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
