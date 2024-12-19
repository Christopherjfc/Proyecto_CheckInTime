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
  { module: 'Módulo M3: Programación', professor: 'Juan Pérez' },
  { module: 'Módulo M6: Desarrollo web cliente', professor: 'María López' },
  { module: 'Módulo M7: Desarrollo web servidor', professor: 'Ana Sánchez' },
  { module: 'Módulo M8: Aplicación web', professor: 'Luis Fernández' },
  { module: 'Módulo M14: Bioinformática', professor: 'Carmen Martínez' },
  { module: 'GS: Tutoría', professor: 'Roberto García' },
  { module: 'GS: Proyecto', professor: 'Laura González' },
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
        <p>Profesor/a: ${course.professor}</p>
      </div>`
  );
  coursesContainer.innerHTML = coursesList.join('');
}

// Llamar a la función cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', () => {
  renderCourses();
});
