# Appium Setup Guide (GUI Installation)

## Prerequisites

Before installing Appium, make sure you have the following prerequisites set up on your system:

1. **Java Development Kit (JDK)** - Make sure you have the JDK installed.
2. **Android SDK** - You need the Android SDK installed for Appium to work with Android devices.
3. **Maven** - Appium depends on Maven for building the project, so ensure you have it installed.
4. **Sample Mobile App** - For testing purposes, you will need to install the [Sample Mobile App](https://github.com/saucelabs/sample-app-mobile/releases) from Sauce Labs. This app is used for testing with Appium.
5. **Update the Property File** - In the `/src/main/resources/testdata.properties` file, update the following variable values according to your device:
    1.  `androidDeviceName`=Name of the desired device
    2.   `androidVersion`=Version of the desired device
   **For example** 
   ```properties
   androidDeviceName=Samsung Galaxy S24 Ultra
   androidVersion=14
   ```

These components should be installed and their respective environment variables (`JAVA_HOME`, `ANDROID_HOME`, `M2_HOME`) set on your system. You can set these environment variables through your system's GUI settings instead of doing it through the terminal. Here's how to do it:

### Setting System Environment Variables:

- **Windows:**
    1. Right-click on "This PC" or "Computer" and click "Properties".
    2. Select "Advanced system settings" and then click on "Environment Variables".
    3. Under "System Variables", click "New" to add the necessary variables:
        - **JAVA_HOME**: Path to your JDK installation.
        - **ANDROID_HOME**: Path to your Android SDK installation.
        - **M2_HOME**: Path to your Maven installation.
    4. Click "OK" to save the changes.

- **Mac/Linux:**
    1. Open your system settings for environment variables.
    2. Add the following to the `~/.bash_profile` or `~/.zshrc` (for zsh users) file:
       ```bash
       export JAVA_HOME=/path/to/your/jdk
       export ANDROID_HOME=/path/to/your/android/sdk
       export M2_HOME=/path/to/your/maven
       ```
    3. Save the file and restart the terminal or run `source ~/.bash_profile` (or `source ~/.zshrc`).

Once these environment variables are properly set, you can move ahead with the Appium installation process.

## Installing Appium (GUI Installation)

Follow these steps to install Appium using the GUI installer:

1. **Download Appium Desktop:**
    - Go to the [Appium GitHub Releases page](https://github.com/appium/appium-desktop/releases).
    - Download the latest stable version of the Appium Desktop installer for your operating system (Windows, macOS, or Linux).

2. **Run the Installer:**
    - On **Windows**: Run the `.exe` installer and follow the on-screen instructions to complete the installation.
    - On **macOS**: Open the `.dmg` file and drag the Appium app into the Applications folder.
    - On **Linux**: Extract the `.tar.gz` file and follow the setup instructions for your distribution.

3. **Launch Appium:**
    - Once installed, open the Appium Desktop application.
    - The Appium server should now be ready to use.

## Starting the Appium Server

1. Open the Appium Desktop application.
2. Click the "Start Server" button to launch the Appium server.
3. The Appium server should start successfully, and you’ll see the logs in the Appium Desktop window.

## Running the script via Maven

To run runner class via Maven, follow these steps:

1. **Navigate to your project root directory** in the terminal or command prompt.
2. **Open your terminal or command prompt** and type the following command:

   ```bash
   mvn test "-Dtest=AndroidRunnerClass.java"
3. **Demo video.**
![Watch the demo](demoVideo/demo.gif)

## Troubleshooting

If you encounter issues, check the following:

- Verify that the **Appium Server** is running.
- Ensure your **Android device** or **emulator** is connected and recognized by the `adb` tool.
- Check the system environment variables to ensure they are set correctly through the system GUI.
