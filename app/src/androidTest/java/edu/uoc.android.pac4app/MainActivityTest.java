package edu.uoc.android.pac4app;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.text.method.Touch;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Marc on 26/5/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mMainActivity;
    private Button mButtonStart;
    private TextView mTextViewTime;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Sets the initial touch mode for the Activity under test. This must be called before
        // getActivity()
        setActivityInitialTouchMode(true);

        // Get a reference to the Activity under test, starting it if necessary
        mMainActivity = getActivity();

        // Get references to all views
        mButtonStart = (Button) mMainActivity.findViewById(R.id.buttonStartCount);
        mTextViewTime = (TextView) mMainActivity.findViewById(R.id.textViewTime);
    }

    @MediumTest
    public void testPreconditions(){
        assertNotNull("mMainActivity is null", mMainActivity);
        assertNotNull("mButtonStart is null", mButtonStart);
        assertNotNull("mTextViewTime is null", mTextViewTime);
    }


    @MediumTest
    public void testClickButtonStart_lahyout(){
        final View decorView = mMainActivity.getWindow().getDecorView();

        ViewAsserts.assertOnScreen(decorView, mButtonStart);

        final ViewGroup.LayoutParams layoutParams = mButtonStart.getLayoutParams();
        assertNotNull(layoutParams);



        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @MediumTest
    public void testClickButtonStart_labelText(){
        final String expectedNextButtonText = mMainActivity.getString(R.string.activity_main_button_start);
        final String actualNextButtonText = mButtonStart.getText().toString();
        assertEquals(expectedNextButtonText, actualNextButtonText);
    }

    /** TEST FUNCIONAL **/
    @MediumTest
    public void testClickMeButton_clickButtonAndExpectInfoText(){
        String expectedInfoText = mMainActivity.getString(R.string.activity_main_button_stop);
        TouchUtils.clickView(this, mButtonStart);
        assertEquals(expectedInfoText, mButtonStart.getText());
    }
}
