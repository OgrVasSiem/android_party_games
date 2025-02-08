package com.ogrvassiem.partygames.aplication.readModels

data class TopicsResponse(
    val topics: List<Topics>
) {
    data class Topics(
        val name: String,
        val color: String,
        val freeTopic: Boolean,
        val storeID: String?,
        val image: String,
        val description: String?,
        val words: List<Complexity>
    ) {
        data class Complexity(
            val easy: List<String>,
            val medium: List<String>,
            val hard: List<String>,
        )
    }
}
