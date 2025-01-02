Regex Highlighter
This Kotlin application uses Jetpack Compose for Desktop to create an interactive GUI that highlights text matching a user-defined regular expression. The app allows users to input a regex pattern and dynamically highlights matches within a static text string.

Features
Dynamic Regex Matching: Enter a regex pattern, and the app highlights all matching substrings within the static text.
Interactive UI: Built with Jetpack Compose for Desktop, the app provides a modern, responsive interface.
Live Feedback: Matches are highlighted in real-time as the user types their regex pattern.
Preview
<!-- Replace with an actual image or GIF showing the application -->

Getting Started
Prerequisites
Kotlin: Ensure you have Kotlin installed on your system.
Jetpack Compose for Desktop: This project uses Compose for Desktop, so you'll need an environment set up for running Compose apps.

Open the project in your preferred IDE (e.g., IntelliJ IDEA).
Ensure that your project SDK and dependencies are correctly configured.
Running the Application
Execute the main function in the Main.kt file.
The application window will open, displaying the static text and an input field for the regex.
Usage
Enter a regex pattern in the text field.
Matches in the static text will be highlighted with a yellow background.
Code Overview
Key Components
myString: A composable function that builds and displays the highlighted text based on the regex matches.
myTextfield: A composable for the user input field.
App: The main composable that ties the components together, including the regex processing and UI rendering.
main: The entry point for the application.
Highlighting Logic
The highlighting logic is implemented in the myString function using AnnotatedString. It:

Iterates through all matches found by the regex.
Applies a yellow background to the matching substrings.
Ensures unmatched portions of the text remain in their default style.
Dependencies
Jetpack Compose for Desktop
Kotlin standard library
