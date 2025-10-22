const form = document.getElementById('contactForm');
const status = document.getElementById('status');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    status.textContent = 'Sending...';

    const data = {
        name: e.target.name.value,
        email: e.target.email.value,
        message: e.target.message.value
    };

    try {
        const res = await fetch('http://localhost:8081/api/contact', {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(data)
        });

        if (res.ok) {
            const json = await res.json();
            status.textContent = 'Saved. id=' + json.id;
            form.reset();
        } else {
            status.textContent = 'Error: ' + res.status;
        }
    } catch (err) {
        status.textContent = 'Network error: ' + err.message;
    }
});
