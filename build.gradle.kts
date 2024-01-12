// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false /*verify version compatibility between kotlin and compose here https://developer.android.com/jetpack/androidx/releases/compose-kotlin?hl=fr
    verify version compatibility kotlin Gradle here https://docs.gradle.org/current/userguide/compatibility.html
    to update gradle in android studio go to File -> project structur -> Project and choose Gradle version compatible with your kotlin version
    to update AGP go to Tool-> Upgrade assitante*/
    //compose destination plugins_________________________________
    //id ("com.google.devtools.ksp") version "1.8.10-1.0.9"
    /*
    * Depends on the kotlin version,if the kotlin version is upgraded make sur to change the version of this plugin.version compatibility in folowing link. https://github.com/google/ksp/releases
    * version number is composed of ( kotlin version number - Ksp version number ) comme suit : 1.8.10-1.0.9
    */
    //-----------------
}

dependencies {
    //compose destination dependencies ksp
    //ksp ("io.github.raamcosta.compose-destinations:ksp:1.8.42-beta")

}

