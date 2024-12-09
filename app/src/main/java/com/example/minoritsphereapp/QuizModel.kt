package com.example.minoritsphereapp

data class QuizModel(
    val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val time: String = "",
    val questionList: List<QuestionModel> = listOf()
)

data class QuestionModel(
    val question: String = "",
    val options: List<String> = listOf(),
    val correct: String = ""
)
