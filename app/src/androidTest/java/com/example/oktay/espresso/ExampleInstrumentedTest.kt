package com.example.oktay.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Test

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.oktay.espresso", appContext.packageName)
    }

    @Test
    fun checkActivityVisibility(){
        onView(withId(R.id.home_fragment))
            .check(matches(isDisplayed()))
    }

    //checking "this is home fragment" message
    @Test
    fun checkingTextVisibility(){

        onView(withId(R.id.text_home))
            .check(matches(isDisplayed()))

        onView(withId(R.id.text_home))
            .check(matches(withText(R.string.text_home)))

    }

    // open dashboard page and check elements
    @Test
    fun navigateToDashboard(){

        onView(withId(R.id.navigation_dashboard))
            .perform(click())

        onView(withId(R.id.dashboard_fragment))
            .check(matches(isDisplayed()))

        onView(withId(R.id.text_dashboard))
            .check(matches(isDisplayed()))

        onView(withId(R.id.text_dashboard))
            .check(matches(withText(R.string.text_dashboard)))

    }


}