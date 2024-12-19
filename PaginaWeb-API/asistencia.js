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
        if (item.id === 'inicio-btn') {
            window.location.href = 'inicioProfesor.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'gestion-btn') {
            window.location.href = 'asistencia.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'horario-btn') {
            window.location.href = 'horarioProfesor.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'marcaje-btn') {
            window.location.href = 'marcaje.html'; // Cambiar ruta si es necesario    
        } else if (item.id === 'logout-btn') {
            window.location.href = 'login.html'; // Cambiar ruta si es necesario
        }
    });
});

// Manejo del clic en el botón "Modificar"
const modifyButton = document.querySelector('.modify-button');
modifyButton.addEventListener('click', () => {
    // Redirige a otra página al hacer clic en el botón
    window.location.href = 'modificarAsistencia.html'; // Cambiar por la ruta deseada
});
