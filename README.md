# JobCompare — Android Job Comparison App

**Android app** built as a team project at Georgia Tech (Spring 2022). 
I contributed most of the app logic, UI, and overall design (excluding direct database setup/management).

## 🎯 What it does

JobCompare helps users compare multiple job offers (or current job) based on customizable criteria (e.g. salary, bonus, work-life balance, cost of living).  
It computes a weighted “score” for each offer and lets the user compare offers side-by-side to make more informed decisions.

## ✅ Key Features

- Add or edit job offers / current job information  
- Customize weight preferences for different criteria  
- Ranking algorithm to score and sort job offers  
- Compare two or more offers visually  
- Simple and clean UI, intuitive navigation  
- Offline support (local storage of job offers)  

## 🛠 Tech Stack & Architecture

| Layer / Component | Technology / Approach |
|------------------|----------------------|
| Language | Java |
| UI / Layout | XML (Android standard UI) |
| Architecture | MVC / custom structure (Activities + plain Java Model) |
| Data & Persistence | File-based or simple local storage (original design) — **candidate for future upgrade to database** (see “Future Improvements”) |
| Build | Gradle + Android Studio 2025 (updated) |
| Minimum SDK / Target SDK | (as configured in `app/build.gradle`) |

## 👨‍💻 My Contributions

- Designed and implemented most of the app’s Activities / UI flows (job input, job list, comparison view, settings, navigation)  
- Wrote the core data model (`JobOffer.java`, other model classes) and the ranking algorithm logic  
- Implemented user interactions, input validation, sorting/comparison logic, and UI updates  
- Refactored code after environment update (2025 Android Studio + Gradle) to ensure the app can build now  
- General project cleanup, configuration, and repository setup for GitHub exposure  

## 📋 How to Run / Build

```bash
git clone https://github.com/enzo-qin/JobCompare.git
open in Android Studio Narwhal 2025
let Gradle sync, then run on emulator or device
