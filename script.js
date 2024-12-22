document.addEventListener("DOMContentLoaded", () => {
    const learnMoreButton = document.querySelector(".hero button");
    const navLinks = document.querySelectorAll("header nav a");

    learnMoreButton.addEventListener("click", () => {
        document.getElementById("about").scrollIntoView({ behavior: "smooth" });
    });

    navLinks.forEach(link => {
        link.addEventListener("click", (e) => {
            e.preventDefault();
            const targetId = link.getAttribute("href").substring(1);
            document.getElementById(targetId).scrollIntoView({ behavior: "smooth" });
        });
    });
});
