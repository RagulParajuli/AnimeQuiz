### Here's a breakdown of the provided Android project in bullet points:

## 1. Main Components:
  # MainActivity:
  **Purpose:** 
    Entry point of the app.
  **Functionality:** 
    Displays an introductory video using a VideoView with looping.
    Provides a button to start the quiz.
  # QuizActivity:
  **Purpose:** 
    Main activity for quiz selection.
  **Functionality:**
    Contains image views representing different anime options (Naruto, AOT, COTE, Haikyuu).
    Clicking an image starts a specific quiz using Intent.
  # AotActivity, CoteActivity, HaikyuuActivity, NarutoActivity:
  **Purpose:** 
    Individual quiz activities for AOT, COTE, Haikyuu, and Naruto.
  **Functionality:**
    Displays questions and answer options.
    Handles user interaction for answering questions.
    Provides real-time feedback on scores.
    Displays a result dialog with correct answers and an option to restart the quiz.
## 2. Quiz Logic:
  Each quiz activity uses an array of questions, choices, and correct answers (e.g., Aotqns, Coteqns, Haikyuuqns, Narutoqns).
  Users select an answer by clicking on one of the provided options.
  The app keeps track of the user's score.
  Upon completing the quiz, a dialog shows the user's score, their answers, and the correct answers.

## 3. Video Playback:
  The VideoView in the MainActivity plays an introductory video.
  A MediaController is used for video playback control.
  The video is set to loop indefinitely.

##4. App Flow:
  **Launch:**
    The app starts with the MainActivity, playing an introductory video.
    Users can click a button to proceed to the quiz.
    
  **Quiz Selection:**
    The QuizActivity displays anime options.
    Users can select an anime to start a specific quiz.
    
  **Quiz Interaction:**
    Users answer questions in quiz activities (AotActivity, CoteActivity, etc.).
    Real-time feedback is given for each question.

  **Quiz Completion:**
    After completing the quiz, a result dialog is displayed.
    The user can view their score, the correct answers, and has the option to restart the quiz.

## 5. Resource Usage:
  The app utilizes video and other resources from the res/raw directory.

## 6. Overall:
  The app aims to engage users with an anime quiz, offering an introductory video and individual quizzes for specific anime series.
  The modular design allows for easy addition of new quizzes.
  The user experience includes multimedia elements and interactive quiz features.

## Note:
  The completeness of the explanation depends on the entire codebase and potential external dependencies, which are not provided here.

### Some of the sample Screensots of app:
<img src="https://github.com/RagulParajuli/AnimeQuiz/assets/117198787/4eb5499c-52ca-463e-8a84-aeeae5df818c" height="400" width="200" /> 
<img src="https://github.com/RagulParajuli/AnimeQuiz/assets/117198787/378dc13e-993c-4632-bf2b-fa4f61da1540" height="400" width="200" />  
<img src="https://github.com/RagulParajuli/AnimeQuiz/assets/117198787/728e91af-cbeb-4245-8084-f9bf49f0351e" height="400" width="200" />  
<img src="https://github.com/RagulParajuli/AnimeQuiz/assets/117198787/0e294074-336c-4426-a5a8-8e59ea975921" height="400" width="200" />  
