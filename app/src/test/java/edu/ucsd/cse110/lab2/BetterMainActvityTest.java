package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActvityTest {

    @Test
    public void test_one_plus_one_is_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(act -> {
            Button btn1 = act.findViewById(R.id.btn_one);
            Button btnAdd = act.findViewById(R.id.btn_plus);
            Button btnRes =act.findViewById(R.id.btn_equals);
            btn1.performClick();
            btnAdd.performClick();
            btn1.performClick();
            btnRes.performClick();
            TextView res = act.findViewById(R.id.display);
            assertEquals("2", res.getText().toString());
        });
    }
}
