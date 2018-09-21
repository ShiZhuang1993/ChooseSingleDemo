package duck.choosesingledemo;

import java.util.ArrayList;

/**
 * ====================================================
 * 作    者：DUCK
 * 版    本：
 * 创建日期：2018/1/15 - 12:43
 * 描    述：选择管理类
 * 修订历史：
 * ====================================================
 */

public final class SingleManager {

    private ArrayList<SingleBean> list; //数据集
    private int checkIndex = -1; //已选中的索引 -1为未选
    private static SingleManager instance = null;
    private CheckChangedListener listeners;

    private SingleManager() {
        if (instance != null) {
            throw new IllegalStateException();
        }
        list = new ArrayList<>();
    }

    public void destory() {
        if (list != null) {
            list.clear();
            list = null;
        }

        instance = null;
    }

    public static SingleManager getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new SingleManager();
        }
    }

    public void setList(ArrayList<SingleBean> list) {
        this.list = list;
    }

    public void setListeners(CheckChangedListener listeners) {
        this.listeners = listeners;
    }

    /**
     * 选择一个
     *
     * @param position 哪一个
     */
    public void checkOne(int position) {

        final SingleBean bean = list.get(position);
        final boolean check = bean.isCheck();
        if (check) {
            bean.setCheck(!check);

            if (listeners != null) {
                listeners.ItemChanged(position, checkIndex, bean);
            }

            checkIndex = -1; //没有选择任何一个
        } else {

            if (checkIndex != -1) { //如果有选择
                final SingleBean singleBean = list.get(checkIndex);
                singleBean.setCheck(check);
                bean.setCheck(!check);
            } else { //如果之前一个都没选
                bean.setCheck(!check);
            }

            if (listeners != null) {
                listeners.ItemChanged(position, checkIndex, bean);
            }

            checkIndex = position;
        }

    }
    /**
     * 选择多个
     *
     * @param position 哪一个
     */
    public void checkMulti(int position) {
        final SingleBean bean = list.get(position);
        final boolean check = bean.isCheck();
        bean.setCheck(!check);
        if (listeners != null) {
            listeners.ItemChanged(position, checkIndex, bean);
        }
    }
}
