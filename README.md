DexProtector (https://dexprotector.com) is one of the **pioneers** in **mobile application and library shielding**. It protects and obfuscates Android and iOS applications and libraries. Our solution helps you to secure your code and assets against unauthorized or illegal use, tampering, reverse engineering, and cracking.

# Environment Checks

This sample is to demonstrate how Environment Checks mechanism works. 

## Description
https://dexprotector.com/docs#environment-checks-and-device-attestation

## Requirements
- Android Studio or Gradle
- DexProtector Enterpise with a valid license

## Configuring 
- Set path to Android SDK in local.properties
- Set path to DexProtector Enterprise in build.gradle (project’s root) instead of `/Users/developer/DexProtector`

## Building
Open the project in Android Studio and execute `Build -> Generate Signed APK..` command or execute `gradle clean assemble` from the command line. A protected APK file will be placed into `app/app-release.apk` if you use Android Studio, if you use gradle via command line a protected file will be available at `app/build/outputs/app-release.apk`. Either approach you use, we refer to the protected file as `app-release.apk` below.

## Evaluating
> Note: All the actions are to be performed from the project's root
