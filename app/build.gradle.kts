plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.t01_bucketlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.t01_bucketlist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Firebase bom
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    // Auth
    implementation("com.google.firebase:firebase-auth")

    implementation("com.google.android.gms:play-services-auth:21.0.0")

    //design dependencies..!
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    implementation("com.github.ismaeldivita:chip-navigation-bar:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("com.romandanylyk:pageindicatorview:1.0.3")

    // database
    implementation("com.google.firebase:firebase-database")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation("com.firebaseui:firebase-ui-storage:8.0.2")

    // Circle Image
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("com.google.firebase:firebase-storage")
}