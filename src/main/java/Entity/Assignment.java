package Entity;
import java.time.LocalDate;

import jakarta.persistence.*;
@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = false)
    private LocalDate deadline;

	public Assignment() {
		
		// TODO Auto-generated constructor stub
	}

	public Assignment(Course course, String title, LocalDate startTime, LocalDate deadline) {
		this.course = course;
		this.title = title;
		this.startTime = startTime;
		this.deadline = deadline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", course=" + course + ", title=" + title + ", startTime=" + startTime
				+ ", deadline=" + deadline + "]";
	}
    
}