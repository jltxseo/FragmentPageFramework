package jltx.fragmentpageframework;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.jltx.fragmentpageframework.CustomAnimFrameLayout;
import cn.jltx.fragmentpageframework.FragmentPageActivity;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年01月29日.
 */
public class FragmentPop2 extends Fragment {

    private final String TAG = FragmentPop2.class.getSimpleName();

    private FragmentPageActivity fragmentPageActivity;

    @Override
    public void onAttach(Activity activity) {
        if(activity instanceof FragmentPageActivity){
            try{
                this.fragmentPageActivity = (FragmentPageActivity)activity;
            }catch (ClassCastException e){
                Log.d(TAG,"onAttach.ClassCastException=>"+e.toString());
            }

        }
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CustomAnimFrameLayout customAnimFrameLayout = new CustomAnimFrameLayout(getActivity());
        return inflater.inflate(R.layout.fragment_pop2, customAnimFrameLayout, true);
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
                    if(fragmentPageActivity != null){
                        fragmentPageActivity.popBackStack();
                    }
                    break;
                case R.id.btn_push:
                    if(fragmentPageActivity != null){
                        fragmentPageActivity.closeAllFragment();
                    }
                    break;
                default:
                    break;
            }
        }
    };

}
