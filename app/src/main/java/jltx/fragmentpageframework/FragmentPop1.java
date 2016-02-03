package jltx.fragmentpageframework;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.jltx.fragmentpageframework.BackHandledFragment;
import cn.jltx.fragmentpageframework.CustomAnimFrameLayout;


/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年01月29日.
 */
public class FragmentPop1 extends BackHandledFragment {

    private final String TAG = FragmentPop1.class.getSimpleName();


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CustomAnimFrameLayout customAnimFrameLayout = new CustomAnimFrameLayout(getActivity());
        return inflater.inflate(R.layout.fragment_pop1, customAnimFrameLayout, true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        assignViews(view);
        btnPush.setOnClickListener(myOnClickListener);
        btnPop.setOnClickListener(myOnClickListener);
        super.onViewCreated(view, savedInstanceState);
    }

    private Button btnPop;
    private Button btnPush;

    private void assignViews(View view) {
        btnPop = (Button) view.findViewById(R.id.btn_pop);
        btnPush = (Button) view.findViewById(R.id.btn_push);
    }

    private View.OnClickListener myOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_pop:
                    if(mFragmentHandledInterface != null){
//                        fragmentPageActivity.popBackStack();
                        getActivity().onBackPressed();
                    }
                    break;
                case R.id.btn_push:
                    FragmentPop2 fragmentPop2 = new FragmentPop2();
                    popNextFragment(fragmentPop2);
                    break;
                default:
                    break;
            }
        }
    };

    public void popNextFragment(Fragment fragment){
        if(mFragmentHandledInterface != null){
            mFragmentHandledInterface.popFragmentPageToFrameWork(R.id.fragment_cotainer,this,fragment, R.animator.slide_fragment_vertical_down_in,R.animator.slide_fragment_vertical_up_out,R.animator.slide_fragment_vertical_up_in, R.animator.slide_fragment_vertical_down_out, true);
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
