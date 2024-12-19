// Manejo del botón para mostrar/ocultar el menú
const menuToggle = document.querySelector('.menu-toggle');
const menuItems = document.querySelector('#menu-items');

menuToggle.addEventListener('click', () => {
    // Alternar entre mostrar u ocultar el menú
    if (menuItems.style.display === 'none' || menuItems.style.display === '') {
        menuItems.style.display = 'block';
    } else {
        menuItems.style.display = 'none';
    }
});

// Manejo de clics en los elementos del menú lateral
document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('click', () => {
        // Redirección según el ID del elemento
        if (item.id === 'horario-btn') {
            window.location.href = 'horarioAlumno.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'inicio-btn') {
            window.location.href = 'inicioAlumno.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'asistencia-btn') {
            window.location.href = 'asistenciaAlumno.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'logout-btn') {
            window.location.href = 'login.html'; // Cambiar ruta si es necesario
        }
    });
});
