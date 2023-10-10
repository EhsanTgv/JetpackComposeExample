package com.taghavi.jetpackcomposeexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.taghavi.jetpackcomposeexample.animation.Animation1Activity
import com.taghavi.jetpackcomposeexample.animation.Animation2Activity
import com.taghavi.jetpackcomposeexample.layout.LayoutModifierActivity
import com.taghavi.jetpackcomposeexample.material.AlertDialogActivity
import com.taghavi.jetpackcomposeexample.material.DrawerAppActivity
import com.taghavi.jetpackcomposeexample.stack.StackActivity
import com.taghavi.jetpackcomposeexample.state.ProcessDeathActivity
import com.taghavi.jetpackcomposeexample.state.StateActivity
import com.taghavi.jetpackcomposeexample.state.backpress.BackPressActivity
import com.taghavi.jetpackcomposeexample.state.coroutine.CoroutineFlowActivity
import com.taghavi.jetpackcomposeexample.state.livedata.LiveDataActivity
import com.taghavi.jetpackcomposeexample.text.CustomTextActivity
import com.taghavi.jetpackcomposeexample.text.SimpleTextActivity
import com.taghavi.jetpackcomposeexample.theme.DarkModeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimpleTextExample(view: View) {
        startActivity(Intent(this, SimpleTextActivity::class.java))
    }

    fun startCustomTextExample(view: View) {
        startActivity(Intent(this, CustomTextActivity::class.java))
    }

//    fun startVerticalScrollableExample(view: View) {
//        startActivity(Intent(this, VerticalScrollableActivity::class.java))
//    }
//
//    fun startHorizontalScrollableExample(view: View) {
//        startActivity(Intent(this, HorizontalScrollableActivity::class.java))
//    }
//
//    fun starLoadImageExample(view: View) {
//        startActivity(Intent(this, ImageActivity::class.java))
//    }

    fun startAlertDialogExample(view: View) {
        startActivity(Intent(this, AlertDialogActivity::class.java))
    }

    fun startDrawerExample(view: View) {
        startActivity(Intent(this, DrawerAppActivity::class.java))
    }

//    fun startButtonsExample(view: View) {
//        startActivity(Intent(this, ButtonActivity::class.java))
//    }

    fun startStateExample(view: View) {
        startActivity(Intent(this, StateActivity::class.java))
    }

//    fun startCustomViewExample(view: View) {
//        startActivity(Intent(this, CustomViewActivity::class.java))
//    }
//
//    fun startCustomViewPaintExample(view: View) {
//        startActivity(Intent(this, CustomViewPaintActivity::class.java))
//    }
//
//    fun startAutofillTextExample(view: View) {
//        startActivity(Intent(this, TextFieldActivity::class.java))
//    }

    fun startStackExample(view: View) {
        startActivity(Intent(this, StackActivity::class.java))
    }

//    fun startViewAlignExample(view: View) {
//        startActivity(Intent(this, ViewLayoutConfigurationsActivity::class.java))
//    }
//
//    fun startMaterialDesignExample(view: View) {
//        startActivity(Intent(this, MaterialActivity::class.java))
//    }
//
//    fun startFixedActionButtonExample(view: View) {
//        startActivity(Intent(this, FixedActionButtonActivity::class.java))
//    }
//
//    fun startConstraintLayoutExample(view: View) {
//        startActivity(Intent(this, ConstraintLayoutActivity::class.java))
//    }
//
//    fun startBottomNavigationExample(view: View) {
//        startActivity(Intent(this, BottomNavigationActivity::class.java))
//    }

    fun startAnimation1Example(view: View) {
        startActivity(Intent(this, Animation1Activity::class.java))
    }

    fun startAnimation2Example(view: View) {
        startActivity(Intent(this, Animation2Activity::class.java))
    }

//    fun startTextInlineContentExample(view: View) {
//        startActivity(Intent(this, TextAnimationActivity::class.java))
//    }
//
//    fun startListAnimation(view: View) {
//        startActivity(Intent(this, ListAnimationActivity::class.java))
//    }

    fun startThemeExample(view: View) {
        startActivity(Intent(this, DarkModeActivity::class.java))
    }

    fun startLayoutModifierExample(view: View) {
        startActivity(Intent(this, LayoutModifierActivity::class.java))
    }

    fun startProcessDeathExample(view: View) {
        startActivity(Intent(this, ProcessDeathActivity::class.java))
    }

    fun startLiveDataExample(view: View) {
        startActivity(Intent(this, LiveDataActivity::class.java))
    }

//    fun startFlowRowExample(view: View) {
//        startActivity(Intent(this, FlowRowActivity::class.java))
//    }
//
//    fun startShadowExample(view: View) {
//        startActivity(Intent(this, ShadowActivity::class.java))
//    }

    fun startCoroutineFlowExample(view: View) {
        startActivity(Intent(this, CoroutineFlowActivity::class.java))
    }

//    fun startComposeWithClassicAndroidExample(view: View) {
//        startActivity(Intent(this, ComposeInClassicAndroidActivity::class.java))
//    }
//
//    fun startMeasuringScaleExample(view: View) {
//        startActivity(Intent(this, MeasuringScaleActivity::class.java))
//    }

    fun startBackPressExample(view: View) {
        startActivity(Intent(this, BackPressActivity::class.java))
    }

//    fun startZoomableExample(view: View) {
//        startActivity(Intent(this, ZoomableActivity::class.java))
//    }
//
//    fun startComposeNavigationExample(view: View) {
//        startActivity(Intent(this, ComposeNavigationActivity::class.java))
//    }
}