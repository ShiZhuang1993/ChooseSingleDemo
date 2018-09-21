package duck.choosesingledemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * ====================================================
 * 作    者：DUCK
 * 版    本：
 * 创建日期：2018/1/15 - 12:37
 * 描    述：选择适配器
 * 修订历史：
 * ====================================================
 */

public final class SingleAdapter extends RecyclerView.Adapter<SingleViewHolder> {

    private ArrayList<SingleBean> list;
    private Activity context;

    public void destory() {
        if (list != null) {
            list.clear();
            list = null;
        }
        context = null;
    }

    public SingleAdapter(ArrayList<SingleBean> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SingleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_select, null);
        final SingleViewHolder viewHolder = new SingleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SingleViewHolder holder, final int position) {

        final SingleBean sb = list.get(position);
        holder.setData(sb);
        //一个
        holder.getCb().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleManager.getInstance().checkOne(position);
            }
        });
        //多个
        holder.getCb().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleManager.getInstance().checkMulti(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
