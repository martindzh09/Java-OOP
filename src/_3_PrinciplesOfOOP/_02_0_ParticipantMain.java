package _3_PrinciplesOfOOP;

import java.util.Scanner;

class _02_0_ParticipantMain {
    // Main method
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // I. Junior participant
        System.out.println("\n" + "What is the name of the Junior student?");
        _02_Participant junior = new _02_1_JuniorParticipant(scr.nextLine());

        // "junior" instance of (static) inner class
        _02_Competition.ScoreCalculator juniorCompetitor = new _02_Competition.ScoreCalculator();
        juniorCompetitor.calculateScoreInfo(junior);

        // II. High school student participant
        System.out.println("\n" + "What is the name of the High school student?");
        _02_Participant highSchoolStudent = new _02_2_HighSchoolParticipant(scr.nextLine());

        // "high school student" instance of (static) inner class
        _02_Competition.ScoreCalculator highStudentCompetitor = new _02_Competition.ScoreCalculator();
        highStudentCompetitor.calculateScoreInfo(highSchoolStudent);

        // III. College student (university)
        System.out.println("\n" + "What is the name of the College student?");
        _02_Participant collegeStudent = new _02_3_UniversityParticipant(scr.nextLine());

        // "college student" instance of (static) inner class
        _02_Competition.ScoreCalculator collegeCompetitor = new _02_Competition.ScoreCalculator();
        collegeCompetitor.calculateScoreInfo(collegeStudent);

        scr.close();
    }
}