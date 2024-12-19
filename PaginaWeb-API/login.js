document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar el envío del formulario

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Validar los campos (puedes personalizar esta parte)
    if (!email || !password) {
        alert("Por favor, llena todos los campos.");
        return;
    }

    // Expresiones regulares para verificar los formatos de los correos
    const regexAlumno = /^2024_([a-zA-Z]+)\.([a-zA-Z]+)@iticbcn\.cat$/; // Formato alumno
    const regexProfesor = /^([a-zA-Z]+)\.([a-zA-Z]+)@iticbcn\.cat$/; // Formato profesor
    const regexAdmin = /^admin@iticbcn\.cat$/; // Expresión regular para el admin

    // Comprobar si el email es del formato de admin, alumno o profesor
    if (regexAdmin.test(email)) { 
        window.location.href = 'admin.html'; // Redirigir al HTML del administrador
    } else if (regexAlumno.test(email)) {
        // Redirigir al HTML del alumno si el correo es válido
        window.location.href = 'inicioAlumno.html'; // Reemplaza con la URL de la página del alumno
    } else if (regexProfesor.test(email)) {
        // Redirigir al HTML del profesor si el correo es válido
        window.location.href = 'inicioProfesor.html'; // Reemplaza con la URL de la página del profesor
    } else {
        // Si el correo no coincide con ninguno de los formatos, mostrar un mensaje de error
        alert("El correo electrónico no es válido.");
    }

    // Simular envío del formulario
    console.log("Email:", email);
    console.log("Password:", password);
});
