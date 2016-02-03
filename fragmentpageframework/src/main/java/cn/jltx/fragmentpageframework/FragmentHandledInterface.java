package cn.jltx.fragmentpageframework;

import android.app.Fragment;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年02月02日.
 */

public interface FragmentHandledInterface {

    void setSelectedFragment(BackHandledFragment selectedFragment);

    int setFirstFragmentPage(int fragmentContainerId, Fragment fragment);

    int addFragmentPageToFrameWork(int fragmentContainerId, Fragment fragment, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    int addFragmentPageToFrameWork(int fragmentContainerId, Fragment fragment, String tag, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    void removeFragmentPageFromFrameWork(Fragment fragment);

    int popFragmentPageToFrameWorkFromTop(int fragmentContainerId, Fragment to, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    int popFragmentPageToFrameWorkFromTop(int fragmentContainerId, Fragment to, int enter, int exit, boolean isAddStack);

    int popFragmentPageToFrameWorkFromTop(int fragmentContainerId, Fragment to, String tag, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    int popFragmentPageToFrameWorkFromTop(int fragmentContainerId, Fragment to, String tag, int enter, int exit, boolean isAddStack);

    int popFragmentPageToFrameWork(int fragmentContainerId, Fragment from, Fragment to, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    int popFragmentPageToFrameWork(int fragmentContainerId, Fragment from, Fragment to, int enter, int exit, boolean isAddStack);

    int popFragmentPageToFrameWork(int fragmentContainerId, Fragment from, Fragment to, String tag, int enter, int exit, int popEnter, int popExit, boolean isAddStack);

    int popFragmentPageToFrameWork(int fragmentContainerId, Fragment from, Fragment to, String tag, int enter, int exit, boolean isAddStack);

    void popBackStack();

    void popBackStack(String name, int flags);

    void popBackStack(int id, int flags);

    boolean popBackStackImmediate();

    boolean popBackStackImmediate(int id, int flags);

    boolean popBackStackImmediate(String name, int flags);

    boolean closeFragment(Fragment mTargetFrament);

    void closeAllFragment();


}
