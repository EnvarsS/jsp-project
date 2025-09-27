document.addEventListener('DOMContentLoaded', () => {
    const textElement = document.getElementById('sceneText');
    const text = textElement.textContent;
    textElement.textContent = '';
    let i = 0;

    function typeWriter() {
        if (i < text.length) {
            textElement.textContent += text.charAt(i);
            i++;
            setTimeout(typeWriter, 10);
        }
    }

    typeWriter();
});
