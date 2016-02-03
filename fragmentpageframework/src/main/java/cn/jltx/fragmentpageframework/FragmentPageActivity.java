package cn.jltx.fragmentpageframework;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年01月29日.
 */
public  class FragmentPageActivity extends Activity implements FragmentHandledInterface {

    //当前显示的Fragment页面
    private BackHandledFragment mBackHandedFragment;

    /**
     * 设置当前fragment，方便监听返回键
     * @param selectedFragment
     */
    @Override
    public void setSelectedFragment(BackHandledFragment selectedFragment) {
        mBackHandedFragment = selectedFragment;
    }

    /**
     *
     */
    @Override
    public void onBackPressed() {
        if(mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()){
            if(getFragmentManager().getBackStackEntryCount() == 0){
                super.onBackPressed();
            }else{
                getFragmentManager().popBackStack();
            }
        }
    }


    /**
     * 将一个frament添加到框架里面
     * @param fragmentContainerId
     * @param fragment
     * @return  返回添加成功的Fragment的ID
     */
    @Override
    public int setFirstFragmentPage(int fragmentContainerId,Fragment fragment){
        if(fragment != null && fragmentContainerId != 0){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(fragmentContainerId, fragment);
            return fragmentTransaction.commit();
        }
        return -1;
    }


    @Override
    public int addFragmentPageToFrameWork(int fragmentContainerId,Fragment fragment,int enter, int exit, int popEnter, int popExit,boolean isAddStack){
        return addFragmentPageToFrameWork(fragmentContainerId,fragment,null,enter,exit,popEnter,popExit,isAddStack);
    }

    /**
     *
     * @param fragmentContainerId
     * @param fragment
     * @param tag
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param isAddStack
     * @return
     */
    @Override
    public int addFragmentPageToFrameWork(int fragmentContainerId,Fragment fragment,String tag,int enter, int exit,
                                              int popEnter, int popExit,boolean isAddStack){
        if(fragment != null && fragmentContainerId != 0){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //自定义页面动画
            fragmentTransaction.setCustomAnimations(enter,exit,popEnter,popExit);

            //以替换的方式来切换到下一个页面
            fragmentTransaction.replace(fragmentContainerId, fragment, tag);

            if(isAddStack){
                fragmentTransaction.addToBackStack(tag);
            }

            return  fragmentTransaction.commit();
        }
        return -1;
    }

    /**
     *
     * @param fragment
     */
    @Override
    public void removeFragmentPageFromFrameWork(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     *
     * @param fragmentContainerId
     * @param to
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWorkFromTop(int fragmentContainerId,Fragment to,int enter, int exit, int popEnter, int popExit,boolean isAddStack){
        return popFragmentPageToFrameWorkFromTop(fragmentContainerId,to, null,enter,exit,popEnter,popExit,isAddStack);
    }

    /**
     *
     * @param fragmentContainerId
     * @param to
     * @param enter
     * @param exit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWorkFromTop(int fragmentContainerId,Fragment to,int enter, int exit,boolean isAddStack){
        return popFragmentPageToFrameWorkFromTop(fragmentContainerId,to, null,enter,exit,isAddStack);
    }

    /**
     *
     * @param fragmentContainerId
     * @param to
     * @param tag
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWorkFromTop( int fragmentContainerId,Fragment to,String tag,int enter, int exit, int popEnter, int popExit,boolean isAddStack){
        FragmentManager fragmentManager = getFragmentManager();
        int backStackCount = fragmentManager.getBackStackEntryCount();
        if (backStackCount > 0){
            String topName = fragmentManager.getBackStackEntryAt(backStackCount- 1).getName();
            Fragment from = fragmentManager.findFragmentByTag(topName);
            return popFragmentPageToFrameWork(fragmentContainerId,from, to, tag,enter,exit,popEnter,popExit,isAddStack);
        }
        return -1;
    }

    /**
     *
     * @param fragmentContainerId
     * @param to
     * @param tag
     * @param enter
     * @param exit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWorkFromTop(int fragmentContainerId,Fragment to,String tag,int enter, int exit,boolean isAddStack){
        FragmentManager fragmentManager = getFragmentManager();
        int backStackCount = fragmentManager.getBackStackEntryCount();
        if (backStackCount > 0){
            String topName = fragmentManager.getBackStackEntryAt(backStackCount- 1).getName();
            Fragment from = fragmentManager.findFragmentByTag(topName);
            return popFragmentPageToFrameWork(fragmentContainerId,from, to, tag,enter,exit,isAddStack);
        }
        return -1;
    }

    /**
     *
     * @param fragmentContainerId
     * @param from
     * @param to
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWork( int fragmentContainerId, Fragment from,Fragment to,int enter, int exit, int popEnter, int popExit,boolean isAddStack){
        return popFragmentPageToFrameWork(fragmentContainerId,from, to, null,enter,exit,popEnter,popExit,isAddStack);
    }

    /**
     *
     * @param fragmentContainerId
     * @param from
     * @param to
     * @param enter
     * @param exit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWork( int fragmentContainerId ,Fragment from,Fragment to,int enter, int exit, boolean isAddStack){
        return popFragmentPageToFrameWork(fragmentContainerId,from, to, null,enter,exit,isAddStack);
    }

    /**
     *
     * @param fragmentContainerId
     * @param from
     * @param to
     * @param tag
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWork(int fragmentContainerId,Fragment from,Fragment to,String tag,int enter, int exit, int popEnter, int popExit,boolean isAddStack){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(to != null && fragmentContainerId != 0){
            if(!to.isAdded()){
                fragmentTransaction.setCustomAnimations(enter,exit,popEnter,popExit);
                if (from != null){
                    fragmentTransaction.hide(from);
                }
                fragmentTransaction.add(fragmentContainerId, to);
                fragmentTransaction.addToBackStack(tag);
                return fragmentTransaction.commit();
            }else{
                if(from != null){
                    fragmentTransaction.hide(from);
                }
                fragmentTransaction.show(to);
                return fragmentTransaction.commit();
            }
        }
        return -1;
    }

    /**
     *
     * @param fragmentContainerId
     * @param from
     * @param to
     * @param tag
     * @param enter
     * @param exit
     * @param isAddStack
     * @return
     */
    @Override
    public int popFragmentPageToFrameWork(int fragmentContainerId ,Fragment from,Fragment to,String tag,int enter, int exit, boolean isAddStack){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(to != null && fragmentContainerId != 0){
            if(!to.isAdded()){
                fragmentTransaction.setCustomAnimations(enter,exit);
                if (from != null){
                    fragmentTransaction.hide(from);
                }
                fragmentTransaction.add(fragmentContainerId, to);
                fragmentTransaction.addToBackStack(tag);
                return fragmentTransaction.commit();
            }else{
                if(from != null){
                    fragmentTransaction.hide(from);
                }
                fragmentTransaction.show(to);
                return fragmentTransaction.commit();
            }
        }
        return -1;
    }

    /**
     * 强制回退到上一个页面，该回退时间压到FragmentManager操作队列里
     * 使用popBackStack()来弹出栈内容的话，调用该方法后会将事物操作插入到FragmentManager的操作队列，只有当轮询到该事物时才能执行。
     */
    @Override
    public void popBackStack(){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }

    /**
     * 直接回退到指定的Fragment页面，其它之前在name的Fragment页面顶部的Fragment都将被删除
     * @param name 指定的Fragment的唯一名称
     * @param flags 如果 FragmentManager.POP_BACK_STACK_INCLUSIVE则一起删除指定Fragment页面
     */
    @Override
    public void popBackStack(String name, int flags){
        FragmentManager fragmentManager = getFragmentManager();
        if(name != null){
            if(flags == FragmentManager.POP_BACK_STACK_INCLUSIVE){
                fragmentManager.popBackStack(name,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }else {
                fragmentManager.popBackStack(name,0);
            }
        }
    }

    /**
     * 直接回退到指定ID的Fragment页面，其它之前在name的Fragment页面顶部的Fragment都将被删除
     * @param id 指定的Fragment的唯一名称
     * @param flags 如果 FragmentManager.POP_BACK_STACK_INCLUSIVE则一起删除指定Fragment页面
     */
    @Override
    public  void popBackStack(int id, int flags){
        FragmentManager fragmentManager = getFragmentManager();
        if(flags == FragmentManager.POP_BACK_STACK_INCLUSIVE){
            fragmentManager.popBackStack(id,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }else{
            fragmentManager.popBackStack(id,0);
        }
    }

    /**
     *立即执行回退到上一个页面
     * @return 如果有Fragment页面可以返回则返回true,否则返回false
     */
    @Override
    public boolean popBackStackImmediate(){
        FragmentManager fragmentManager = getFragmentManager();
        return fragmentManager.popBackStackImmediate();
    }

    /**
     *
     * @param id
     * @param flags
     * @return
     */
    @Override
    public  boolean popBackStackImmediate(int id, int flags){
        FragmentManager fragmentManager = getFragmentManager();
        boolean result = false;
        if(flags == FragmentManager.POP_BACK_STACK_INCLUSIVE){
            result = fragmentManager.popBackStackImmediate(id,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }else{
            result = fragmentManager.popBackStackImmediate(id, 0);
        }
        return result;
    }

    /**
     *
     * @param name
     * @param flags
     * @return
     */
    @Override
    public  boolean popBackStackImmediate(String name, int flags){
        FragmentManager fragmentManager = getFragmentManager();
        boolean result = false;
        if(name != null){
            if(flags == FragmentManager.POP_BACK_STACK_INCLUSIVE){
                result = fragmentManager.popBackStackImmediate(name,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }else {
                result = fragmentManager.popBackStackImmediate(name,0);
            }
        }
        return result;
    }

    /**
     *
     * @param mTargetFrament
     * @return
     */
    @Override
    public boolean closeFragment(Fragment mTargetFrament){
        if(mTargetFrament != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(mTargetFrament);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    /**
     *
     */
    @Override
    public void closeAllFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        int backStackCount = fragmentManager.getBackStackEntryCount();
        for (int i=0; i < backStackCount; i++){
            int backStackId = fragmentManager.getBackStackEntryAt(i).getId();
            fragmentManager.popBackStack(backStackId,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
//        int backStackId = fragmentManager.getBackStackEntryAt(0).getId();
//        fragmentManager.popBackStack(backStackId,FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

}
