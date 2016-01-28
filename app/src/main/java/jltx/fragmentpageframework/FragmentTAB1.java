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
 * A simple {@link Fragment} subclass.
 */
public class FragmentTAB1 extends Fragment {

    private final String TAG = FragmentTAB1.class.getSimpleName();

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
        return inflater.inflate(R.layout.fragment_tab1, customAnimFrameLayout, true);
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
//                    Toast.makeText(getActivity(),"上一页",Toast.LENGTH_SHORT).show();
                    if(fragmentPageActivity != null){
                        fragmentPageActivity.popBackStack();
                    }
                    break;
                case R.id.btn_push:
//                    Toast.makeText(getActivity(),"下一页",Toast.LENGTH_SHORT).show();
                    if(fragmentPageActivity != null){
                        FragmentTAB2 fragmentTAB2 = new FragmentTAB2();
                       int stackId =  fragmentPageActivity.addFragmentPageToFrameWork(fragmentTAB2,R.animator.slide_fragment_horizontal_right_in,R.animator.slide_fragment_horizontal_left_out,R.animator.slide_fragment_horizontal_left_in,R.animator.slide_fragment_horizontal_right_out,true);
                        Log.d(TAG,"fragment3.stackId=>"+stackId);

                    }
                    break;
                default:
                    break;
            }
        }
    };

}
