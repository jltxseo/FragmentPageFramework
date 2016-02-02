package cn.jltx.fragmentpageframework;

import android.app.Fragment;
import android.os.Bundle;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年02月02日.
 */

public abstract class BackHandledFragment extends Fragment{
    protected BackHandledInterface mBackHandledInterface;
    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     * Activity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件
     * 如果没有Fragment消息时Activity自己才会消费该事件
     */
    public abstract boolean onBackPressed();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(getActivity() instanceof BackHandledInterface)){
            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
        }else{
            this.mBackHandledInterface = (BackHandledInterface)getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //告诉Activity，当前Fragment在栈顶
        mBackHandledInterface.setSelectedFragment(this);
    }
}
