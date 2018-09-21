package duck.choosesingledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    private final int ITEM_NUM = 1000; //数据数量
    private final String test = "条目";
    private SingleAdapter adapter;
    private ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_check_single);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);


        final ArrayList<SingleBean> list = new ArrayList<>(ITEM_NUM);
        for (int i = 0; i < ITEM_NUM; i++) {
            list.add(new SingleBean(test + i));
        }

        adapter = new SingleAdapter(list, this);
        rv.setAdapter(adapter);
        SingleManager.getInstance().setList(list);
        //多个
        SingleManager.getInstance().setListeners(new CheckChangedListener() {

            @Override
            public void ItemChanged(int position, int index, SingleBean bean) {

                Log.e("==========", bean.getItem());
                if (bean.isCheck()) {
                    strings.add(bean.getItem());
                }else {
                    strings.remove(position);
                }
                adapter.notifyItemChanged(position);
                Log.e("---------------", strings.size() + "" + strings.toString());

            }

        });
        //一个
        SingleManager.getInstance().setListeners(new CheckChangedListener() {

            @Override
            public void ItemChanged(int position, int index, SingleBean bean) {

                    adapter.notifyItemChanged(position);
                    adapter.notifyItemChanged(index);
                }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (adapter != null) {
            adapter.destory();
            adapter = null;
        }

        //释放数据 资源
        SingleManager.getInstance().destory();
    }
}
