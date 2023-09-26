package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Integer total = 0;
        Integer members = 0;
        for (String member: gradeDB.getMyTeam().getMembers()) {
            total += gradeDB.getGrade(member, "207").getGrade();
            members += 1;
        }
        return (float) total / members;
    }
}
