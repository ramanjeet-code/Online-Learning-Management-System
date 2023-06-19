package Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "enrollment_id", nullable = false)
	    private Enrollment enrollment;

	    @Column(nullable = false)
	    private int score;
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public Grade(Enrollment enrollment, int score) {
		this.enrollment = enrollment;
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", enrollment=" + enrollment + ", score=" + score + ", getId()=" + getId()
				+ ", getEnrollment()=" + getEnrollment() + ", getScore()=" + getScore() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
