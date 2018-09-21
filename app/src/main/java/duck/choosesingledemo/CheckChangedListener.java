package duck.choosesingledemo;

/**
 * ====================================================
 * 作    者：DUCK
 * 版    本：
 * 创建日期：2018/1/15 - 12:59
 * 描    述：条目状态改变监听
 * 修订历史：
 * ====================================================
 */

public interface CheckChangedListener {

    void ItemChanged(int position, int index, SingleBean bean);

}
