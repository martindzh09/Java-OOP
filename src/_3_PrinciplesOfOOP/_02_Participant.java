package _3_PrinciplesOfOOP;

// Abstract class 1 (common behavior)
abstract class _02_Participant {
        String participantName;

        // abstract (common) method, defining each participant's score formation
        abstract String getScoreDescription();
}

// Inheritor 1.1 (implementation) of abstract class "Participant"
class _02_1_JuniorParticipant extends _02_Participant {

    // constructor (1.1)
    _02_1_JuniorParticipant(String participantName) {
        this.participantName = participantName;
    }

    // abstract method implementation (1.1)
    @Override
    String getScoreDescription() {
        return "[Score of students 5th - 7th grade is formed by solved tasks]";
    }
}

// Inheritor 2.1 (implementation) of abstract class "Participant"
class _02_2_HighSchoolParticipant extends _02_Participant {

    // constructor (2.1)
    _02_2_HighSchoolParticipant(String participantName) {
        this.participantName = participantName;
    }

    // abstract method implementation (2.1)
    @Override
    String getScoreDescription() {
        return  "[Score of students 8th - 12th grade is formed by solved tasks and "
                + "time of solving them]";
    }
}

// Inheritor 3.1 (implementation) of abstract class "Participant"
class _02_3_UniversityParticipant extends _02_Participant {

    // constructor (3.1)
    _02_3_UniversityParticipant(String participantName) {
        this.participantName = participantName;
    }

    // abstract method implementation (3.1)
    @Override
    String getScoreDescription() {
        return "[Score of college students is formed by specific grading system with bonuses]";
    }
}