const form = document.getElementById("studentForm");
const message = document.getElementById("message");

form.addEventListener("submit", async function (event) {
    event.preventDefault();

    const student = {
        name: document.getElementById("name").value,
        skills: document.getElementById("skills").value,
        interests: document.getElementById("interests").value
    };

    try {
        // Save student
        const saveResponse = await fetch(
            "http://localhost:8080/api/students",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(student)
            }
        );

        if (!saveResponse.ok) {
            message.textContent = "Could not save student.";
            return;
        }

        // Career recommendation
        const recommendationResponse = await fetch(
            "http://localhost:8080/api/students/recommend",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(student)
            }
        );

        const career = await recommendationResponse.text();

        // Project idea
        const projectResponse = await fetch(
            "http://localhost:8080/api/students/project",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(student)
            }
        );

        const projectIdea = await projectResponse.text();

        // Learning roadmap
        const roadmapResponse = await fetch(
            "http://localhost:8080/api/students/roadmap",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(student)
            }
        );

        const roadmap = await roadmapResponse.text();

        // Display results as cards
        message.innerHTML = `
            <div class="result-box">
                <h3>🚀 Career Recommendation</h3>
                <p><strong>${career}</strong></p>
            </div>

            <div class="result-box">
                <h3>📚 Skills to Learn</h3>
                <p>${getSkills(career)}</p>
            </div>

            <div class="result-box">
                <h3>💡 Project Idea</h3>
                <p>${projectIdea}</p>
            </div>

            <div class="result-box">
                <h3>🗺️ Learning Roadmap</h3>
                <p>${roadmap}</p>
            </div>
        `;

        form.reset();

    } catch (error) {
        message.textContent =
            "Could not connect to CareerBuddy backend.";
        console.error(error);
    }
});

function getSkills(career) {

    if (career.includes("Software Developer")) {
        return "Java, Spring Boot, SQL, Git, Data Structures";
    }

    if (career.includes("Data Scientist")) {
        return "Python, SQL, Statistics, Pandas, Data Visualization";
    }

    if (career.includes("AI / ML Engineer")) {
        return "Python, Machine Learning, APIs, AI Fundamentals";
    }

    if (career.includes("Cybersecurity")) {
        return "Networking, Linux, Security Fundamentals, Python";
    }

    if (career.includes("Full-Stack Web Developer")) {
        return "HTML, CSS, JavaScript, React, Spring Boot";
    }

    return "Programming Fundamentals, SQL, Git, Problem Solving";
}