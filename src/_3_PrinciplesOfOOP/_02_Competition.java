package _3_PrinciplesOfOOP;

class _02_Competition {
    // nested (inner) static class 2.1
    static class ScoreCalculator {

        // inner method, accepting object parameter
        void calculateScoreInfo(_02_Participant participant) {
            // data for each participant (inheritors of abstract class 1 "Participant")
            System.out.printf("%nName: %s%n", participant.participantName);
            System.out.printf("Result formation: %s%n", participant.getScoreDescription());
        }
    }
}