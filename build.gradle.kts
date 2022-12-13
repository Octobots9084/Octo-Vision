plugins {
    id("org.rivierarobotics.gradlerioredux") version "0.9.7"
}

afterEvaluate {
    tasks.withType<Jar>(){
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}}

gradleRioRedux {
    robotClass = "org.octobots.robot.Robot"
    teamNumber = 9084

    applyGradleRioConfiguration()
}



