// Manejo del menú lateral
const menuToggle = document.querySelector('.menu-toggle');
const menuItems = document.querySelector('#menu-items');

// Mostrar u ocultar el menú al hacer clic en el botón
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
        } else if (item.id === 'horario-btn') {
            window.location.href = 'horarioProfesor.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'gestion-btn') {
            window.location.href = 'asistencia.html'; // Cambiar ruta si es necesario
        } else if (item.id === 'marcaje-btn') {
            window.location.href = 'marcaje.html'; // Cambiar ruta si es necesario    
        } else if (item.id === 'logout-btn') {
            window.location.href = 'login.html'; // Cambiar ruta si es necesario
        }
    });
});

// Manejo del botón de notificaciones
const notificationIcon = document.querySelector('.header-icons .icon:nth-child(1)');
if (notificationIcon) {
  notificationIcon.addEventListener('click', () => {
    alert('No tienes nuevas notificaciones.');
  });
}

// Manejo del perfil
const profileIcon = document.querySelector('.header-icons .icon:nth-child(3)');
if (profileIcon) {
  profileIcon.addEventListener('click', () => {
    alert('Accediendo a tu perfil...');
  });
}

// Generar dinámicamente cursos
const courses = [
  { module: 'Módulo M1: Base de Datos' },
  { module: 'Módulo M3: EIE'},
  { module: 'Módulo M5: Acceso a Datos'},
  { module: 'Módulo M12: Montaje'},
  { module: 'GS: Tutoría'},
];

function renderCourses() {
  const coursesContainer = document.querySelector('#courses-container');
  if (!coursesContainer) {
    console.error("No se encontró el contenedor de cursos en el DOM.");
    return;
  }

  const coursesList = courses.map(
    (course) =>
      `<div class="course">
        <h3>${course.module}</h3>
      </div>`
  );
  coursesContainer.innerHTML = coursesList.join('');
}

// Llamar a la función cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', () => {
  renderCourses();
});
