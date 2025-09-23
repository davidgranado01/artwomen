document.addEventListener("DOMContentLoaded", function () {
    const includes = document.querySelectorAll("[data-include]");
    includes.forEach(el => {
        const file = el.getAttribute("data-include");
        fetch(file)
            .then(res => res.text())
            .then(html => {
            el.innerHTML = html;
        })
            .catch(err => {
            console.error("Error loading include:", err);
        });
    });
});
