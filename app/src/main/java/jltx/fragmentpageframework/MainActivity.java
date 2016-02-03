package jltx.fragmentpageframework;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cn.jltx.fragmentpageframework.FragmentPageActivity;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2016年01月29日.
 */
public class MainActivity extends FragmentPageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentTAB1 fragmentTAB1 = new FragmentTAB1();
            setFirstFragmentPage(R.id.fragment_cotainer,fragmentTAB1);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
