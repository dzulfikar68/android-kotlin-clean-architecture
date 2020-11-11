package id.refactory.myapplication.ui.main

//import org.junit.Assert
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.robolectric.Robolectric
//import org.robolectric.RobolectricTestRunner
//import org.robolectric.Shadows
//import org.robolectric.annotation.Config
//
//@RunWith(RobolectricTestRunner::class)
//@Config(manifest=Config.NONE, application = MyApplication::class)
//class MainActivityTest {
//
//    @Test
//    fun `Click Show detail button should show Toast with valid city name`() {
//        val mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
//        mainActivity.detail_btn.performClick()
//        val toasts = Shadows.shadowOf(mainActivity.application).shownToasts
//
//        Assert.assertEquals(true, toasts.size > 0)
//    }
//}