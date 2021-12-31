package com.hosseinzafari.github.app.work2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.hosseinzafari.github.app.work2.adapter.ActiveLessonAdapter
import com.hosseinzafari.github.app.work2.adapter.ActiveStepAdapter
import com.hosseinzafari.github.app.work2.model.ActiveModel
import com.hosseinzafari.github.app.work2.model.StepModel

class MainActivity : AppCompatActivity() {
    private val stepAdapter = ActiveStepAdapter(this)
    private val activeAdapter = ActiveLessonAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setupViews()
        populateData()
    }

    fun populateData() {
        stepAdapter.stepData = getStepData()
        activeAdapter.data = getActiveData()
    }

    fun setupViews() {
        val rv_active_lesson = findViewById<RecyclerView>(R.id.rv_active_lesson)
        val rv_lesson_step   = findViewById<RecyclerView>(R.id.rv_lesson_step)
        rv_active_lesson.adapter = activeAdapter
        rv_lesson_step.adapter   = stepAdapter

    }


    fun getStepData() = listOf(
        StepModel(1),
        StepModel(2),
        StepModel(3),
        StepModel(4),
        StepModel(5),
        StepModel(6),
        StepModel(7),
        StepModel(8),
        StepModel(9),
        StepModel(10),
        StepModel(11),
        StepModel(12),
    )

    fun getActiveData() = listOf(
        ActiveModel(1 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
        ActiveModel(2 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
        ActiveModel(3 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
        ActiveModel(4 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
        ActiveModel(5 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
        ActiveModel(6 , "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown"),
    )
}