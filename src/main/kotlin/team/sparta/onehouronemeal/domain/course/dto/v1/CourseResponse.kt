package team.sparta.onehouronemeal.domain.course.dto.v1

import team.sparta.onehouronemeal.domain.course.model.v1.Course
import java.time.LocalDateTime

data class CourseResponse(
    val id: Long,
    val chefId: Long,
    val title: String,
    val describe: String,
    val status: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun from(course: Course): CourseResponse {
            return CourseResponse(
                id = course.id!!,
                chefId = course.user.id!!,
                title = course.title,
                describe = course.describe,
                status = course.status.name,
                createdAt = course.createdAt,
                updatedAt = course.updatedAt
            )
        }
    }
}