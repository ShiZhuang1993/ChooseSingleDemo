package duck.choosesingledemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

/**
 * ====================================================
 * 作    者：DUCK
 * 版    本：
 * 创建日期：2018/1/15 - 12:37
 * 描    述：
 * 修订历史：
 * ====================================================
 */

public final class SingleViewHolder extends RecyclerView.ViewHolder {

    private CheckBox cb;

    public SingleViewHolder(View itemView) {
        super(itemView);
        cb = (CheckBox) itemView.findViewById(R.id.cb_check);
    }

    public CheckBox getCb() {
        return cb;
    }

    public void setData(SingleBean bean) {
        final String text = bean.getItem();
        final boolean check = bean.isCheck();
        cb.setChecked(check);
        cb.setText(text);
    }
}
