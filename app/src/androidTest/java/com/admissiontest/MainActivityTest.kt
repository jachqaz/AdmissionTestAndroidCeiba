package com.admissiontest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.admissiontest.ui.main.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain


@HiltAndroidTest
class MainActivityTest {

    private val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val rule: RuleChain = RuleChain
        .outerRule(hiltRule)
        .around(activityTestRule)

    @Test
    fun isDisplayedTilSearch() {
        onView(withId(R.id.tilSearch)).check(matches(isDisplayed()))
    }

    @Test
    fun isDisplayedEtSearch() {
        onView(withId(R.id.etSearch)).check(matches(isDisplayed()))
    }

    @Test
    fun isDisplayedRvUser() {
        onView(withId(R.id.rvUser)).check(matches(isDisplayed()))
    }

}
