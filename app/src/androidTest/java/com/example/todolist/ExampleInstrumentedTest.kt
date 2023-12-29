package com.example.todolist

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.todolist", appContext.packageName)
    }

    @Test
    fun testNewTaskButton() {
        // Click on the new task button
        Espresso.onView(ViewMatchers.withId(R.id.newTaskButton)).perform(ViewActions.click())
        // Check if the dialog is displayed
        Espresso.onView(ViewMatchers.withText("New Task")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testRecyclerView() {
        // Check if the RecyclerView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.todoListRecycleView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testEditTaskItem() {
        // Create a sample TaskItem for testing
        val sampleTaskItem = TaskItem(name = "sample", desc = "Sample Task", completedDateString = "", dueTimeString = "12:30")

        // Call editTaskItem with the sample TaskItem
        activityScenarioRule.scenario.onActivity { activity ->
            activity.editTaskItem(sampleTaskItem)
        }

        // Verify that the NewTaskSheet dialog is displayed
        Espresso.onView(ViewMatchers.withText("Edit Task")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}