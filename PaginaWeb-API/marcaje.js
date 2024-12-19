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

// Manejo de la búsqueda por ID de Alumno
document.getElementById('searchButton').addEventListener('click', function() {
    // Obtener el valor ingresado en el input de búsqueda
    const searchValue = document.getElementById('searchInput').value.trim();

    if (searchValue === '') {
        alert('Por favor, ingrese un ID para buscar.');
        return;
    }

    // Obtener todas las filas de la tabla
    const rows = document.querySelectorAll('table tbody tr');
    let found = false; // Bandera para verificar si se encontró el ID

    rows.forEach(row => {
        // Obtener el ID de alumno de la primera celda (columna)
        const studentId = row.cells[0].textContent;

        // Si el ID coincide con el valor de búsqueda, mostrar la fila
        if (studentId === searchValue) {
            row.style.display = ''; // Muestra la fila
            found = true; // Se encontró el ID
        } else {
            row.style.display = 'none'; // Oculta la fila
        }
    });

    if (!found) {
        alert('ID no encontrado');
    }
});
