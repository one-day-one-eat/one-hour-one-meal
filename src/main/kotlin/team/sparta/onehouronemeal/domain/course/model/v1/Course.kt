package team.sparta.onehouronemeal.domain.course.model.v1

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import team.sparta.onehouronemeal.domain.common.BaseTimeEntity
import team.sparta.onehouronemeal.domain.user.model.v1.User

@Entity
@Table(name = "course")
class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column var title: String,

    @Column var describe: String,

    @Enumerated(EnumType.STRING) var status: CourseStatus = CourseStatus.PENDING,

    @ManyToOne(fetch = FetchType.LAZY) var user: User

) : BaseTimeEntity() {
    fun isOpened() = status == CourseStatus.OPEN

    fun updateCourse(title: String, description: String) {
        this.title = title
        this.describe = describe
    }
}