// Manejo del botón para mostrar/ocultar el menú
const menuToggle = document.querySelector('.menu-toggle');
const menuItems = document.querySelector('#menu-items');

// Alternar entre mostrar u ocultar el menú
menuToggle.addEventListener('click', () => {
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
            window.location.href = 'marcaje.html';
        } else if (item.id === 'logout-btn') {
            window.location.href = 'login.html'; // Cambiar ruta si es necesario
        }
    });
});

// Manejo de clic en los botones de asistencia para cambiar entre ✅ y ❌
document.querySelectorAll('.attendance-button').forEach(button => {
    button.addEventListener('click', () => {
        // Cambiar el texto del botón entre ✅ y ❌
        if (button.textContent === '✅') {
            button.textContent = '❌'; // Cambiar a ❌ si estaba ✅
        } else {
            button.textContent = '✅'; // Cambiar a ✅ si estaba ❌
        }
    });
});

// Manejo del clic en los botones "Guardar" para modificar asistencia y retraso
document.querySelectorAll('.save-button').forEach(button => {
    button.addEventListener('click', (event) => {
        const row = event.target.closest('tr'); // Encontrar la fila correspondiente
        const studentName = row.cells[0].textContent; // Obtener el nombre del estudiante
        const attendance = row.querySelector('.attendance-button').textContent; // Obtener el estado de la asistencia
        const delay = row.querySelector('.delay-input').value; // Obtener el retraso

        // Actualizar la fila con los datos modificados
        row.dataset.attendance = attendance; // Actualiza los datos internos de la fila (si necesitas)
        row.dataset.delay = delay; // Actualiza los datos internos de la fila (si necesitas)

        // Confirmar que se ha guardado la fila
        alert(`Asistencia de ${studentName} modificada: ${attendance}, Retraso: ${delay} minutos`);
    });
});

// Manejo del botón global "Guardar Modificaciones"
const saveModificationsButton = document.querySelector('.save-modifications-button');

saveModificationsButton.addEventListener('click', () => {
    const rows = document.querySelectorAll('.attendance-table tbody tr'); // Selecciona todas las filas

    // Iterar por todas las filas y capturar datos
    rows.forEach(row => {
        const studentName = row.cells[0].textContent; // Obtener el nombre del estudiante
        const attendance = row.querySelector('.attendance-button').textContent; // Obtener el estado de la asistencia
        const delay = row.querySelector('.delay-input').value; // Obtener el retraso

        // Actualizar visualmente en el HTML los valores
        row.dataset.attendance = attendance; // Guardar asistencia en dataset
        row.dataset.delay = delay; // Guardar retraso en dataset

        // Mostrar en consola (puedes quitar esto)
        console.log(`Asistencia de ${studentName}: ${attendance}, Retraso: ${delay} minutos`);
    });

    // Confirmar cambios globales
    alert('Todas las modificaciones han sido guardadas.');
});
