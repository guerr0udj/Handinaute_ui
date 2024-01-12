plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //compose destination plugins_________________________________
    id ("com.google.devtools.ksp") version "1.9.10-1.0.13"
    /*
    * Depends on the kotlin version,if the kotlin version is upgraded make sur to change the version of this plugin.version compatibility in folowing link. https://github.com/google/ksp/releases
    * version number is composed of ( kotlin version number - Ksp version number ) comme suit : 1.8.10-1.0.9
    */
}

//compose destination auto-generation folders____________

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
//__________________
android {
    namespace = "com.example.handinaute"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.handinaute"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" //"1.4.2" verify te latest stable version of compose here https://developer.android.com/jetpack/androidx/releases/compose-compiler?hl=fr
    // verify compatibility between kotlin and compose here https://developer.android.com/jetpack/androidx/releases/compose-kotlin?hl=fr
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    //implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    //implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    //implementation(platform("androidx.compose:compose-bom:2023.08.00"))
   // implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.compose.material:material-icons-extended")
    //compose destination dependencies implementation__________________________

    implementation("io.github.raamcosta.compose-destinations:core:1.9.57")
    //compose destination dependencies ksp
    ksp ("io.github.raamcosta.compose-destinations:ksp:1.9.57")

    //_________________________________________________________________________

}